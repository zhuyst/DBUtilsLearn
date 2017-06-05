package indi.zhuyst.utils;

import indi.zhuyst.enums.SqlEnum;

import java.lang.reflect.Field;

/**
 * Created by zhuyst on 2017/6/5.
 * 用于处理Pojo的工具类
 */
public class PojoUtils {
    /**
     * 获取该Pojo的所有属性，将属性放入Object数组中
     * @param bean 要获取属性的对象
     * @param sqlEnum 当enum为INSERT时，按顺序获取Pojo中的属性，当enum为UPDATE时，将主键属性放至数组最后
     * @return 含对象所有属性的Object数组
     */
    public static Object[] getAttributes(Object bean, SqlEnum sqlEnum){
        Field[] fields = bean.getClass().getDeclaredFields();
        Object[] attributes = new Object[fields.length];

        for(int i = 0;i < fields.length;i++){
            fields[i].setAccessible(true);
            try {
                //当sqlEnum为INSERT时，按顺序将属性放入数组中
                if(sqlEnum.equals(SqlEnum.INSERT)){
                    attributes[i] = fields[i].get(bean);
                }
                //当sqlEnum为UPDATE时，将主键属性放至数组最后，其他按顺序前移1位
                else if(sqlEnum.equals(SqlEnum.UPDATE)){
                    if(i == 0){
                        attributes[fields.length - 1] = fields[i].get(bean);
                    }
                    else{
                        attributes[i - 1] = fields[i].get(bean);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return attributes;
    }

    /**
     * 辅助Dao层处理，将需要更新的属性更新进原来的Pojo中
     * @param bean 将被更新的对象
     * @param newBean 含有更新的新属性的对象
     * @return 更新完成的对象
     */
    public static Object updateBean(Object bean,Object newBean){
        //如果两个bean不是同一个类则无法执行更新
        if(!bean.getClass().isInstance(newBean)){
            try {
                throw new Exception("两个Bean并不是同一类的实例化对象");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Field[] fields = bean.getClass().getDeclaredFields();
        Field[] newFields = newBean.getClass().getDeclaredFields();

        for(int i = 0;i < fields.length;i++){
            fields[i].setAccessible(true);
            newFields[i].setAccessible(true);

            try {
                Object attribute = newFields[i].get(newBean);
                if(attribute != null){
                    fields[i].set(bean ,attribute);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}
