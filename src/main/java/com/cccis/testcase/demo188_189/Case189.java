package com.cccis.testcase.demo188_189;

import com.cccis.pageFactory.*;
import com.cccis.util.CommonTest;
import com.cccis.util.ExcelDataProvider;
import com.cccis.util.PushClaimUtil;
import com.cccis.util.SeleniumUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Case189 extends CommonTest {
    LoginPage loginPage;
    EstimateTaskListPage estimateTaskListPage;
    EstimateItemPage estimateItemPage;
    PriceCheckTaskPage priceCheckTaskPage;
    ReinspectTaskPage reinspectTaskPage;
    PushClaimUtil pushClaimUtil;
    String currentHandle;
    String accidentNo;

    @Test(dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "定损任务导入")
    public void estimateTaskImport(String userAccount, String lossVehicleType, String vin, String claimCompanyId, String expectedClaimStatus) throws IOException, InterruptedException {
        SeleniumUtil.log(log,"--------------------------导入定损单--------------------------");
        pushClaimUtil = new PushClaimUtil(log);
        pushClaimUtil.importClaimTask(userAccount, lossVehicleType, vin, claimCompanyId);
        accidentNo = pushClaimUtil.getAccidentNo();
    }

    @Test(dependsOnMethods = {"estimateTaskImport"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "APD登录进入定损单处理")
    public void estimateLogin(String username, String password, String captcha) {
        SeleniumUtil.log(log,"--------------------------登录APD--------------------------");
        loginPage = new LoginPage(chrome_driver, log);
        loginPage.loginToHomePage(username, password, captcha);
        SeleniumUtil.log(log,chrome_driver.getCurrentUrl());

        currentHandle = seleUtilChrome.switchToSpecificWindow(chrome_driver.getTitle());

        SeleniumUtil.log(log,"--------------------------查询指定任务" + accidentNo + "，并点击事故号进入定损单处理页面--------------------------");
        estimateTaskListPage = new EstimateTaskListPage(chrome_driver, log);
        estimateTaskListPage.searchClaimTaskByAccidentNo(accidentNo);
        SeleniumUtil.log(log,"--------------------------进入" + accidentNo + "，定损单处理页面--------------------------");
        estimateItemPage = new EstimateItemPage(chrome_driver, log);

    }

    @Test(dependsOnMethods = {"estimateLogin"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "车辆定型，选择修理厂")
    public void estimateDefineAndRepair(String vinCode, String points, String rfName, String partType) {
        SeleniumUtil.log(log,"--------------------------车辆定型，选择修理厂--------------------------");
        estimateItemPage.setFirstPartyVehicleInfo(vinCode, points);
        estimateItemPage.selectRepairFactory(rfName);
       // estimateItemPage.selectRepairFactoryPartType(partType);
        estimateItemPage.gotoClaimItemTabPage();
    }

    @Test(dependsOnMethods = {"estimateDefineAndRepair"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "添加配件")
    public void addPart(String row, String partName, String operationType, String val) {
        SeleniumUtil.log(log,"----定损单重点KPI不应超出行业均值过多 case189----");

        SeleniumUtil.log(log,"----点选添加换件");
        int rowNum = Integer.parseInt(row);
        if (row.equals("1")) {
            estimateItemPage.addPartByOperatorByName(operationType, partName);
            estimateItemPage.clickAlertOK();
//            //修改折后单价
//            estimateItemPage.editItem(rowNum, 1, val);
//            estimateItemPage.partTreeClose();
//            //点击回收复选框
//            estimateItemPage.editItem(rowNum);
        }
        if (row.equals("2")) {
            estimateItemPage.showPartTreeWindow();
            estimateItemPage.addPartByOperatorByName(operationType, partName);
            //修改折后单价
            estimateItemPage.editItem(rowNum, 1, val);
        }
    }

    @Test(dependsOnMethods = {"addPart"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "查看审核报告")
    public void preAudit(String ruleNo, String isRedFlag ) {



//        estimateItemPage.submitClaimTask(currentHandle);
//
//        SeleniumUtil.log(log,"----核价提交");
//        priceCheckTaskPage = new PriceCheckTaskPage(chrome_driver, log);
//        priceCheckTaskPage.submitPriceCheckTask(accidentNo, currentHandle);
//
//        SeleniumUtil.log(log,"----打开核损任务");
//        reinspectTaskPage = new ReinspectTaskPage(chrome_driver, log);
//        reinspectTaskPage.openReinspectTask(accidentNo);
//        Assert.assertTrue(reinspectTaskPage.checkRuleIsHit(ruleNo, isRedFlag), "规则已触发");

        estimateItemPage.clickPreauditBtn();
        estimateItemPage.fiveSecondTipIsExist();
        Assert.assertTrue(estimateItemPage.getRuleNo( ruleNo, isRedFlag), "规则已触发");

    }


}
