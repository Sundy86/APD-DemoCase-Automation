package com.cccis.testcase.demo60_62;

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

public class Case62 extends CommonTest {
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
    public void addPart(String flag, String operationType, String partName) {
        SeleniumUtil.log(log,"----通过配件名称搜索配件" + partName + "，总成件和子配件不可同时赔付 case62----");


        if (flag.equals("1")) {
            SeleniumUtil.log(log,"----点选添加换件  前保险杠外皮左段 点击添加喷漆");
            estimateItemPage.addPartByOperatorByName(operationType, partName);
            estimateItemPage.clickAlertOK();
        }
        if (flag.equals("2")) {
            SeleniumUtil.log(log,"----点选添加换件  左前大灯喷嘴支架 直接添加成功");
            estimateItemPage.addPartByOperatorByName(operationType, partName);
        }

    }

    @Test(dependsOnMethods = {"addPart"}, description = "查看审核报告")
    public void preTips() {

        SeleniumUtil.log(log,"----添加总成件再添加包含件弹出提示信息框");
        String mergeWorkAlertOkTitle = estimateItemPage.getPromptAlertText();
        assertThat(mergeWorkAlertOkTitle).isEqualTo("已添加了总成件的换件，不允许添加该总成件的包含配件。");
        estimateItemPage.clickAlertOK();
    }


}
