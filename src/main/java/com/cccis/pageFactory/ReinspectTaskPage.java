package com.cccis.pageFactory;

import com.cccis.UIMap.ReinspectTaskPageUI;
import com.cccis.util.SeleniumUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReinspectTaskPage {
    WebDriver driver;
    Logger log;
    SeleniumUtil seleniumUtil;

    @FindBy(xpath = ReinspectTaskPageUI.xpath_audit_reinspection_tab)
    WebElement auditReinspection;

    @FindBy(xpath = ReinspectTaskPageUI.xpath_pending_audit_reinspection_work_pool_btn)
    WebElement pendingAuditReinspectionWorkPool;

    @FindBy(xpath = ReinspectTaskPageUI.xpath_audit_reinspection_task_list_btn)
    WebElement auditReinspectionTaskList;

    @FindBy(xpath = ReinspectTaskPageUI.xpath_accidentNo_text_field)
    WebElement accidentNoTextField;

    @FindBy(xpath = ReinspectTaskPageUI.xpath_Search_btn)
    WebElement search;

    //APD核损页面-审核报告tab
    @FindBy(xpath = ReinspectTaskPageUI.xpath_auditReport_tab)
    WebElement auditReportTab;
    //APD核损页面-损失项目tab
    @FindBy(xpath = ReinspectTaskPageUI.xpath_claimItem_tab)
    WebElement claimItemTab;


    public ReinspectTaskPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
        seleniumUtil = new SeleniumUtil(this.driver, this.log);
    }

    public void clickAuditReinspectionBtn() {
        SeleniumUtil.log(log,"点击顶部导航栏的核损按钮");
        seleniumUtil.waitElementClickable(auditReinspection);
        auditReinspection.click();
    }

    public void clickPendingAuditReinspectionWorkPoolBtn() {
        SeleniumUtil.log(log,"点击待核损工作池按钮");
        seleniumUtil.moveTo(auditReinspection);
        seleniumUtil.waitElementClickable(pendingAuditReinspectionWorkPool);
        pendingAuditReinspectionWorkPool.click();

    }

    public void clickReinspectionTaskListBtn() {
        SeleniumUtil.log(log,"点击核损的任务列表按钮");
        seleniumUtil.moveTo(auditReinspection);
        seleniumUtil.waitElementClickable(auditReinspectionTaskList);
        auditReinspectionTaskList.click();
    }


    //核损页面：输入事故号
    public void setAccidentNo(String accidentNo) {
        SeleniumUtil.log(log,"输入事故号： " + accidentNo);
        accidentNoTextField.sendKeys(accidentNo);
    }

    //核损页面：查询按钮
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

    public void openReinspectTask(String accidentNo) {
        SeleniumUtil.log(log,"从核损工作池，领取任务后打开定损单");
        this.clickAuditReinspectionBtn();
        this.clickPendingAuditReinspectionWorkPoolBtn();
        this.setAccidentNo(accidentNo);
        this.clickSearchBtn();
        seleniumUtil.sleep();
        this.clickReceiveBtn(accidentNo);
        seleniumUtil.switchToNewWindow();
    }

    public void openReinspectTaskByTaskList(String accidentNo) {
        SeleniumUtil.log(log,"从核损列表，点击任务链接后打开定损单");
        this.clickAuditReinspectionBtn();
        this.clickReinspectionTaskListBtn();
        this.setAccidentNo(accidentNo);
        this.clickSearchBtn();
        seleniumUtil.sleep();
        this.clickAccidentNoLink(accidentNo);
        seleniumUtil.switchToNewWindow();
    }


    public void clickclaimItemTab() {
        SeleniumUtil.log(log,"点击损失项目tab");
        seleniumUtil.waitElementClickable(claimItemTab);
        claimItemTab.click();
    }

    public void clickAuditReportTab() {
        SeleniumUtil.log(log,"点击审核报告tab");
        seleniumUtil.waitElementClickable(auditReportTab);
        auditReportTab.click();
    }


    //通过规则名称，规则编号 判断是否存在且为红线规则
    public Boolean checkRuleIsHit(String partName, String ruleNo, String isRedRule) {
        SeleniumUtil.log(log,"检查规则" + ruleNo + "是否击中");
        this.clickAuditReportTab();
        String xpath_ruleNo = "//div[@id='auditReportGrid']//td[@columnfield='ruleNo' and text()='" + ruleNo + "']/following-sibling::td[@columnfield='itemName']/span[@title='" + partName + "']";
        String xpath_ruleColor = "//div[@id='auditReportGrid']//tr/td/following-sibling::td/span[contains(text(),'" + partName + "')]/parent::td/preceding-sibling::td[@columnfield='ruleNo' and text()='" + ruleNo + "']/parent::tr[@style='color:red']";

        if (isRedRule.equals("1")) {
            if (seleniumUtil.isElementPresent(By.xpath(xpath_ruleNo)) && seleniumUtil.isElementPresent(By.xpath(xpath_ruleColor))) {
                return true;
            }
        } else {
            return seleniumUtil.isElementPresent(By.xpath(xpath_ruleNo));
        }
        return false;
    }

    //通过规则名称，规则编号 判断是否存在且为红线规则
    public Boolean checkRuleIsHit(String ruleNo, String isRedRule) {
        SeleniumUtil.log(log,"检查规则" + ruleNo + "是否击中");
        this.clickAuditReportTab();
        String xpath_ruleNo = "//div[@id='auditReportGrid']//td[@columnfield='ruleNo' and text()='" + ruleNo + "']";
        String xpath_ruleColor = "//div[@id='auditReportGrid']//td/preceding-sibling::td[@columnfield='ruleNo' and text()='" + ruleNo + "']/parent::tr[@style='color:red']";

        if (isRedRule.equals("1")) {
            if (seleniumUtil.isElementPresent(By.xpath(xpath_ruleNo)) && seleniumUtil.isElementPresent(By.xpath(xpath_ruleColor))) {
                return true;
            }
        } else {
            return seleniumUtil.isElementPresent(By.xpath(xpath_ruleNo));
        }
        return false;
    }

}
