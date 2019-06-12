package com.cccis.UIMap;

public class EstimateTaskListPageUI {
    //APD定损页面，定损菜单
    public static final String xpath_estimate_tab = "//li[@role='menuitem']/a[text()='定损']";
    //定损任务列表页面，事故号
    public static final String xpath_accidentNo_link_field = "//td[@columnfield='accidentNo']/a[contains(text(),'sc_acc_11061113045581')]";

    public static final String xpath_accidentNo_input = "//input[@id='accidentNo']";
    public static final String xpath_btnSearch_btn = "//div[@id='btnSearch']";
    // ccc add 0424  定损link
    public static final String xpath_estimateTask_href = "//li/a[text()='定损']";
    // ccc add 0424 定损任务列表
    public static final String xpath_estimateTaskList_href = "//a[@href='/web-suite/claim/estimateTaskList'and text()='任务列表']";


}

