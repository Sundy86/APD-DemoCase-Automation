package com.cccis.UIMap;

public class ReinspectTaskPageUI {
    //APD核损页面，核损标签
    public static final String xpath_audit_reinspection_tab = "//li[@role='menuitem']/a[text()='核损']";
    //APD核损页面，待核损工作池
    public static final String xpath_pending_audit_reinspection_work_pool_btn = "//a[text()='待核损工作池']";
    //APD核损页面，任务列表
    public static final String xpath_audit_reinspection_task_list_btn = "//li[a[text()='待核损工作池']]/following-sibling::li/a[text()='任务列表']";
    //APD核损页面-事故号输入框
    public static final String xpath_accidentNo_text_field = "//input[@id = 'reinspectAccidentNo']";
    //APD核损页面-查询按钮
    public static final String xpath_Search_btn = "//div[@id = 'btnSearch']";
    //APD核损页面-审核报告tab
    public static final String xpath_auditReport_tab = "//li[@id='auditReportTab']";
    //APD核损页面-损失项目tab
    public static final String xpath_claimItem_tab = "//li[@id='claimItem']";

}
