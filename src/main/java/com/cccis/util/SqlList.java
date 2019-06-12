package com.cccis.util;

/**
 * Created by HePing on 2017/5/4.
 */
public class SqlList {

    //所有的sql都记录在此，需替换的参数用 #_# 来标注
    //每条sql都需要写清详细用途

    // e.g
    // 用途：通过claimNo 查询 claimId
    public static final String sql_select_claimId = "select c.claimid from t_claim c where c.claimNo='#_#'";


    public static final String sql_select_partPrice = "select lo.price1 from t_md_part_local_price_cn00319 lo where lo.part_no='#_#' and lo.insurance_area_id='10041'";

    // 用途：查询查勘单的状态，通过accident_no 查询 survey_status
    public static final String sql_select_survey = "select f.survey_status from t_survey_wf f,t_survey tc where f.survey_id=tc.survey_id and tc.accident_no ='#_#' and tc.valid_flag=1";
    //用途：查询报价单的状态，通过accident_no and loss_subject 查询 status
    public static final String sql_select_inquiry = "SELECT c.status FROM t_claim_inquiry c,t_claim tc where c.claim_id= tc.claim_id and tc.accident_no = '#_#'and tc.loss_subject='#_#' order by inquiry_id desc";
    //用途：查询会签单的状态，通过accident_no and loss_subject 查询 status
    public static final String sql_select_counterSign = "SELECT c.claim_status FROM t_claim_counter_sign c, t_claim tc where c.claim_id=tc.claim_id and tc.accident_no = '#_#' and c.loss_vehicle='#_#' order by counter_sign_id desc";
    //用途：查询旧件回收单的状态，通过accident_no and loss_subject or plate_no(车损) 查询 status
    public static final String sql_select_salvage = "select a.salvage_status from t_salvage_wf a,t_salvage b where  a.salvage_id=b.salvage_id and b.accident_no='#_#' and b.#_#='#_#'";


    // 用途：查询定损单的状态，通过accident_no and loss_subject 查询 survey_status
    public static final String sql_select_property = "SELECT f.claim_status FROM t_claim_wf f，t_claim tc where f.claim_id=tc.claim_id and tc.accident_no = '#_#' and tc.task_type='#_#'";
    // 用途：查询别名对应的标准件名称，通过alias_name 查询 standard_part_name
    public static final String sql_select_standardpartname = "select a.standard_part_name from t_md_standard_part_alias a where a.alias_name='#_#'";

}
