package com.cccis.pageFactory;

import com.cccis.UIMap.EstimateItemPageUI;
import com.cccis.util.SeleniumUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EstimateItemPage {
    WebDriver driver;
    Logger log;
    SeleniumUtil seleniumUtil;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_task_claim_vehicleinfo_tab)
    WebElement estimateVehicleInfoTab;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_vehicleinfo_vin_input)
    WebElement estimateVehicleVinCode;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_vehicleinfo_definebyvin_btn)
    WebElement estimateVehicleDefinebyVin;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_task_claim_passengerVehicle_radio)
    WebElement passengerVehicleRadio;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_task_claim_commercialVehicle_radio)
    WebElement commercialVehicleRadio;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_vehicleSubModelName_flied)
    WebElement estimateVehicleSubModelName;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_task_claim_vehicleSubModelId_input)
    WebElement vehicleSubModelIdInput;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_task_claim_repairshop_tab)
    WebElement claimRepaireShopTab;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_repair_factoryId_input)
    WebElement repairFactoryIdInput;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_repair_factory_search_btn)
    WebElement btnSearchrepairFactory;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_rf_search_name_txt)
    WebElement divRepairFactoryNameSelector;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_task_claim_preauditreport_tab)
    WebElement divPreAuditReportTab;

    //ccc add0423
    @FindBy(xpath = EstimateItemPageUI.xpath_exclusiveSearch_dropdown)
    WebElement exclusiveSearchDropdown;

    //ccc add0423
    @FindBy(xpath = EstimateItemPageUI.xpath_exclusiveSearch_select)
    WebElement exclusiveSearchSelect;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_rf_search_btn)
    WebElement divRepairFactorySearchBtn;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_rf_grid_add_btn)
    WebElement divRepairFactoryGridAddBtn;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_rf_partType_select)
    WebElement divRepairFactoryPartTypeSelect;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_task_claimitem_tab)
    WebElement claimItemTab;

    //辅料tab
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_material_data_tab)
    WebElement materialDataTab;

    //配件tab
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_part_data_tab)
    WebElement partDataTab;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_part_data_search_input)
    WebElement claimItemDataPartPrltvSch;

    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_part_data_search_btn)
    WebElement claimItemDataPartPrltvSchBtn;

    //损失项目tab--配件树 轮胎tab
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_parttree_commonPart_tab)
    WebElement partTreeCommonPartTab;

    //损失项目tab--配件树 轮胎tab 搜索框
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_commonPart_data_search_input)
    WebElement partTreeCommonPartSearchInput;

    //损失项目tab--配件树 轮胎tab 搜索按钮
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_commonPart_data_search_btn)
    WebElement partTreeCommonPartSearchBtn;

    //损失项目tab--配件树 轮胎tab 换件按钮
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_commonPart_changePart_btn)
    WebElement partTreeCommonPartChangePartBtn;

    //损失项目tab--配件树 关闭图标
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_partTree_close_btn)
    WebElement partTreeCloseBtn;

    //损失项目tab--弹出提示框
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_promptAlert_window)
    WebElement promptAlert;

    //损失项目tab--展开配件树
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_show_partTree_btn)
    WebElement showPartTree;


    //损失项目tab-配件树 工时tab
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_partTree_laborHour_tab)
    WebElement partTreeLaborHourTab;

    //损失项目tab-配件树 工时tab 搜索文本框
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_partTree_laborHour_search)
    WebElement partTreeLaborHourSearch;

    //损失项目tab-配件树 工时tab 放大镜按钮
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_partTree_laborHour_searchButton)
    WebElement partTreeLaborHourSearchBtn;

    //损失项目tab-配件树 工时tab 添加工时+按钮
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_partTree_laborHour_addLaborHourButton)
    WebElement partTreeLaborHourBtn;


    //损失项目tab--列表图标
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_nogroupview_btn)
    WebElement noGroupViewBtn;

    //损失项目tab--添加项目时弹出残值/折旧框 取消按钮
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_item_part_salvage_cancel_btn)
    WebElement salvageCancelBtn;

    @FindBy(xpath = EstimateItemPageUI.xpath_topNav_saveClaim_btn)
    WebElement saveClaimBtn;

    @FindBy(xpath = EstimateItemPageUI.xpath_topNav_tips_btn)
    WebElement tipsBtn;

    //导航栏--提示框
    @FindBy(xpath = EstimateItemPageUI.xpath_topNav_tips_window)
    WebElement tipsWindow;

    //导航栏--提示框 关闭按钮
    @FindBy(xpath = EstimateItemPageUI.xpath_vhl_claim_promptAlert_close_btn)
    WebElement tipsWindowCloseBtn;


    //导航栏--提交
    @FindBy(xpath = EstimateItemPageUI.xpath_topNav_submitClaim_btn)
    WebElement submitClaimBtn;

    //导航栏--提示框 提交
    @FindBy(xpath = EstimateItemPageUI.xpath_topNav_tips_submit_btn)
    WebElement tipsSubmitBtn;

    //提交--预审核
    @FindBy(xpath = EstimateItemPageUI.xpath_topNav_preaudit_btn)
    WebElement preauditBtn;

    //提交--直接提交定损单
    @FindBy(xpath = EstimateItemPageUI.xpath_topNav_alert_submit_btn)
    WebElement alertSubmitClaimBtn;


    public EstimateItemPage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
        seleniumUtil = new SeleniumUtil(this.driver, this.log);
    }


    public void clickEstimateVehicleInfoTab() {
        SeleniumUtil.log(log,"点击定损单车辆信息tab");
        this.claimTaskIsFinished();
        this.fiveSecondTipIsExist();
        seleniumUtil.waitElementClickable(estimateVehicleInfoTab);
        estimateVehicleInfoTab.click();
    }

    public void clickPreAuditReportTab() {
        SeleniumUtil.log(log,"点击定损单审核报告tab");
        seleniumUtil.waitElementClickable(divPreAuditReportTab);
        divPreAuditReportTab.click();
    }

    public void clickMaterialDataTab() {
        SeleniumUtil.log(log,"点击损失项目-辅料tab");
        seleniumUtil.waitElementClickable(materialDataTab);
        materialDataTab.click();
    }

    //切换配件树tab
    public void clickPartDataTab() {
        SeleniumUtil.log(log,"点击损失项目-配件tab");
        seleniumUtil.waitElementClickable(partDataTab);
//        partDataTab.click();

        this.retryClick(EstimateItemPageUI.xpath_vhl_claim_item_part_data_tab,EstimateItemPageUI.xpath_vhl_claim_item_part_data_tab);
    }


    public void setVhlinfoVinCode(String vinCode) {
        SeleniumUtil.log(log,"车辆信息tab,输入VinCode");
        seleniumUtil.waitElementClickable(estimateVehicleVinCode);
        estimateVehicleVinCode.clear();
        driver.findElement(By.xpath(EstimateItemPageUI.xpath_vhl_vehicleinfo_vin_input)).sendKeys(vinCode);
    }

    public void clickVehicleDefinebyVin() {
        SeleniumUtil.log(log,"车辆信息tab,点击VIN辅助定型按钮");
        seleniumUtil.waitElementClickable(estimateVehicleDefinebyVin);
        driver.findElement(By.xpath(EstimateItemPageUI.xpath_vhl_vehicleinfo_definebyvin_btn)).click();
        this.vehicleModelIsLoaded();
    }
    public void clickVehicleDefinebyVin2() {
        SeleniumUtil.log(log,"车辆信息tab,点击VIN辅助定型按钮");
        seleniumUtil.waitElementClickable(estimateVehicleDefinebyVin);
        estimateVehicleDefinebyVin.click();
    }

    public String getVehicleSubModelName() {
        SeleniumUtil.log(log,"车辆定型后，获取款型名称");
        seleniumUtil.waitElementClickable(estimateVehicleSubModelName);
        return estimateVehicleSubModelName.getText();
    }

    public String getModelName(){
        String subModelName = driver.findElement(By.xpath(EstimateItemPageUI.xpath_vhl_claim_task_claim_vehicleSubModelId_input)).getAttribute("oldtext");
        SeleniumUtil.log(log,"获取VIN定型款型名称"+subModelName);
        return subModelName;
    }

    public void clearVehicleModel(){
        SeleniumUtil.log(log,"清空款型");
        commercialVehicleRadio.click();
        while(!this.getVehicleSubModelName().equals("")){
            SeleniumUtil.log(log,"车辆未清空，请稍后...");
            seleniumUtil.sleep();
        }
        passengerVehicleRadio.click();
        while(!this.getModelName().equals("请选择")){
            SeleniumUtil.log(log,"车辆未清空，请稍后...");
            seleniumUtil.sleep();
        }
    }



    public void vehicleDefinebyVin(String vinCode){
        SeleniumUtil.log(log,"车辆定型");
        this.setVhlinfoVinCode(vinCode);
        this.clickVehicleDefinebyVin();
    }


    public void selectConfigQuestion(String question, String answer) {
        SeleniumUtil.log(log,"车辆定型后，选择款型配置问题答案");
        String xpath = "//div[@id='questionList']//td/div[text()='" + question + "']/parent::td/following-sibling::td//span[text()='" + answer + "']";
        WebElement questionXpath = driver.findElement(By.xpath(xpath));
        seleniumUtil.waitElementClickable(questionXpath);
        questionXpath.click();
        this.vehicleModelIsLoaded();
    }


    public void setVehicleDamagePosition(String point) {
        SeleniumUtil.log(log,"选择损失部位为" + point);

        String xpath_damagePosition = "//div[@id = 'lossVehicleItem']//span[@id = '" + point + "']";
        driver.findElement(By.xpath(xpath_damagePosition)).click();
    }

    public void clickEstimateRepaireShopTab() {
        SeleniumUtil.log(log,"点击修理厂信息tab");
        this.fiveSecondTipIsExist();
        claimRepaireShopTab.click();
        seleniumUtil.sleep();
    }


    public void repairFactoryIsLoaded() {
        SeleniumUtil.log(log,"检查点选修理厂是否完成");
        while(this. repairFactoryIdInput.getText()==null || this. repairFactoryIdInput.getText().equals("")){
            SeleniumUtil.log(log,"点选修理厂未完成，请稍后...");
            seleniumUtil.sleep();
        }
    }

    public void clickEstimateSearchrepairFactory() {
        SeleniumUtil.log(log,"点击修理厂名称后的搜索图标");
        seleniumUtil.sleep(10,EstimateItemPageUI.xpath_vhl_repair_factory_search_btn,1);
    }

    public void setVhlinfoRepairFactoryNameSelector(String repairFactoryName) {
        SeleniumUtil.log(log,"合作修理厂弹出框-输入修理厂名称" + repairFactoryName);
        seleniumUtil.waitElementClickable(divRepairFactoryNameSelector);
        divRepairFactoryNameSelector.sendKeys(repairFactoryName);
    }

    // 修理厂查询页面查询条件 点击是否专属厂牌
    public void clickExclusiveSearchDropdown() {
        SeleniumUtil.log(log,"合作修理厂弹出框-点击是否专属厂牌");
        seleniumUtil.waitElementClickable(exclusiveSearchDropdown);
        exclusiveSearchDropdown.click();
    }

    //修理厂查询页面查询条件 是否专属厂牌选择  请选择
    public void clickExclusiveSearchSelect() {
        SeleniumUtil.log(log,"合作修理厂弹出框-点击是否专属厂牌");
        seleniumUtil.waitElementClickable(exclusiveSearchSelect);
        exclusiveSearchSelect.click();
    }


    public void clickEstimateRepairFactorySearchBtn() {
        SeleniumUtil.log(log,"合作修理厂弹出框-点击查询按钮");
        seleniumUtil.waitElementClickable(divRepairFactorySearchBtn);
        divRepairFactorySearchBtn.click();
        String xpath = "//div[contains(@class,'blockOverlay')]";
        seleniumUtil.sleep(xpath);
    }

    public void clickEstimateRepairFactoryGridAddBtn() {
        SeleniumUtil.log(log,"合作修理厂弹出框-点击添加图标");
        seleniumUtil.waitElementClickable(divRepairFactoryGridAddBtn);
        divRepairFactoryGridAddBtn.click();
        this.repairFactoryIsLoaded();
    }

    //录入修理厂信息
    public void selectRepairFactory(String rfName) {
        this.clickEstimateRepaireShopTab();
        this.clickEstimateSearchrepairFactory();
        this.setVhlinfoRepairFactoryNameSelector(rfName);
        this.clickExclusiveSearchDropdown();
        this.clickExclusiveSearchSelect();
        this.clickEstimateRepairFactorySearchBtn();
        this.clickEstimateRepairFactoryGridAddBtn();
    }

    public void selectRepairFactoryPartType(String partType) {
        SeleniumUtil.log(log,"修理厂tab-修改配件渠道为" + partType);
        this.divRepairFactoryPartTypeSelect.click();
        String xpath = "//div[@id='cboPartType-list' and contains(@style,'display: block')]/ul/li[text()='" + partType + "']";
        WebElement partTypeXpath = driver.findElement(By.xpath(xpath));
        seleniumUtil.waitElementClickable(partTypeXpath);
        partTypeXpath.click();
    }

    //判断损失部位是否选中
    public Boolean pointIsSelect(String point) {
        String isSelect = "//div[@name='vehicleBodyTypeDiv']/span[@id='" + point + "' and @class='getIndex1 black']";
        return seleniumUtil.isElementPresent(By.xpath(isSelect));
    }


    //录入标的车辆信息
    public void setFirstPartyVehicleInfo(String vin, String points) {
        this.claimTaskIsFinished();
        this.clickEstimateVehicleInfoTab();
        this.setVhlinfoVinCode(vin);
        this.clickVehicleDefinebyVin();
        String[] ps = points.split(",");
        if (ps.length > 0) {
            for (String point : ps) {
                if (!this.pointIsSelect(point)) {
                    this.setVehicleDamagePosition(point);
                }
            }
        } else {
            if (!this.pointIsSelect(points)) {
                this.setVehicleDamagePosition(points);
            }
        }

    }

    //录入标的车辆信息
    public void setFirstPartyVehicleInfo(String vin) {
        this.clickEstimateVehicleInfoTab();
        this.setVhlinfoVinCode(vin);
        this.clickVehicleDefinebyVin();
    }
    public void setFirstPartyVehicleInfo2(String vin) {
        this.clickEstimateVehicleInfoTab();
        this.setVhlinfoVinCode(vin);
        this.clickVehicleDefinebyVin2();
    }

    //点击损失项目tab
    public void gotoClaimItemTabPage() {
        SeleniumUtil.log(log,"点击损失项目tab");
        this.fiveSecondTipIsExist();
        claimItemTab.click();
        this.partTreeIsLoaded();
    }

    public void clickNoGroupViewBtn() {
        SeleniumUtil.log(log,"点击列表图标");
        noGroupViewBtn.click();
    }

    public void partTreeIsLoaded() {
        SeleniumUtil.log(log,"检查配件树是否加载完成");
        String xpath = "//div[contains(@class,'blockOverlay')]";
        seleniumUtil.sleep(xpath);
    }

    public void partTreeIsNotLoaded() {
        SeleniumUtil.log(log,"检查配件树是否加载完成");
        seleniumUtil.sleep(EstimateItemPageUI.xpath_vhl_partTree_div);
    }

    public void vehicleModelIsLoaded() {
        SeleniumUtil.log(log,"检查车型定型是否完成");
        seleniumUtil.sleep();
        while(this.getModelName().equals("请选择")){
            SeleniumUtil.log(log,"车辆未定型完成，请稍后...");
            seleniumUtil.sleep();
        }
    }



    //点击损失项目tab 配件树工时tab
    public void showPartTreeWindow() {
        SeleniumUtil.log(log,"点击展开配件树");
        seleniumUtil.waitElementClickable(showPartTree);
        showPartTree.click();
        seleniumUtil.sleep();
    }

    //点击损失项目tab 配件树工时tab
    public void clickPartTreeLaborHourTab() {
        SeleniumUtil.log(log,"点击工时tab");
        seleniumUtil.waitElementClickable(partTreeLaborHourTab);
        this.retryClick(EstimateItemPageUI.xpath_vhl_partTree_laborHour_tab,EstimateItemPageUI.xpath_vhl_partTree_laborHour_searchButton);
    }

    //工时tab  录入工时名称 整车喷漆
    public void setPartTreeLaborHourSearch(String partName) {
        SeleniumUtil.log(log,"工时tab-输入要搜索的工时名称：" + partName);
        partTreeLaborHourSearch.clear();
        partTreeLaborHourSearch.sendKeys(partName);
    }

    //工时tab   录入名称后点击搜索图标
    public void clickPartTreeLaborHourSearchBtn() {
        SeleniumUtil.log(log,"工时tab-搜索图标：");
        partTreeLaborHourSearchBtn.click();
        seleniumUtil.sleep();
    }

    //工时tab  根据索索的工时，点击添加按钮
    public void clickPartTreeLaborHourBtn() {
        SeleniumUtil.log(log,"工时tab-点击添加工时：");
        partTreeLaborHourBtn.click();
        seleniumUtil.sleep();
    }


    //工时tab列表 通过工时名称  添加工时
    public void addLaborHourByLaborName(String partName) {
        SeleniumUtil.log(log,"工时树列表-搜索-选中-点击添加按钮");
        this.clickPartTreeLaborHourTab();
        this.setPartTreeLaborHourSearch(partName);
        this.clickPartTreeLaborHourSearchBtn();
        this.clickPartTreeLaborHourBtn();
        seleniumUtil.sleep();
    }


    //点击损失项目tab 配件树轮胎tab
    public void gotoCommonPartTab() {
        SeleniumUtil.log(log,"点击配件树轮胎tab");
        seleniumUtil.waitElementClickable(partTreeCommonPartTab);
        this.retryClick(EstimateItemPageUI.xpath_vhl_parttree_commonPart_tab,EstimateItemPageUI.xpath_vhl_claim_item_commonPart_data_search_btn);
    }

    public void setCommonPartSearchByName(String partName) {
        SeleniumUtil.log(log,"配件轮胎tab-输入要搜索的配件名称：" + partName);
        partTreeCommonPartSearchInput.clear();
        partTreeCommonPartSearchInput.sendKeys(partName);
    }

    public void clickCommonPartSearchBtn() {
        SeleniumUtil.log(log,"配件轮胎tab-搜索图标：");

        partTreeCommonPartSearchBtn.click();
        seleniumUtil.sleep();
    }

    public void searchCommonPartAndClickBtn(String partName) {
        SeleniumUtil.log(log,"配件轮胎tab-输入-搜索-选中配件");
        String xpath = "//div[contains(@class,'blockOverlay')]";
        seleniumUtil.sleep(xpath);
        this.setCommonPartSearchByName(partName);
        this.clickCommonPartSearchBtn();
    }

    public void clickCommonPartChangePartBtn(String partName) {
        SeleniumUtil.log(log,"配件轮胎tab-点击换件按钮");
        this.partTreeCommonPartChangePartBtn.click();
    }


    public void setPartSearchByName(String partName) {
        while (!seleniumUtil.isElementExist(EstimateItemPageUI.xpath_vhl_claim_item_part_data_search_btn)){
            seleniumUtil.sleep();
        }
        SeleniumUtil.log(log,"配件总成树-清空搜索框");
        claimItemDataPartPrltvSch.clear();
        SeleniumUtil.log(log,"配件总成树-输入要搜索的配件名称：" + partName);
        claimItemDataPartPrltvSch.sendKeys(partName);

    }

    public void clickPartSearchBtn() {
        SeleniumUtil.log(log,"配件总成树-搜索图标");
        claimItemDataPartPrltvSchBtn.click();
        seleniumUtil.sleep();
    }

    public void selectedPartByCategory(String partName) {
        SeleniumUtil.log(log,"配件总成树-点击选中要添加的配件名称" + partName);
        String xpath1 = "//div[@id='partListNormal']//tbody/tr/td/p[text()='" + partName + "']";
        driver.findElement(By.xpath(xpath1)).click();
    }

    public void searchPartAndSelectedByCategory(String partName) {
        seleniumUtil.log(log,"配件总成树-输入-搜索");

        String xpath = "//div[contains(@class,'blockOverlay')]";
        seleniumUtil.sleep(xpath);
        this.setPartSearchByName(partName);
        this.clickPartSearchBtn();
    }


    public void selectedCommonPartByList(String partName) {
        SeleniumUtil.log(log,"通用件配件列表-选中要添加的配件名称" + partName);
        String xpath3 = "//div[@id='common-partTyre-grid']//tbody/tr/td[@columnfield='partName']/span[text()='" + partName + "']";
        driver.findElement(By.xpath(xpath3)).click();
    }

    //通用件配件列表 添加任意类型损失项目
    public void addCommonPartByOperatorByList(String operationType, String partName) {
        SeleniumUtil.log(log,"总成树列表-搜索-选中-点击" + operationType + "按钮");
        this.gotoCommonPartTab();
        this.searchCommonPartAndClickBtn(partName);
        this.selectedCommonPartByList(partName);
        this.clickCommonPartChangePartBtn(operationType);
        seleniumUtil.sleep();
    }


    public void selectedPartByList(String partName) {
        SeleniumUtil.log(log,"配件列表-选中要添加的配件名称" + partName);
        String xpath3 = "//div[@id='partContentTree']//tbody/tr/td[@columnfield='partName']/span[text()='" + partName + "']";
        String xpath4 = "//div[@id='partContentTree']//tbody/tr/td[@columnfield='partName' and text()='" + partName + "']";
        if (seleniumUtil.isElementPresent(By.xpath(xpath3))) {
            driver.findElement(By.xpath(xpath3)).click();
        } else if (seleniumUtil.isElementPresent(By.xpath(xpath4))) {
            driver.findElement(By.xpath(xpath4)).click();
        }
    }

    public void selectedPartNoByList(String partNo) {
        SeleniumUtil.log(log,"配件列表-选中要添加的配件编号" + partNo);
        String xpath3 = "//div[@id='partContentTree']//tbody/tr/td[@columnfield='partNo'  and text()='" + partNo + "']";
        driver.findElement(By.xpath(xpath3)).click();
    }

    public void searchPartAndSelectedByList(String partName) {
        SeleniumUtil.log(log,"配件总成树-输入-搜索-选中配件");

        String xpath = "//div[contains(@class,'blockOverlay')]";
//        while (seleniumUtil.isElementExist(xpath)){
//            SeleniumUtil.log(log,"配件树加载中.....");
//            seleniumUtil.sleep();
//        }
        seleniumUtil.sleep(xpath);
        this.setPartSearchByName(partName);
        this.clickPartSearchBtn();
    }

    public void clickPartOperationTypeBtn(String operationType) {
        SeleniumUtil.log(log,"配件列表/总成树-点击" + operationType + "按钮");
        String xpath = "//div[@id='partRelatedOper']//div/span[contains(text(),'" + operationType + "')]";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickSalvageCancelBtn() {
        salvageCancelBtn.click();
    }

    //配件列表 通过配件名称  添加任意类型损失项目
    public void addPartByOperatorByName(String operationType, String partName) {
        SeleniumUtil.log(log,"总成树列表-搜索-选中-点击" + operationType + "按钮");
        this.searchPartAndSelectedByList(partName);
        this.selectedPartByList(partName);
        this.clickPartOperationTypeBtn(operationType);
        seleniumUtil.sleep();
    }

    public void addPartByOperatorByName(String operationType, String partName, String aliasName) {
        SeleniumUtil.log(log,"总成树列表-搜索-选中-点击" + operationType + "按钮");
        this.searchPartAndSelectedByList(aliasName);
        this.selectedPartByList(partName);
        this.clickPartOperationTypeBtn(operationType);
        seleniumUtil.sleep();
    }

    //搜索成功后，选中配件
    public void selectedPart(String partName) {
        SeleniumUtil.log(log,"总成树列表-搜索-选中");
        this.searchPartAndSelectedByList(partName);
        this.selectedPartByList(partName);
        seleniumUtil.sleep();
    }

    public void selectedPart(String partName, String aliasName) {
        SeleniumUtil.log(log,"总成树列表-搜索-选中");
        this.searchPartAndSelectedByList(aliasName);
        this.selectedPartByList(partName);
        seleniumUtil.sleep();
    }

    public void clickAlertOK() {
        seleniumUtil.systemAlertConform();
    }

    public void clickAlertCancel() {
        seleniumUtil.systemAlertCancel();
    }

    public void clickCategoryTreeByName(String name) {
        String xpath = "//div[@id='categoryTree']//li/div/span[text()='" + name + "']";
        driver.findElement(By.xpath(xpath)).click();
        seleniumUtil.sleep();
    }

    //总成树 添加任意类型损失项目
    public void addPartByOperatorByCategory(String operationType, String partName, String categoryName) {
        SeleniumUtil.log(log,"总成树列表-搜索-选中-点击" + operationType + "按钮");
        this.searchPartAndSelectedByCategory(partName);
        this.clickCategoryTreeByName(categoryName);
        this.selectedPartByList(partName);
        this.clickPartOperationTypeBtn(operationType);
        seleniumUtil.sleep();
    }

    public void addPartByOperatorByCategory(String operationType, String partName, String categoryName, String aliasName) {
        SeleniumUtil.log(log,"总成树列表-搜索别名-选中-点击" + operationType + "按钮");
        this.searchPartAndSelectedByCategory(aliasName);
        this.clickCategoryTreeByName(categoryName);
        this.selectedPartByList(partName);
        this.clickPartOperationTypeBtn(operationType);
        seleniumUtil.sleep();
    }

    //添加辅料项目
    public void addMaterialData(String materialName) {
        SeleniumUtil.log(log,"添加辅料项目：" + materialName);
        String xpath1 = EstimateItemPageUI.xpath_vhl_claim_item_material_data_tab;
        String xpath2 = "//tr/td[contains(text(),'" + materialName + "')]/following-sibling::td/span[@data-name='addMaterialBtn']";
        this.retryClick(xpath1,xpath2);

    }
    public boolean retryClick(String xpath1,String xpath2){
        boolean result = false;
        int count = 0;
        this.partTreeIsLoaded();
        while (count<20){
            try{
                driver.findElement(By.xpath(xpath1)).click();
                seleniumUtil.sleep();
                if(seleniumUtil.isElementExist(xpath2)){
                    driver.findElement(By.xpath(xpath2)).click();
                    seleniumUtil.sleep();
                    SeleniumUtil.log(log,"操作完成");
                    break;
                }
                SeleniumUtil.log(log,"操作未完成，请稍后...");
                count++;
            }catch (StaleElementReferenceException e){
                count++;
            }
        }
        return result;
    }



    public void preauditReportIsLoaded() {
        SeleniumUtil.log(log,"检查预审核是否完成");
        while(!seleniumUtil.isElementExist(EstimateItemPageUI.xpath_vhl_claim_task_claim_preauditreport_tab)){
            SeleniumUtil.log(log,"预审核未完成，请稍后...");
            seleniumUtil.sleep();
        }
    }

    public void clickPreauditBtn() {
        SeleniumUtil.log(log,"点击定损单菜单栏的【预审核】按钮");
        preauditBtn.click();
        this.preauditReportIsLoaded();
    }

    public void clickSaveClaimBtn() {
        SeleniumUtil.log(log,"点击定损单菜单栏的【保存】按钮");
        saveClaimBtn.click();
        seleniumUtil.sleep();
    }

    public void clickTipsBtn() {
        SeleniumUtil.log(log,"点击定损单菜单栏的【提示】按钮");
        tipsBtn.click();
        seleniumUtil.waitElementClickable(tipsWindow);
    }

    public void clickTipsCloseBtn() {
        SeleniumUtil.log(log,"关闭提示框");
        tipsWindowCloseBtn.click();
    }

    public String getPromptAlertText() {
        SeleniumUtil.log(log,"获取弹出框内容");
        String text = promptAlert.getText().trim();
        if(text!=null ||!text.equals("")){
            SeleniumUtil.log(log,"已触发前置预警相关提示信息： " + promptAlert.getText().trim());
        }else{
            seleniumUtil.log(log,text+"相关前置预警未触发");
        }
        return text;
    }


    //右侧Div 点击某个项目的回收框
    public void editItem(int row) {
        String columnFieldXpath = "//div[contains(@class,'grid-canvas-right')]//div[not(contains(@class,'new-row'))][" + row + "]/div[15]/input[@id='recycleFlagBox']";
        SeleniumUtil.log(log,columnFieldXpath);
        WebElement columnFieldXpath1 = driver.findElement(By.xpath(columnFieldXpath));
        seleniumUtil.waitElementClickable(columnFieldXpath1);
        columnFieldXpath1.click();
    }

    //为损失项目录入 对应的值 右侧Div
    public void editItem(int row, int column, String inputVal) {
        String xpath1 = "//div[contains(@class,'grid-canvas-right')]//div[not(contains(@class,'new-row'))][" + row + "]/div[" + column + "]";
        String xpath2 = xpath1 + "/input";
        retryInput(xpath1,xpath2,inputVal);
    }

    public boolean retryInput(String xpath1,String xpath2,String txt){
        boolean result = false;
        int count = 0;
        String xpath = "//p[@class='promptTitle']";
        while (count<20){
            try{
                driver.findElement(By.xpath(xpath1)).click();
                seleniumUtil.sleep();
                if(seleniumUtil.isElementExist(xpath2)){
                    driver.findElement(By.xpath(xpath2)).sendKeys(txt);
                    this.clickNoGroupViewBtn();
                    if(!seleniumUtil.isElementExist(xpath)){
                        this.clickNoGroupViewBtn();
                        String inputText = driver.findElement(By.xpath(xpath1)).getText();
                        if(inputText!=null && !inputText.equals("") && !inputText.equals("0.00")){
                            result = true;
                            SeleniumUtil.log(log,"参数值录入完成"+txt);
                            break;
                        }
                    }else{
                        SeleniumUtil.log(log,"存在弹出框");
                        result = true;
                        break;
                    }


                }
                SeleniumUtil.log(log,"参数值未录入完成，请稍后...");
                count++;
            }catch (StaleElementReferenceException e){
                count++;
            }
        }
        return result;
    }

    //自定义添加损失项目 点击操作类型列 使变为编辑模式 并选择对应操作类型
    public void setOperateTypeOfLeftDiv(String inputVal) {
        SeleniumUtil.log(log,"自定义添加损失项目 点选某行的 操作类型列 ");

        String xpath1 = "//div[contains(@class,'grid-canvas-left')]//div[(contains(@class,'new-row'))]/div[3]";
        String xpath2 = "(//li[text()='"+inputVal+"'])[last()]";
        String xpath3 = "//div[contains(@class,'grid-canvas-left')]/div[contains(@class,'active')]/div[3]";
        retryDropdownSelect(xpath1,xpath2,xpath3,inputVal);

    }

    public boolean retryDropdownSelect(String xpath1,String xpath2,String xpath3,String txt){
        boolean result = false;
        int count = 0;
        while (count<10){
            try{
                driver.findElement(By.xpath(xpath1)).click();
                seleniumUtil.sleep();
                if(seleniumUtil.isElementExist(xpath2)){
                    driver.findElement(By.xpath(xpath2)).click();
                    this.clickNoGroupViewBtn();
                    seleniumUtil.sleep();
                    String inputText = driver.findElement(By.xpath(xpath3)).getText();
                    if(inputText.equals(txt)){
                        result = true;
                        SeleniumUtil.log(log,"下拉框选择完成"+txt);
                        break;
                    }
                }
                SeleniumUtil.log(log,"下拉框未选择完成，请稍后...");
                count++;
            }catch (StaleElementReferenceException e){
                count++;
            }
        }
        return result;
    }


    //自定义添加损失项目 点击使变为编辑模式并录入值（左侧DIV）
    public void setPartNameOrNoOfLeftDiv(int row, int column, String inputVal1, String inputVal2) {
        SeleniumUtil.log(log,"自定义添加损失项目 点击损失项目列表 中"+row+"行"+column+"+列 ");

        String xpath1= "//div[contains(@class,'grid-canvas-left')]//div[(contains(@class,'active'))]/div[4]";
        String xpath2 = xpath1 + "/input";
        retryInput(xpath1,xpath2,inputVal2);
    }

    //自定义添加项目（左侧DIV）
    public void customAddItem(int row, int column, String inputVal1, String inputVal2) {
        this.partTreeClose();
        this.setOperateTypeOfLeftDiv(inputVal1);
        this.setPartNameOrNoOfLeftDiv(row, column, inputVal1, inputVal2);
    }

    //自定义添加项目（左侧DIV+右侧DIV）
    public void customAddItem(int row, int column1, int column2, String inputVal1, String inputVal2, String inputVal3) {
        this.setOperateTypeOfLeftDiv(inputVal1);
        this.setPartNameOrNoOfLeftDiv(row, column1, inputVal1, inputVal2);
        this.editItem(row, column2, inputVal3);
    }


    //点击提交按钮
    public void clickSubmitBtn() {
        this.submitClaimBtn.click();
        seleniumUtil.sleep();
        this.fiveSecondTipIsExist();
    }

    //直接提交定损单
    public void submitClaimTask(String currentHandle) {
        SeleniumUtil.log(log,"点击定损单菜单栏的【提交】按钮");
        submitClaimBtn.click();
        seleniumUtil.sleep();
        seleniumUtil.waitElementClickable(tipsSubmitBtn);
        tipsSubmitBtn.click();
        seleniumUtil.sleep();
        seleniumUtil.waitElementClickable(alertSubmitClaimBtn);
        alertSubmitClaimBtn.click();
        this.clickAlertOK();
        seleniumUtil.switchToPreWindow(currentHandle);
    }

    public void partTreeClose() {
        SeleniumUtil.log(log,"点击配件树的【关闭】按钮");
        seleniumUtil.waitElementClickable(partTreeCloseBtn);
        partTreeCloseBtn.click();
        this.partTreeIsNotLoaded();
    }

    public void partTreeOpen() {
        SeleniumUtil.log(log,"打开配件树界面");
        WebElement showAddWindow = driver.findElement(By.id("showAddWindow"));
        seleniumUtil.waitElementClickable(showAddWindow);
        showAddWindow.click();
        this.partTreeIsLoaded();
    }


    //通过规则名称，规则编号 判断是否存在且为红线规则
    public Boolean getRuleNo(String partName, String ruleNo, String isRedRule) {
        String xpath_ruleNo = "//tr/td/following-sibling::td/span[contains(text(),'" + partName + "')]/parent::td/preceding-sibling::td[@columnfield='ruleNo' and text()='" + ruleNo + "']";
        String xpath_ruleColor = "//tr/td/following-sibling::td/span[contains(text(),'" + partName + "')]/parent::td/preceding-sibling::td[@columnfield='ruleNo' and text()='" + ruleNo + "']/parent::tr[@style='color:red']";
        this.fiveSecondTipIsExist();
        if (isRedRule.equals("1")) {
            if (seleniumUtil.isElementExist(xpath_ruleNo) && seleniumUtil.isElementExist(xpath_ruleColor)) {
                SeleniumUtil.log(log,"ok,红线规则"+ruleNo+" 已触发 ");
                return true;
            }
            SeleniumUtil.log(log,"ok,红线规则"+ruleNo+" 未触发 ");
        } else {
            if (seleniumUtil.isElementExist(xpath_ruleNo)) {
                SeleniumUtil.log(log,"ok,普通规则"+ruleNo+" 已触发 ");
                return true;
            }
            SeleniumUtil.log(log,"ok,普通规则"+ruleNo+" 未触发 ");
        }
        return false;
    }

    public Boolean getRuleNo( String ruleNo, String isRedRule) {
        String xpath_ruleNo = "//td/preceding-sibling::td[@columnfield='ruleNo' and text()='" + ruleNo + "']";
        String xpath_ruleColor = "//td/preceding-sibling::td[@columnfield='ruleNo' and text()='" + ruleNo + "']/parent::tr[@style='color:red']";

        if (isRedRule.equals("1")) {
            if (seleniumUtil.isElementExist(xpath_ruleNo) && seleniumUtil.isElementExist(xpath_ruleColor)) {
                SeleniumUtil.log(log,"ok,红线规则"+ruleNo+" 已触发 ");
                return true;
            }
        } else {
            if (seleniumUtil.isElementExist(xpath_ruleNo)) {
                SeleniumUtil.log(log,"ok,普通规则"+ruleNo+" 已触发 ");
                return true;
            }
            SeleniumUtil.log(log,"ok,普通规则"+ruleNo+" 未触发 ");
        }
        return false;
    }

    public boolean partTreePaintBtnIsdisable() {
        SeleniumUtil.log(log,"判断配件树喷漆按钮是否置灰 不可点选");
        return seleniumUtil.isElementExist(EstimateItemPageUI.xpath_vhl_claim_parttree_paint_btn_disable);
    }

    public boolean partTreeRepairBtnIsdisable() {
        SeleniumUtil.log(log,"判断配件树维修按钮是否置灰 不可点选");
        return seleniumUtil.isElementExist(EstimateItemPageUI.xpath_vhl_claim_parttree_repair_btn_disable);
    }

    public boolean partTreePartIsExist(String partName) {
        this.searchPartAndSelectedByList(partName);
        SeleniumUtil.log(log,"配件列表-选中要添加的配件名称" + partName);
        String xpath = "//div[@id='partContentTree']//tbody/tr/td[@columnfield='partName']/span[text()='" + partName + "']";
        return seleniumUtil.isElementExist(xpath);
    }

    public boolean configTipIsExist(String tipVal) {


        String xpath = "//div[@id='validationWindow']//div[@class='mainTipsInfo']//span[text()='" + tipVal + "']";
        boolean result = false;
        int count = 0;
        this.fiveSecondTipIsExist();

        while (count<10){
            try{
                driver.findElement(By.xpath(EstimateItemPageUI.xpath_topNav_submitClaim_btn)).click();
                String xpath1 = "//div[contains(@class,'blockOverlay')]";
                seleniumUtil.sleep(xpath1);
                if(seleniumUtil.isElementExist(xpath)){
                    driver.findElement(By.xpath(xpath)).getText();
                    seleniumUtil.sleep();
                    SeleniumUtil.log(log,"定损单提示框中存在" + tipVal);
                    result = true;
                    break;
                }
                SeleniumUtil.log(log,"提示信息未加载完成，请稍后...");
                count++;
            }catch (StaleElementReferenceException e){
                count++;
            }
        }
        return result;

    }

    public boolean laborHourDeductionIsExist() {
        String xpath = "//div[contains(@class,'grid-canvas-left')]//div[@title='工时扣减']";
        SeleniumUtil.log(log,"检查定损单是否存在工时扣减");
        return seleniumUtil.isElementExist(xpath);
    }

    public boolean materialDataIsExist(String materialName) {
        String xpath = "//div[@id='materialDataLinkTab']//tr/td[@columnfield='materialName' and text()='" + materialName + "']";
        SeleniumUtil.log(log,"检查辅料tab是否存在辅料" + materialName);
        return seleniumUtil.isElementExist(xpath);
    }

    public void fiveSecondTipIsExist() {
        String xpath = "//div[@id='growls']//div[@class='growl-message']";
        SeleniumUtil.log(log,"检查5s提示是否存在");
        int count=0;
        while(count<30) {
            try {
                if (!seleniumUtil.isElementExist(xpath)) {
                    SeleniumUtil.log(log, "5s提示不存在");
                    break;
                }
                SeleniumUtil.log(log, "5s提示存在，等待....");
                seleniumUtil.sleep();
                count++;
            }catch (Exception e){
                seleniumUtil.sleep();
                count++;
            }
        }

    }

    public void claimTaskIsFinished() {
        String blockOverlayXpath = "//div[contains(@class,'blockOverlay')]";
        seleniumUtil.sleep(blockOverlayXpath);
        String xpath = "//input[@id='accidentNo']";
        SeleniumUtil.log(log,"检查定损单是否加载完成");

        seleniumUtil.sleep(20,xpath,0);
    }
}

