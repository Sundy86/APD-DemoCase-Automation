package com.cccis.pageFactory;

import com.cccis.UIMap.PriceCheckTaskPageUI;
import com.cccis.util.SeleniumUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceCheckTaskPage {
    WebDriver driver;
    Logger log;
    SeleniumUtil seleniumUtil;


    //APD核价页面，核价标签
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_audit_priceChecker_tab)
    WebElement auditpriceChecker;

    //APD核价页面，待核价工作池
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_pending_audit_priceChecker_work_pool_btn)
    WebElement pendingAuditpriceCheckerWorkPool;

    //APD核价页面，任务列表
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_audit_priceChecker_task_list_btn)
    WebElement priceCheckerWorkList;

    //APD核价页面-事故号输入框
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_accidentNo_text_field)
    WebElement accidentNoTextField;

    //APD核价页面-查询按钮
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_Search_btn)
    WebElement search;

    //APD核价页面-核价定损单-批准按钮
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_audit_priceChecker_approval_btn)
    WebElement auditPriceCheckerApproval;

    //APD核价页面-核价定损单-提示框-提交按钮
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_audit_alert_submit_btn)
    WebElement alertSubmitBtn;

    //APD核价页面-核价定损单-提示框-提交按钮
    @FindBy(xpath = PriceCheckTaskPageUI.xpath_audit_prompt_button)
    WebElement promptBtn;

    public PriceCheckTaskPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
        seleniumUtil = new SeleniumUtil(this.driver, this.log);
    }

    public void clickAuditpriceCheckerBtn() {
        SeleniumUtil.log(log,"点击顶部导航栏的核价按钮");
        seleniumUtil.waitElementClickable(auditpriceChecker);
        auditpriceChecker.click();

    }

    public void clickPendingAuditpriceCheckerWorkPoolBtn() {
        SeleniumUtil.log(log,"点击待核价工作池按钮");
        seleniumUtil.moveTo(auditpriceChecker);
        seleniumUtil.waitElementClickable(pendingAuditpriceCheckerWorkPool);
        pendingAuditpriceCheckerWorkPool.click();
    }

    public void clickPriceCheckerWorkListBtn() {
        SeleniumUtil.log(log,"点击待核价列表按钮");
        seleniumUtil.moveTo(auditpriceChecker);
        seleniumUtil.waitElementClickable(priceCheckerWorkList);
        priceCheckerWorkList.click();
    }


    //核价页面：输入事故号
    public void setAccidentNo(String accidentNo) {
        SeleniumUtil.log(log,"输入事故号： " + accidentNo);
        seleniumUtil.waitElementClickable(accidentNoTextField);
        accidentNoTextField.sendKeys(accidentNo);
    }

    //核价页面：查询按钮
    public void clickSearchBtn() {
        SeleniumUtil.log(log,"点击查询按钮");
        seleniumUtil.waitElementClickable(search);
        search.click();
    }

    public void clickReceiveBtn(String accidentNo) {
        SeleniumUtil.log(log,"点击事故对应的领取按钮");
        String xpath = "//td[@columnfield='accidentNo']/a[@accidentno='" + accidentNo + "']//parent::td/following-sibling::td/span[@title='领取']";
        SeleniumUtil.log(log,xpath);
        WebElement xpath1 = driver.findElement(By.xpath(xpath));
        seleniumUtil.waitElementClickable(xpath1);
        xpath1.click();
    }

    public void clickAccidentNoLink(String accidentNo) {
        SeleniumUtil.log(log,"点击事故号链接");
        String xpath = "//td[@columnfield='accidentNo']/a[@class='lnkOpenClaim' and @accidentno='" + accidentNo + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void openPriceCheckTask(String accidentNo) {
        SeleniumUtil.log(log,"从核价工作池，领取任务后打开定损单");
        this.clickAuditpriceCheckerBtn();
        this.clickPendingAuditpriceCheckerWorkPoolBtn();
        this.setAccidentNo(accidentNo);
        this.clickSearchBtn();
        seleniumUtil.sleep();
        this.clickReceiveBtn(accidentNo);
        seleniumUtil.switchToNewWindow();

    }

    public void openPriceCheckTaskByTaskList(String accidentNo) {
        SeleniumUtil.log(log,"从核价列表，点击任务链接后打开定损单");
        this.clickAuditpriceCheckerBtn();
        this.clickPriceCheckerWorkListBtn();
        this.setAccidentNo(accidentNo);
        this.clickSearchBtn();
        seleniumUtil.sleep();
        this.clickAccidentNoLink(accidentNo);
        seleniumUtil.switchToNewWindow();
    }


    //核价定损单页面：点击批准按钮
    public void clickPriceCheckerApprovalBtn() {
        SeleniumUtil.log(log,"点击批准按钮");
        seleniumUtil.waitElementClickable(auditPriceCheckerApproval);
        auditPriceCheckerApproval.click();
        seleniumUtil.sleep();
        seleniumUtil.systemAlertConform();
        seleniumUtil.sleep();
        seleniumUtil.systemAlertConform();

    }

    public void submitPriceCheckTask(String accidentNo, String currentHandle) {
        SeleniumUtil.log(log,"从待核价工作池领取任务后，打开并提交");
        this.openPriceCheckTask(accidentNo);
        this.clickPriceCheckerApprovalBtn();
        seleniumUtil.switchToPreWindow(currentHandle);
    }

    public void submitPriceCheckTaskByTaskList(String accidentNo, String currentHandle) {
        SeleniumUtil.log(log,"从待核价列表点击任务号后，打开并提交");
        this.openPriceCheckTaskByTaskList(accidentNo);
        this.clickPriceCheckerApprovalBtn();
        seleniumUtil.switchToPreWindow(currentHandle);
    }
}
