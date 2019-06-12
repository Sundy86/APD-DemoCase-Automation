package com.cccis.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by HePing on 2017/4/18.
 */
public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
