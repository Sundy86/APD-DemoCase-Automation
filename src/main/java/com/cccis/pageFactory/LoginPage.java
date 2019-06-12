package com.cccis.pageFactory;

import com.cccis.UIMap.LoginPageUI;
import com.cccis.util.SeleniumUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.cccis.util.GlobalSetting.BASE_URL;
import static com.cccis.util.GlobalSetting.CACHE_URL;

/**
 * Created by CCC on 2017/5/25.
 */
public class LoginPage {
    WebDriver driver;
    Logger log;
    SeleniumUtil seleniumUtil;

    @FindBy(xpath = LoginPageUI.xpath_username_text_field)
    WebElement username;
    @FindBy(xpath = LoginPageUI.xpath_password_text_field)
    WebElement password;
    @FindBy(xpath = LoginPageUI.xpath_captchaStr_text_field)
    WebElement captchaStr;
    @FindBy(xpath = LoginPageUI.xpath_submitLogin_btn)
    WebElement submitLogin;
    @FindBy(xpath = LoginPageUI.xpath_flush_all_link)
    WebElement flushAllLink;

    public LoginPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
        seleniumUtil = new SeleniumUtil(this.driver, this.log);

    }


    public void setUsername(String strUsername) {
        SeleniumUtil.log(log,"输入用户名： " + strUsername);
        username.sendKeys(strUsername);
    }

    public void setPassword(String strPassword) {
        SeleniumUtil.log(log,"输入密码： " + strPassword);
        password.sendKeys(strPassword);
    }

    public void setCaptcha(String strCaptchaStr) {
        SeleniumUtil.log(log,"输入验证码： " + strCaptchaStr);
        captchaStr.sendKeys(strCaptchaStr);
    }

    public void clickLoginButton() {
        SeleniumUtil.log(log,"点击登录");
        submitLogin.click();
    }

    public void clickFlushAllLink() {
        SeleniumUtil.log(log,"点击Flush All");
        flushAllLink.click();
    }

    public void loginToHomePage(String strUsername, String strPassword, String strCaptcha) {
        SeleniumUtil.log(log,"用户登录");
        driver.navigate().to(BASE_URL);

        this.setUsername(strUsername);
        this.setPassword(strPassword);
        this.setCaptcha(strCaptcha);
        this.clickLoginButton();
    }

    public void loginToCachePage(String strUsername, String strPassword, String strCaptcha) {
        SeleniumUtil.log(log,"用户登录");
        driver.get(CACHE_URL);

        this.setUsername(strUsername);
        this.setPassword(strPassword);
        this.setCaptcha(strCaptcha);
        this.clickLoginButton();
        seleniumUtil.switchToSpecificWindow(driver.getTitle());
        this.clickFlushAllLink();
    }

}