package com.cccis.UIMap;

public class EstimateItemPageUI {

    //车辆信息tab
    public static final String xpath_vhl_claim_task_claim_vehicleinfo_tab = "//li[@id='claimVehicleInfo']/a[contains(text(),'车辆信息')]";

    public static final String xpath_vhl_claim_task_claim_passengerVehicle_radio = "//input[@id='passengerVehicle']";
    public static final String xpath_vhl_claim_task_claim_commercialVehicle_radio = "//input[@id='commercialVehicle']";
    //车辆信息 款型名称
    public static final String xpath_vhl_claim_task_claim_vehicleSubModelId_input = "//input[@aria-owns='vehicleSubModelId_listbox']/parent::span/following-sibling::input";
    //修理厂信息tab
    public static final String xpath_vhl_claim_task_claim_repairshop_tab = "//li[@id='claimRepaireShop']/a[contains(text(),'修理厂信息')]";
    //损失项目tab
    public static final String xpath_vhl_claim_task_claimitem_tab = "//li[@id='claimItem']/a[contains(text(),'损失项目')]";
    //审核报告tab
    public static final String xpath_vhl_claim_task_claim_preauditreport_tab = "//li[@id='preauditReportTab']/a[contains(text(),'审核报告')]";
    //VIN
    public static final String xpath_vhl_vehicleinfo_vin_input = "//input[@id='vinCode']";

    public static final String xpath_vhl_vehicleinfo_definebyvin_btn = "//span[@id='defineByVin']";
    //款型名称
    public static final String xpath_vhl_vehicleSubModelName_flied = "//td[@id='key_vehicle_model']";

    //修理厂信息tab--修理厂查询按钮
    public static final String xpath_vhl_repair_factory_search_btn = "//a[@id = 'btnSearchrepairFactory']";

    //修理厂信息tab--修理厂ID
    public static final String xpath_vhl_repair_factoryId_input = "//td[@id='tdRepairFactoryCode']";
    //修理厂信息tab--合作修理厂对话框-修理厂名称
    public static final String xpath_vhl_rf_search_name_txt = "//div[@id = 'divRepairFactorySelector']//input[@id = 'txtSearchRepairFactoryName']";
    //修理厂信息tab-点击是否专属厂牌
    public static final String xpath_exclusiveSearch_dropdown = "//span[@aria-owns='selectExclusiveFlag_listbox']//span[text()='select']";
    //修理厂信息tab-是否专属厂牌- 请选择
    public static final String xpath_exclusiveSearch_select = "//div[contains(@style,'display: block')]//ul[@id='selectExclusiveFlag_listbox']/li";

    //修理厂信息tab--合作修理厂对话框-查询按钮
    public static final String xpath_vhl_rf_search_btn = "//div[@id = 'divRepairFactorySelector']//span[@id = 'lblSearch']";

    //修理厂信息tab--合作修理厂对话框-添加按钮
    public static final String xpath_vhl_rf_grid_add_btn = "//div[@id = 'grdRepairFactory']//tr/td/span[@class = 'addBtnIco']";

    //修理厂信息tab--配件渠道
    public static final String xpath_vhl_rf_partType_select = "//span[@aria-owns='cboPartType_listbox']//span[text()='select']";
    //损失项目tab--配件树 轮胎tab
    public static final String xpath_vhl_parttree_commonPart_tab = "//div[@id='showAddEstItemDiv']//li/a[text()='轮胎']";

    //损失项目tab--损失项目subTab-配件单价调整1
    public static final String xpath_vhl_claim_item_adjust_rate_text_field = "//input[@id='claimItemAdjustRate']";
    //损失项目tab--损失项目subTab-配件单价调整2
    public static final String xpath_vhl_claim_item_adjust_rate_fee_text_field = "//input[@id='claimItemAdjustRate']/preceding-sibling::input";

    //损失项目tab-展开配件树
    public static final String xpath_vhl_show_partTree_btn = "//span[@id='showAddWindow']";

    public static final String  xpath_vhl_partTree_div = "//div[@id='showAddEstItemDiv']/parent::div[contains(@style,'display: block')]";

    //损失项目tab-配件树工时tab
    public static final String xpath_vhl_partTree_laborHour_tab = "//div[@id='showAddEstItemDiv']//li/a[text()='工时']";
    //损失项目tab-配件树工时tab-搜索文本框
    public static final String xpath_vhl_partTree_laborHour_search = "//input[@id='searchLaborHourInput']";
    //损失项目tab-配件树-工时tab-搜索框的放大镜按钮
    public static final String xpath_vhl_partTree_laborHour_searchButton = "//span[@id='searchLaborHourBtn']";
    //损失项目tab-配件树-工时tab-添加工时+按钮
    public static final String xpath_vhl_partTree_laborHour_addLaborHourButton = "//td/span[@data-name=\"addLaborHourBtn\"]";


