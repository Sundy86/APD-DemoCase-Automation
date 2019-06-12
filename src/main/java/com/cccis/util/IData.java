package com.cccis.util;

/**
 * Created by HePing on 2016/11/24.
 */
public interface IData {

    Object[][] getData(String testcaseName, String dataFile);

    Object[][] getData(String testcaseName, String dataFile, int colNum);
//    Object[][] getData(String testcaseName, String dataFile, int beginNum, int endNum);

}
