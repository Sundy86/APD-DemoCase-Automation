package com.cccis.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by HePing on 2017/5/4.
 */
public class StringUtil {
    private static Logger log = LogManager.getLogger(StringUtil.class);


    public static String replace(String sql, String... args) {

        String s = "指定SQL的参数与提供的参数数量不符";

        if (countString(sql, "#_#") == args.length) {

            for (int i = 0; i < args.length; i++) {
                sql = sql.replaceFirst("#_#", args[i]);
            }

            return sql;
        } else {
            log.error("指定SQL的参数与提供的参数数量不符");

        }

        return s;
    }

    public static int countString(String wholeString, String subString) {
        int index = 0;
        int count = 0;
        int from = 0;
        while ((index = wholeString.indexOf(subString, from)) != -1) {
            from = index + subString.length();
            count++;
        }
        return count;
    }
}
