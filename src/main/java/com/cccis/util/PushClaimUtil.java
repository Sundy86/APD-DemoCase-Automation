package com.cccis.util;


import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.cccis.util.GlobalSetting.PUSHCLAIM_URL;

/**
 * Created by HePing on 2016/12/8.
 */
public class PushClaimUtil {

    ClaimXMLGenerator cx = new ClaimXMLGenerator();
    private Logger log;

    public PushClaimUtil(Logger log) {
        this.log = log;
    }

    public String getClaimNo() {

        String claimNo = cx.getUniqueClaimNo();
        SeleniumUtil.log(log,"ClaimNo = " + claimNo);
        return claimNo;
    }

    public void importClaimTask(String userAccount, String lossVehicleType, String vin, String claimCompanyId) {
        try {
            String soapRequestData = cx.getNewClaimXML(userAccount, lossVehicleType, vin, claimCompanyId);
            String ret = HttpUtils.doPostByType("json", PUSHCLAIM_URL, soapRequestData);
            // SeleniumUtil.log(log,ret);
        } catch (HttpClientException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAccidentNo() throws IOException, InterruptedException {
        String accidentNo = cx.getUniqueAccidentNo();
        SeleniumUtil.log(log,"accidentNo = " + accidentNo);

        return accidentNo;
    }
}
