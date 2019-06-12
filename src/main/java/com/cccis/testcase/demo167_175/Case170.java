package com.cccis.testcase.demo167_175;

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

import static org.assertj.core.api.Assertions.assertThat;

public class Case170 extends CommonTest {
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

    @Test(dependsOnMethods = {"estimateTaskImport"},dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "APD定损员登录并打开定损单")
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
    public void estimateDefineAndRepair(String vinCode, String rfName, String points) {
        SeleniumUtil.log(log,"--------------------------车辆定型，选择修理厂--------------------------");
        estimateItemPage.setFirstPartyVehicleInfo(vinCode, points);
        estimateItemPage.selectRepairFactory(rfName);
        estimateItemPage.gotoClaimItemTabPage();
    }

    @Test(dependsOnMethods = {"estimateDefineAndRepair"}, dataProvider = "apd_automation", dataProviderClass = ExcelDataProvider.class, description = "添加配件")
    public void addPart(String flag, String partName, String operationType) {
        SeleniumUtil.log(log,"----通过配件名称搜索配件" + partName + "，整车喷漆与单项喷漆存在互斥的校验 case169----");

        if (flag.equals("1")) {
            SeleniumUtil.log(log,"----点选添加喷漆 整车喷漆");
            estimateItemPage.addLaborHourByLaborName(partName);
        }


        if (flag.equals("2")) {
            SeleniumUtil.log(log,"----点选添加换件  后保险杠外皮 ");
            estimateItemPage.clickPartDataTab();
            estimateItemPage.addPartByOperatorByName(operationType, partName);
        }
    }

    @Test(dependsOnMethods = {"addPart"},  description = "查看前置预警")
    public void preTips() {

        SeleniumUtil.log(log,"----已添加整车喷漆，不能再添加任何外观件喷漆工时。弹出提示信息框");
        String mergeWorkAlertOkTitle = estimateItemPage.getPromptAlertText();
        assertThat(mergeWorkAlertOkTitle).isEqualTo("已添加整车喷漆，不能再添加任何外观件喷漆工时。");
        estimateItemPage.clickAlertOK();
    }
}
