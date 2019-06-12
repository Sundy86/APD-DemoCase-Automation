package com.cccis.UIMap;

public class PriceCheckTaskPageUI {
    //APD核价页面，核价标签
    public static final String xpath_audit_priceChecker_tab = "//a[text()='核价']";
    //APD核价页面，待核价工作池
    public static final String xpath_pending_audit_priceChecker_work_pool_btn = "//a[text()='待核价工作池']";
    //APD核价页面，任务列表
    public static final String xpath_audit_priceChecker_task_list_btn = "//li[a[text()='待核价工作池']]/following-sibling::li/a[text()='任务列表']";
    //APD核价页面-事故号输入框
    public static final String xpath_accidentNo_text_field = "//input[@id = 'accidentNo']";
    //APD核价页面-查询按钮
    public static final String xpath_Search_btn = "//div[@id = 'btnSearch']";

    //APD核价页面-核价定损单-批准按钮
    public static final String xpath_audit_priceChecker_approval_btn = "//span[@id='approveClaim']";
    //APD核价页面-核价定损单-批准-提示框-提交按钮
    public static final String xpath_audit_alert_submit_btn = "//div[@id='validationWindow']//div[@id='submitBtn']";
    //弹出框 确定按钮
    public static final String xpath_audit_prompt_button = "//div[contains(@style,'display: block')]//div[contains(@class,'prompt_button')]//span[text()='确定']";

}
