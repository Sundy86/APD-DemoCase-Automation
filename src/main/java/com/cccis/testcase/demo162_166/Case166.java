package com.cccis.testcase.demo162_166;

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

public class Case166 extends CommonTest {
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
    public void addPart(String flag, String partName, String operationType, String categoryName) {
        SeleniumUtil.log(log,"----通过配件名称搜索配件" + partName + "，喷漆价格的合理性控制 case162----");
        int row = Integer.parseInt(flag);
        if (flag.equals("1") ) {
            SeleniumUtil.log(log,"----点选添加换件 后保险杠外皮 车顶板");
            estimateItemPage.addPartByOperatorByName(operationType, partName);
        }

        if (flag.equals("2") || flag.equals("3") || flag.equals("4") || flag.equals("5")) {
            SeleniumUtil.log(log,"----点选添加换件 左前翼子板 右前翼子板 左前车门 右前车门");
            estimateItemPage.addPartByOperatorByCategory(operationType, partName, categoryName);
        }
        if (flag.equals("6")) {
            estimateItemPage.addPartByOperatorByName(operationType, partName);
            estimateItemPage.partTreeClose();
            estimateItemPage.editItem(row, 12, "120");
        }
    }

    @Test(dependsOnMethods = {"addPart"}, description = "查看前置预警")
    public void preTips() {
        SeleniumUtil.log(log,"----外观件喷漆总金额过高，建议改为整车喷漆弹出提示信息框");
        String mergeWorkAlertOkTitle = estimateItemPage.getPromptAlertText();
        assertThat(mergeWorkAlertOkTitle).isEqualTo("外观件喷漆总金额过高，是否要更改为整车喷漆？");
        estimateItemPage.clickAlertOK();
    }
}
