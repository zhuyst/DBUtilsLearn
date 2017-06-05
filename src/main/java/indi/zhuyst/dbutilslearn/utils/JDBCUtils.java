package indi.zhuyst.dbutilslearn.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by zhuyst on 2017/5/31.
 */
public class JDBCUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/dms?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String userName = "test";
    private static String password = "zhuyst";
    private static int initialSize = 5;
    private static int maxIdle = 20;
    private static int minIdle = 1;

    private static BasicDataSource dataSource;
    private static QueryRunner queryRunner;
    static {
        if(dataSource == null){
            dataSource = new BasicDataSource();
        }
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);

        queryRunner = new QueryRunner(dataSource);
    }

    public static QueryRunner getQueryRunner(){
        return queryRunner;
    }
}
