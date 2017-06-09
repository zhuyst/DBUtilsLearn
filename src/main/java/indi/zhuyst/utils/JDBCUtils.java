package indi.zhuyst.utils;

import indi.zhuyst.dao.MyQueryRunner;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhuyst on 2017/5/31.
 */
public class JDBCUtils {

    private static BasicDataSource dataSource;
    private static MyQueryRunner queryRunner;
    static {
        if(dataSource == null){
            dataSource = new BasicDataSource();
        }

        Properties properties = new Properties();
        InputStream inputStream = JDBCUtils.class.getResourceAsStream("/jdbc.properties");
        try {
            properties.load(inputStream);
            dataSource.setDriverClassName(properties.getProperty("driver"));
            dataSource.setUrl(properties.getProperty("url"));
            dataSource.setUsername(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
            dataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
            dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
            dataSource.setMinIdle(Integer.parseInt(properties.getProperty("minIdle")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        queryRunner = new MyQueryRunner(dataSource);
    }

    public static MyQueryRunner getQueryRunner(){
        return queryRunner;
    }
}
