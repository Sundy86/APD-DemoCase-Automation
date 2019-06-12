package com.cccis.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by HePing on 2016/12/6.
 */
public class DbcpConnection {
    private static DataSource dataSource;
    private static DataSource dataSource2;

    private static Connection conn;
    private static Connection conn2;

    static {
        FileInputStream is = null;
        FileInputStream is2 = null;

        Properties properties = new Properties();
        Properties properties2 = new Properties();


        try {
            properties.load(DbcpConnection.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            properties2.load(DbcpConnection.class.getClassLoader().getResourceAsStream("dbcp2.properties"));
            dataSource= BasicDataSourceFactory.createDataSource(properties);
            dataSource2= BasicDataSourceFactory.createDataSource(properties2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                is2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public DbcpConnection() {
    }

    public static Connection getConnection() {
//        if(dataSource == null){
//            initDataSource();
//
//        }

        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

//    public static void initDataSource(){
//
//        FileInputStream is = null;
//        Properties properties = new Properties();
//
//        try {
//            is = new FileInputStream(DBCP_PROP_PATH);
//            properties.load(is);
//            dataSource = BasicDataSourceFactory.createDataSource(properties);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally
//        {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static Connection getConnection2() {
//        if(dataSource == null){
//            initDataSource();
//
//        }

        try {
            conn2 = dataSource2.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn2;

    }

    public static DataSource getDataSource() {
//        if(dataSource == null){
//            initDataSource();
//        }
        return dataSource;
    }


    public static DataSource getDataSource2() {
//        if(dataSource == null){
//            initDataSource();
//        }
        return dataSource2;
    }
}
