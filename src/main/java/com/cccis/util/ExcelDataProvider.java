package com.cccis.util;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/**
 * Created by HePing on 2016/11/24.
 */
public class ExcelDataProvider {

    @DataProvider(name = "apd_automation")
    public static Object[][] getDataFromExl(Method m){

        String testcaseName = m.getDeclaringClass().getSimpleName();
        return new BaseExcelData().getData(m.getName(),testcaseName);
    }


}
