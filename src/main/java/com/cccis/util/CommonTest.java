package com.cccis.util;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

/**
 * Created by HePing on 2016/11/28.
 */
public class CommonTest {
    protected TestEnvSetup tes;
    public static WebDriver ie_driver;
    public static WebDriver chrome_driver;
    protected Logger log;
    protected String testcaseName;
    protected SeleniumUtil seleUtilIE;
    protected SeleniumUtil seleUtilChrome;
    protected ITestContext testContext = null;
    // protected SoftAssert softAssert;
    PushClaimUtil pushClaimUtil;

    @BeforeClass(alwaysRun = true)
    public void setup(ITestContext testContext) {
        testcaseName = this.getClass().getName();
        tes = new TestEnvSetup(testcaseName);
        log = tes.getLogger();
        //ie_driver = tes.iniIEDriver();
        chrome_driver = tes.iniChromeDriver();
        this.testContext = testContext;
        // this.driver = tes.iniDriver();
        //seleUtilIE = new SeleniumUtil(ie_driver,log);
        seleUtilChrome = new SeleniumUtil(chrome_driver, log);
        seleUtilChrome.keepOneWindow();
        // softAssert = new SoftAssert();
        testContext.setAttribute("driver", chrome_driver);

    }

//    @AfterMethod(alwaysRun = true)
//    public void afterMethod(ITestResult result){
//        if(!result.isSuccess())
//        {
//            new FailedTestCaseReport().catchExceptions(result,chrome_driver);
//        }
//    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (chrome_driver != null) {
            chrome_driver.close();
            chrome_driver.quit();
        } else {
            Assert.fail("driver没有获得对象,退出操作失败");
        }
    }
}
