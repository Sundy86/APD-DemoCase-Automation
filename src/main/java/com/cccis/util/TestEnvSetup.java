package com.cccis.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.cccis.util.GlobalSetting.*;

/**
 * Created by HePing on 2016/11/28.
 */
public class TestEnvSetup {
    WebDriver ieDriver;
    WebDriver chromeDriver;
    WebDriver driver;
    Logger log;
    ITestContext testContext;

    public TestEnvSetup(String testcaseName) {

        log = LogManager.getLogger(testcaseName);

    }

    public WebDriver iniIEDriver() {
        System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
        ieDriver = new InternetExplorerDriver();
        ieDriver.manage().window().maximize();
        ieDriver.manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
        SeleniumUtil.log(log,"###########################################################");
        SeleniumUtil.log(log,"启动测试浏览器为：[ IE ]");
        SeleniumUtil.log(log,"当前的操作系统是：[" + CURRENT_PLATFORM + " " + CURRENT_PLATFORM_ARCH + "]");
        return ieDriver;


    }

    public WebDriver iniChromeDriver() {

        ChromeOptions options = new ChromeOptions();
//        // 通过配置参数禁止data;的出现
//        options.addArguments("--user-data-dir=C:/Users/ccc/AppData/Local/Google/Chrome/User Data/Default");

        Map<String, Object> setting = new HashMap<>();
        setting.put("audiblePlaybacks", 0);
        setting.put("hasHighScore", false);
        setting.put("lastMediaPlaybackTime", 0.0);
        setting.put("mediaPlaybacks", 0);
        setting.put("significantPlaybacks", 0);
        setting.put("visits", 1);
        setting.put("visitsWithMediaTag", 0);


        Map<String, Object> ip = new HashMap<>();

        ip.put("last_modified", "13169187114098237");
        ip.put("setting", setting);

        Map<String, Object> media = new HashMap<>();
        media.put("http://192.168.200.14:7001,*", ip);

        Map<String, Object> exceptions = new HashMap<>();
        exceptions.put("media_engagement", media);
        Map<String, Object> plugins = new HashMap<>();
        Map<String, Object> ip2 = new HashMap<>();
        ip2.put("last_modified", "13169187019441329");
        ip2.put("setting", 1);
        plugins.put("http://192.168.200.14:7001,*", ip2);
        exceptions.put("plugins", plugins);

        Map<String, Object> contentSettings = new HashMap<>();
        contentSettings.put("exceptions", exceptions);
        Map<String, Object> profile = new HashMap<>();
        profile.put("avatar_bubble_tutorial_shown", 2);
        profile.put("avatar_index", 17);
        profile.put("content_settings", contentSettings);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile", profile);

// chrome68 不需要设置
//        options.setExperimentalOption("prefs", prefs);
        // 通过配置参数删除稳定性和安全性会有所下降提示
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        chromeDriver = new ChromeDriver(options);
        // chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
        SeleniumUtil.log(log,"启动测试浏览器为：[ Chrome ]");

        return chromeDriver;
    }


    public WebDriver iniDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);

        if (TEST_BROWSER.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();

        } else if (TEST_BROWSER.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
            driver = new InternetExplorerDriver();
        }


        SeleniumUtil.log(log,"###########################################################");
        SeleniumUtil.log(log,"当前的操作系统是：[" + CURRENT_PLATFORM + " " + CURRENT_PLATFORM_ARCH + "]");
        SeleniumUtil.log(log,"启动测试浏览器为：[" + TEST_BROWSER + "]");
        SeleniumUtil.log(log,"测试开始");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
        SeleniumUtil.log(log,"输入网址： " + BASE_URL);
        driver.get(BASE_URL);
        return driver;

    }

    public Logger getLogger() {
        return log;
    }
}
