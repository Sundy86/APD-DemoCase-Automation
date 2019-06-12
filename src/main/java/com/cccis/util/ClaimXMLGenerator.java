package com.cccis.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HePing on 2016/12/8.
 */
public class ClaimXMLGenerator {
    private static Logger log = LogManager.getLogger(ClaimXMLGenerator.class);
    String strDate;
    String newClaimXml;
    int random;
    Date date;
    SimpleDateFormat sdf;
    private String accidentNo;
    private String claimNo;

    public ClaimXMLGenerator() {
        date = new Date();
        sdf = new SimpleDateFormat("MMddhhmmssSSS");
        strDate = sdf.format(date);
        random = (int) Math.random() * 1000 + 1;

    }


    public String getUniqueAccidentNo() {
        accidentNo = "Acc_demo_" + strDate + random;
        return accidentNo;

    }

    public String getUniqueClaimNo() {
        claimNo = "claim_demo_" + strDate + random;
        return claimNo;
    }

    public String getNewClaimXML(String userAccount, String lossVehicleType, String vin, String claimCompanyId) throws IOException {
        accidentNo = getUniqueAccidentNo();
        claimNo = getUniqueClaimNo();
        ClaimTemp ct = new ClaimTemp();
        newClaimXml = ct.getClaimXml(userAccount, accidentNo, claimNo, claimCompanyId, lossVehicleType, vin);

        return newClaimXml;
    }

}
