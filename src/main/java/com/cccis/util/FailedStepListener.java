package com.cccis.util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.cccis.util.GlobalSetting.SCREENSHOT_PATH;

public class FailedStepListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result){
        takeScreenshot(result);

    }

    @Attachment(value = "screenshot",type = "image/png")
    public byte[] takeScreenshot(ITestResult result){
        byte[] screenshotAs = ((TakesScreenshot)CommonTest.chrome_driver).getScreenshotAs(OutputType.BYTES);
        String[] classNameArr = result.getTestClass().getName().split("\\.");
        String className = classNameArr[classNameArr.length-1];
        String methodName = result.getName();
        String time  = new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date());
        String date  = new SimpleDateFormat("yyyyMMdd").format(new Date());

        String scrFolder = SCREENSHOT_PATH+date+"/"+className;

        File dir = new File(scrFolder);

        if(!dir.exists()){
            dir.mkdirs();
        }

        String picPath = scrFolder+"/"+methodName+time+".png";

        try (FileOutputStream out = new FileOutputStream(picPath)){
            out.write(screenshotAs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotAs;
    }
}
