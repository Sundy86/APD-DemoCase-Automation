package com.cccis.util;

import java.io.*;

import static com.cccis.util.GlobalSetting.CLAIM_XML_PATH;

/**
 * Created by HePing on 2016/12/8.
 */
public class ClaimTemp {


    public String readXml() throws IOException {

        InputStream inputStream = null;
        String filePath = CLAIM_XML_PATH;
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String aline = null;
            while ((aline = bufferedReader.readLine()) != null) {
                sb.append(aline).append("\n");
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        //  System.out.println(sb.toString()) ;
        return sb.toString();
    }

    public String getClaimXml(String userAccount, String accidentNo, String claimNo, String claimCompanyId, String lossVehicleType, String vin) throws IOException {
        String strXML = readXml();
//        System.out.println(strXML);
        String claimTemplate = strXML.replace("=claimCompanyId=", claimCompanyId)
                .replace("=accidentNo=", accidentNo)
                .replace("=estimator=", userAccount)
                .replace("=claimNo=", claimNo)
                .replace("=lossVehicleType=", lossVehicleType)
                .replace("=vin=", vin);


        return claimTemplate;
    }

}