    //损失项目tab--损失项目subTab-配件tab
    public static final String xpath_vhl_claim_item_part_data_tab = "//div[@id=\"addEstItemTabStrip\"]//li/a[text()='配件']";
    //损失项目tab--损失项目subTab-工时tab
    public static final String xpath_vhl_claim_item_labor_data_tab = "//li[@id = 'laborDataTab']";

    //损失项目tab--损失项目subTab-辅料tab
    public static final String xpath_vhl_claim_item_material_data_tab = "//li[@id = 'materialDataTab']";

    //损失项目tab--损失项目subTab-列表图标
    public static final String xpath_vhl_claim_item_nogroupview_btn = "//span[@id='noGroupView']";

    //损失项目tab--损失项目subTab-配件tab-配件搜索文本框
    public static final String xpath_vhl_claim_item_part_data_search_input = "//div[@id = 'partPrltvSch']/input[@id = 'partFuzzySearchKey']";
    //损失项目tab--损失项目subTab-轮胎tab-配件搜索文本框
    public static final String xpath_vhl_claim_item_commonPart_data_search_input = "//div[@id = 'commonPartTyrePrltvSch']//input[@id = 'commonPartTyreFuzzySearchKey']";
    //损失项目tab--损失项目subTab-轮胎tab--配件搜索按钮
    public static final String xpath_vhl_claim_item_commonPart_data_search_btn = "//div[@id = 'commonPartTyrePrltvSch']/span[@id = 'commonPartTyreFuzzySearch']";
    //损失项目tab--损失项目subTab-轮胎tab--换件按钮
    public static final String xpath_vhl_claim_item_commonPart_changePart_btn = "//div[@id = 'commonPartTyreRelatedOper']//span[@id = 'span_changeCommonPartTyre']";

    //损失项目tab--损失项目subTab-配件tab-配件搜索按钮
    public static final String xpath_vhl_claim_item_part_data_search_btn = "//div[@id = 'partPrltvSch']/span[@id = 'partFuzzySearch']";
    //损失项目tab--添加项目时弹出残值/折旧框 取消按钮
    public static final String xpath_vhl_claim_item_part_salvage_cancel_btn = "//div[@id='claimSalvageAndDepreciationWindow']//div[@id='salvageCencelBtn']/span";

    //配件树 关闭图标
    public static final String xpath_vhl_claim_partTree_close_btn = "//span[text()='配件/工时/辅料']/following-sibling::div//span[text()='Close']";
    //提示框
    public static final String xpath_vhl_claim_promptAlert_window = "//div[contains(@class,'prompt_content')]/p[@class='promptTitle']";
    //提示框 关闭
    public static final String xpath_vhl_claim_promptAlert_close_btn = "//span[@id='validationWindow_wnd_title']/following-sibling::div/a/span";

    public static final String xpath_vhl_claim_parttree_paint_btn_disable = "//div[@id='partRelatedOper']//span[@id='span_paint']/parent::div[contains(@class,'disable')]";

    public static final String xpath_vhl_claim_parttree_repair_btn_disable = " //div[@id='partRelatedOper']//span[@id='span_repair']/parent::div[contains(@class,'disable')]";

    //导航栏--提示按钮
    public static final String xpath_topNav_tips_btn = "//div[@class = 'topNav']//span[@id = 'tipsBtn']";
    //导航栏--提示框
    public static final String xpath_topNav_tips_window = "//div[@id='validationWindow']";
    //导航栏--保存按钮
    public static final String xpath_topNav_saveClaim_btn = "//div[@class = 'topNav']//span[@id = 'saveClaim']";
    //导航栏--提交按钮
    public static final String xpath_topNav_submitClaim_btn = "//div[@class = 'topNav']//span[@id = 'submitClaim']";
    //导航栏--预审核按钮
    public static final String xpath_topNav_preaudit_btn = "//div[@class = 'topNav']//span[@id = 'preaudit']";
    //导航栏--提示框--关闭图标
    public static final String xpath_topNav_tips_close_btn = "//span[text()='提示信息']/following-sibling::div/a/span[text()='Close']";
    //导航栏--提示框--提交按钮
    public static final String xpath_topNav_tips_submit_btn = "//div[contains(@class,'window-submit')]//div[@id='submitBtn']//span";
    //直接提交定损单
    public static final String xpath_topNav_alert_submit_btn = "//div/span[text()='直接提交定损单']";


}
