package com.cccis.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by HePing on 2016/12/21.
 */


public class RandomString {

    Date date;
    SimpleDateFormat sdf;
    String strDate;

    public String getRandomString() {
        date = new Date();
        sdf = new SimpleDateFormat("MMddHHmm");
        strDate = sdf.format(date);
        //System.out.println(strDate);

        return strDate;

    }

}
