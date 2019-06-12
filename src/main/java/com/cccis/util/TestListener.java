package com.cccis.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.Iterator;

/**
 * Created by HePing on 2017/4/18.
 */
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        Iterator<ITestResult> listOfFailTests = context.getFailedTests().getAllResults().iterator();
        Iterator<ITestResult> listOfSkippedTests = context.getSkippedTests().getAllResults().iterator();

        while (listOfFailTests.hasNext()) {
            ITestResult failedTest = listOfFailTests.next();

            ITestNGMethod method = failedTest.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                listOfFailTests.remove();
            } else {
                if (context.getPassedTests().getResults(method).size() > 0)
                    listOfFailTests.remove();
            }
        }

        while (listOfSkippedTests.hasNext()) {
            ITestResult skippedTest = listOfSkippedTests.next();

            ITestNGMethod method = skippedTest.getMethod();
            if (context.getFailedTests().getResults(method).size() > 0) {
                listOfSkippedTests.remove();
            } else {
                if (context.getPassedTests().getResults(method).size() > 0)
                    listOfSkippedTests.remove();
            }
        }

    }
}
