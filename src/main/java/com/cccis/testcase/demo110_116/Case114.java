package com.cccis.testcase.demo110_116;

import com.cccis.pageFactory.EstimateItemPage;
import com.cccis.pageFactory.EstimateTaskListPage;
import com.cccis.pageFactory.LoginPage;
import com.cccis.util.CommonTest;
import com.cccis.util.ExcelDataProvider;
import com.cccis.util.PushClaimUtil;
import com.cccis.util.SeleniumUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Case114 extends CommonTest {
    LoginPage loginPage;
    EstimateTaskListPage estimateTaskListPage;
    EstimateItemPage estimateItemPage;
    PushClaimUtil pushClaimUtil;
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
        seleUtilChrome.switchToSpecificWindow(chrome_driver.getTitle());

        SeleniumUtil.log(log,"--------------------------查询指定任务" + accidentNo + "，并点击事故号进入定损单处理页面--------------------------");
        estimateTaskListPage = new EstimateTaskListPage(chrome_driver, log);
        estimateTaskListPage.searchClaimTaskByAccidentNo(accidentNo);
        SeleniumUtil.log(log,"--------------------------进入" + accidentNo + "，定损单处理页面--------------------------");
        estimateItemPage = new EstimateItemPage(chrome_driver, log);

    }

    @Test(dependsOnMethods = {"estimateLogin"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "车辆定型，选择修理厂")
    public void estimateDefineAndRepair(String vinCode, String rfName) {
        SeleniumUtil.log(log,"--------------------------车辆定型，选择修理厂--------------------------");
        estimateItemPage.setFirstPartyVehicleInfo(vinCode);
        estimateItemPage.selectRepairFactory(rfName);
        estimateItemPage.gotoClaimItemTabPage();
    }

    @Test(dependsOnMethods = {"estimateDefineAndRepair"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "添加配件")
    public void addPart(String flag, String operationType, String partName, String categoryName) {
        SeleniumUtil.log(log,"----同一配件不可重复赔付 case114----");

        SeleniumUtil.log(log,"----点选添加换件");
        if (flag.equals("1") || flag.equals("2")) {
            estimateItemPage.addPartByOperatorByName(operationType, partName);
            estimateItemPage.clickAlertOK();
        }
        if (flag.equals("3") || flag.equals("4") || flag.equals("5")) {
            estimateItemPage.addPartByOperatorByName(operationType, partName);
        }
        if (flag.equals("6")) {
            estimateItemPage.addPartByOperatorByName(operationType, partName);
            estimateItemPage.clickAlertCancel();
        }
        if (flag.equals("7")) {
            estimateItemPage.addPartByOperatorByCategory(operationType, partName, categoryName);
            estimateItemPage.clickAlertCancel();
        }
    }

    @Test(dependsOnMethods = {"addPart"}, description = "查看审核报告")
    public void preLock() {
        Assert.assertTrue(estimateItemPage.laborHourDeductionIsExist(), "损失项目已参与工时扣减");
    }


}
