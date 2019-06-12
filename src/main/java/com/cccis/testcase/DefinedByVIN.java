package com.cccis.testcase;

import com.cccis.pageFactory.EstimateItemPage;
import com.cccis.pageFactory.EstimateTaskListPage;
import com.cccis.pageFactory.LoginPage;
import com.cccis.util.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DefinedByVIN extends CommonTest {
    LoginPage loginPage;
    EstimateTaskListPage estimateTaskListPage;
    EstimateItemPage estimateItemPage;
    PushClaimUtil pushClaimUtil;
    String accidentNo;


    @Test(dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "定损任务导入")
    public void estimateTaskImport(String userAccount, String lossVehicleType, String vin, String claimCompanyId) throws IOException, InterruptedException {
        SeleniumUtil.log(log,"--------------------------导入定损单--------------------------");

        pushClaimUtil = new PushClaimUtil(log);
        pushClaimUtil.importClaimTask(userAccount, lossVehicleType, vin, claimCompanyId);
        accidentNo = pushClaimUtil.getAccidentNo();
    }

    @Test(dependsOnMethods = {"estimateTaskImport"},dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "APD定损员登录并打开定损单")
    public void estimateLogin(String username, String password, String captcha) {
        SeleniumUtil.log(log,"--------------------------登录APD--------------------------");
        loginPage = new LoginPage(chrome_driver, log);
        loginPage.loginToHomePage(username, password, captcha);
        SeleniumUtil.log(log,chrome_driver.getCurrentUrl());
        SeleniumUtil.log(log,chrome_driver.getTitle());

        seleUtilChrome.switchToSpecificWindow(chrome_driver.getTitle());
        SeleniumUtil.log(log,"--------------------------查询指定任务" + accidentNo + "，并点击事故号进入定损单处理页面--------------------------");

        estimateTaskListPage = new EstimateTaskListPage(chrome_driver, log);
        estimateTaskListPage.searchClaimTaskByAccidentNo(accidentNo);
        SeleniumUtil.log(log,"--------------------------进入" + accidentNo + "，定损单处理页面--------------------------");
        estimateItemPage = new EstimateItemPage(chrome_driver, log);
        estimateItemPage.clickEstimateVehicleInfoTab();
    }

    @Test(dependsOnMethods = {"estimateLogin"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "vin辅助定型")
    public void vehicleDefine(String vinCode, String vehicleSubModelName) {
        SeleniumUtil.log(log,"-------车辆定型------"+vinCode);
        estimateItemPage.vehicleDefinebyVin(vinCode.trim());
        Assert.assertEquals(vehicleSubModelName, estimateItemPage.getModelName());

        estimateItemPage.clearVehicleModel();
    }
}
