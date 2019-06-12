package com.cccis.pageFactory;

import com.cccis.UIMap.EstimateTaskListPageUI;
import com.cccis.util.SeleniumUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimateTaskListPage {
    WebDriver driver;
    Logger log;
    SeleniumUtil seleniumUtil;

    //APD定损页面，定损菜单
    @FindBy(xpath = EstimateTaskListPageUI.xpath_estimate_tab)
    WebElement estimateTab;
    @FindBy(xpath = EstimateTaskListPageUI.xpath_accidentNo_input)
    WebElement accidentNo;
    @FindBy(xpath = EstimateTaskListPageUI.xpath_btnSearch_btn)
    WebElement searchButton;

    // ccc add 0423
    @FindBy(xpath = EstimateTaskListPageUI.xpath_estimateTask_href)
    WebElement estimateTaskHref;
    @FindBy(xpath = EstimateTaskListPageUI.xpath_estimateTaskList_href)
    WebElement estimateTaskListHref;


    public EstimateTaskListPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
        seleniumUtil = new SeleniumUtil(this.driver, this.log);
    }

    // ccc add 0424
    public void clickEstimateTaskListHref() {
        SeleniumUtil.log(log,"点击定损-任务列表");
        seleniumUtil.moveTo(estimateTaskHref);
        seleniumUtil.waitElementClickable(estimateTaskListHref);
        estimateTaskListHref.click();
    }

    public void clickEstimateBtn() {
        SeleniumUtil.log(log,"点击顶部导航栏的定损按钮");
        seleniumUtil.waitElementClickable(estimateTab);
        estimateTab.click();
    }

    //点击定损任务列表的事故号链接
    public void clickEstimateAccidentNo(String accidentNo) {

        String blockOverlayXpath = "//div[contains(@class,'blockOverlay')]";
        seleniumUtil.sleep(blockOverlayXpath);
        SeleniumUtil.log(log,"点击定损任务列表的事故号链接");
        String xpath = "//td[@columnfield='accidentNo']/a[contains(text(),'" + accidentNo + "')]";
        SeleniumUtil.log(log,"点击定损任务列表的事故号链接xpath"+xpath);

        seleniumUtil.sleep(30,xpath,1);
    }

    //输入查询条件-事故号
    public void setAccidentNo(String accNo) {
        SeleniumUtil.log(log,"输入查询条件-事故号：" + accNo);
        accidentNo.clear();
        accidentNo.sendKeys(accNo);
    }

    //点击定损任务列表的查询按钮
    public void clickSearchBtn() {
        SeleniumUtil.log(log,"点击定损任务列表的查询按钮");
        searchButton.click();
        seleniumUtil.sleep();
    }

    //点击事故号并进入定损单
    public void searchClaimTaskByAccidentNo(String accidentNo) {
        this.clickEstimateBtn();
        this.setAccidentNo(accidentNo);
        this.clickSearchBtn();
        this.clickEstimateAccidentNo(accidentNo);
        seleniumUtil.switchToNewWindow();
        seleniumUtil.sleep();
    }
}
