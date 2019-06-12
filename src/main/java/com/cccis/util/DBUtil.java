package com.cccis.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.db.type.Request;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * Created by HePing on 2016/12/5.
 */
public class DBUtil {
    private static Connection conn;
    private static Logger log = LogManager.getLogger(DBUtil.class);


    public static void updateSQL(String sql) {
        QueryRunner queryRunner = new QueryRunner(DbcpConnection.getDataSource());
        try {
            SeleniumUtil.log(log,"sql：" + sql);
            int i = queryRunner.update(sql);
            SeleniumUtil.log(log,"结果：" + i + " 行数据已经更新");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSQL(String dbName, String sql) {
        SeleniumUtil.log(log,"在 " + dbName + " 中，更新数据...");
        QueryRunner queryRunner = new QueryRunner(DbcpConnection.getDataSource2());
        try {
            SeleniumUtil.log(log,"sql：" + sql);
            int i = queryRunner.update(sql);
            SeleniumUtil.log(log,"结果：" + i + " 行数据已经更新");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Request getSelectResult(String selectSQL) {
        SeleniumUtil.log(log,"sql：" + selectSQL);
        Request result = new Request(DbcpConnection.getDataSource(), selectSQL);
        return result;
    }

    public static Request getSelectResult(String dbName, String selectSQL) {
        SeleniumUtil.log(log,"在 " + dbName + " 数据库中，提取数据...");
        SeleniumUtil.log(log,"sql：" + selectSQL);
        Request result = new Request(DbcpConnection.getDataSource2(), selectSQL);
        return result;
    }

    public static List getResultSet(String sql) {
        List<Map<String, Object>> map = null;
        QueryRunner queryRunner = new QueryRunner(DbcpConnection.getDataSource());
        try {
            SeleniumUtil.log(log,"sql：" + sql);
            map = queryRunner.query(sql, new MapListHandler(), (Object[]) null);
            return map;
            //SeleniumUtil.log(log,"结果：" + i + " 行数据已经更新");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static Map getSingleResultSet(String sql) {
        Map<String, Object> map = null;
        QueryRunner queryRunner = new QueryRunner(DbcpConnection.getDataSource());
        try {
            SeleniumUtil.log(log,"sql：" + sql);
            map = queryRunner.query(sql, new MapHandler(), (Object[]) null);
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }


}
