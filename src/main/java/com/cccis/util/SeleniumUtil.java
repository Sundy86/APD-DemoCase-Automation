package com.cccis.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.db.type.Request;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.cccis.util.DBUtil.getSingleResultSet;
import static com.cccis.util.DBUtil.updateSQL;
import static com.cccis.util.GlobalSetting.*;
import static io.qameta.allure.Allure.step;


/**
 * Created by HePing on 2017/3/15.
 */
public class SeleniumUtil {

    private static Logger log = LogManager.getLogger(SeleniumUtil.class);
    WebDriver driver;
    WebDriverWait wait;

    public SeleniumUtil(WebDriver driver, Logger log) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, ELEMENT_TIMEOUT);

    }

    /**
     * 切换到目标窗口
     *
     * @return 当前窗口的句柄
     */

    public String switchToSpecificWindow(String windowTitle) {

        this.longSleep();
        Set<String> handleSet = driver.getWindowHandles();
        int winCount = handleSet.size();
        SeleniumUtil.log(log,"窗口数量"+winCount);
        String handle = driver.getWindowHandle();

        if(winCount>1) {
            for (String s:handleSet){
                driver.switchTo().window(s);
                if(driver.getTitle().equals("个人绩效看板")){
                    driver.close();
                    SeleniumUtil.log(log,"关闭个人绩效看板");
                }else{
                    handle = s;
                }
            }
        }
        driver.switchTo().window(handle);
        return handle;
    }




    /**
     * 切换到新窗口
     *
     * @return 当前窗口的句柄
     */

    public String switchToNewWindow() {

        this.sleep();

        Set<String> allWindowHandles = driver.getWindowHandles();
        String curWindowHandle = driver.getWindowHandle();
        String currentWindow = null;
        SeleniumUtil.log(log,"当前窗口句柄：" + curWindowHandle);
        SeleniumUtil.log(log,"窗口数量" + allWindowHandles.size());

        for (String s : allWindowHandles) {
            driver.getTitle();
            if (s.equals(curWindowHandle)) {
                SeleniumUtil.log(log,"当前窗口，继续");
                continue;
            } else {
                SeleniumUtil.log(log,"跳转到新窗口：" + s);
                driver.switchTo().window(s);
            }
        }

        return currentWindow;
    }

    /**
     * 切换到指定窗口
     *
     * @param windowHandle
     */

    public void switchToPreWindow(String windowHandle) {

        SeleniumUtil.log(log,"切换到先前窗口：" + windowHandle);
        driver.switchTo().window(windowHandle);

    }

    /**
     * 点击Windows弹出框确定按钮
     */

    public void windowAlertClickOK() {
        sleep();

        if (isAlertPresent()) {

            Alert alert = driver.switchTo().alert();

            SeleniumUtil.log(log,"弹出框内容：" + alert.getText());
            SeleniumUtil.log(log,"点击弹出框确定按钮");
            alert.accept();
        } else {
            SeleniumUtil.log(log,"没有发现弹出框");
        }

    }

    /**
     * 点击Windows弹出框取消按钮
     */

    public void windowAlertClickCancel() {

        Alert alert = driver.switchTo().alert();

        SeleniumUtil.log(log,"点击弹出框取消按钮");
        alert.dismiss();

    }

    /**
     * 获取弹出框中的内容
     */

    public String windowsAlertText() {
        sleep();
        String text = null;

        if (isAlertPresent()) {

            Alert alert = driver.switchTo().alert();
            text = alert.getText();
            SeleniumUtil.log(log,"弹出框内容：" + text);

        } else {
            SeleniumUtil.log(log,"没有发现弹出框");
        }

        return text;
    }

    /**
     * 点击系统弹出框确定按钮
     */

    public void systemAlertConform() {
        sleep();
        SeleniumUtil.log(log,"弹出框:" + this.systemAlertText());
        String xpath = "//div[contains(@class,'prompt_window')]//span[contains(text(),'确定')]";
        this.waitElementClickable(driver.findElement(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * 点击系统弹出框取消按钮
     */

    public void systemAlertCancel() {
        sleep();
        String xpath = "//div[contains(@class,'prompt_window')]//span[contains(text(),'取 消')]";
        this.waitElementClickable(driver.findElement(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * 获取系统弹出框内容
     */

    public String systemAlertText() {
        sleep();
        String xpath = "//p[@class='promptTitle']";
        return driver.findElement(By.xpath(xpath)).getText();
    }

    /**
     * 仅针对核心系统的myFrame跳入
     */
    public void switchToMyFrame() {
        SeleniumUtil.log(log,"切换到 myFrame中");
        driver.switchTo().frame("myFrame");
    }

    public String getJsExecutor(String script) {
        SeleniumUtil.log(log,"使用JavascriptExecutor获取内容");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    public String repalceStr(String oldStr, String params) {
        SeleniumUtil.log(log,"替换指定字符串中的参数");
        String expectStr = oldStr.replace("partname", params);
        return expectStr;
    }

    /**
     * 跳入frame
     *
     * @param frameName
     */

    public void switchToFrame(String frameName) {
        SeleniumUtil.log(log,"切换到 " + frameName + " frame中");
        driver.switchTo().frame(frameName);
    }

    /**
     * 跳入frame
     *
     * @param frameWebElement
     */

    public void switchToFrame(WebElement frameWebElement) {
        SeleniumUtil.log(log,"切换到 frame 中");
        driver.switchTo().frame(frameWebElement);
    }

    /**
     * 跳入frame
     *
     * @param frameId
     */

    public void switchToFrame(int frameId) {
        SeleniumUtil.log(log,"切换到第" + frameId + "个frame 中");
        driver.switchTo().frame(frameId);
    }

    /**
     * 跳出frame，返回default Content
     */

    public void switchToDefaultContentFromFrame() {
        SeleniumUtil.log(log,"跳出frame");
        driver.switchTo().defaultContent();
    }

    /**
     * 清除输入框的数据
     *
     * @param textInput
     */

    public void clearText(WebElement textInput) {
        SeleniumUtil.log(log,"清除数据");
        textInput.click();
        textInput.clear();
    }

    /**
     * 判断元素是否选中
     *
     * @param textInput
     */
    public Boolean checkIsSelected(WebElement textInput) {
        SeleniumUtil.log(log,"判断复选框元素是否选中");
        Boolean flag = false;
        if (textInput.isSelected()) {
            SeleniumUtil.log(log,"当前复选框已选中");
            flag = true;
        } else {
            SeleniumUtil.log(log,"当前复选框未选中");
        }
        return flag;

    }

    /**
     * 在日历中选择 “今天” 按钮
     */

    public void clickTodayInCalender() {
        SeleniumUtil.log(log,"跳入日期Frame");
        WebElement calenderFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(calenderFrame);
        WebElement todayBtn = driver.findElement(By.xpath("//input[@id = 'dpTodayInput']"));
        SeleniumUtil.log(log,"点击 今天 按钮");

        todayBtn.click();
        SeleniumUtil.log(log,"跳出日期Frame");
        driver.switchTo().defaultContent();
    }

    /**
     * 针对TPIC的下拉框操作封装的方法
     *
     * @param dropdownName
     * @param option
     * @param dropdownNameSelect
     */
    //*[contains(@role,'box')and contains(@aria-owns,'"+dropdownName+"')]
    public void selectStandardDropdown(String dropdownName, String dropdownNameSelect, String option) {
        String xpath_dropdown = "//td//label[contains(text(),'" + dropdownName + "')]/parent::span/parent::td/following-sibling::td//span[contains(@role,'listbox')]//span[contains(text(),'" + dropdownNameSelect + "')]";
        String xpath_option = "//li[@role = 'option' and text() = '" + option + "']";

        WebElement standardDropdown = driver.findElement(By.xpath(xpath_dropdown));
        SeleniumUtil.log(log,"点击下拉框：" + dropdownName);
        waitElementClickable(standardDropdown);
        standardDropdown.click();

        this.sleep();
        WebElement standardOption = driver.findElement(By.xpath(xpath_option));
        SeleniumUtil.log(log,"点击选项：" + option);
        waitElementClickable(standardOption);
        standardOption.click();
    }

    /**
     * 短等待 - 5s
     */

    public void sleep() {
        try {
            log.debug("等待" + ELEMENT_SLEEP_TIME + "ms");

            Thread.sleep(ELEMENT_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 长等待 - 10s
     */
    public void longSleep() {
        try {
            log.debug("等待" + ELEMENT_LONG_SLEEP_TIME + "ms");

            Thread.sleep(ELEMENT_LONG_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /**
     * 等待输入框enable
     *
     * @param webElement
     */

    public void waitElementClickable(WebElement webElement) {
        long startTime = System.currentTimeMillis();
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;

        log.debug("等待时间：" + Float.toString(seconds) + " seconds.");
    }

    /**
     * 等待页面元素出现
     *
     * @param xpath
     */
    public void waitWebElementDisplay(String xpath) {

        long startTime = System.currentTimeMillis();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;

        log.debug("等待时间：" + Float.toString(seconds) + " seconds.");
    }

    /**
     * 等待搜索结果出现
     *
     * @param searchCondition
     */
    public void waitSearchResult(String searchCondition) {
        String xpath = "//*[text() = '" + searchCondition + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        sleep();
    }

    /**
     * 等待元素不可见
     *
     * @param xpath
     */

    public void waitElementInvisible(String xpath) {

        long startTime = System.currentTimeMillis();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        long endTime = System.currentTimeMillis();
        float seconds = (endTime - startTime) / 1000F;

        log.debug("等待消失时间：" + Float.toString(seconds) + " seconds.");
    }

    /**
     * Selenium 判断元素是否存在
     */

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Selenium 拖拽方法
     *
     * @param from
     * @param to
     */

    public void dragAndDrop(WebElement from, WebElement to) {

        SeleniumUtil.log(log,"进行拖拽");
        (new Actions(driver)).dragAndDrop(from, to).perform();
    }

    /**
     * 移动鼠标到
     *
     * @param to
     */


    public void moveTo(WebElement to) {

        SeleniumUtil.log(log,"鼠标移动到");
        (new Actions(driver)).moveToElement(to).perform();
    }

    /**
     * 左键双击操作
     *
     * @param element
     */

    public void doubleClick(WebElement element) {
        SeleniumUtil.log(log,"左键双击");
        (new Actions(driver)).doubleClick(element).perform();
    }

    public void clickAction(WebElement element) {
        SeleniumUtil.log(log,"Action - 左键单击");
        (new Actions(driver)).click(element).perform();
    }

    /**
     * 获取窗口标题
     *
     * @return
     */

    public String getTitle() {
        String title = driver.getTitle();
        SeleniumUtil.log(log,"当前窗口title是： " + title);
        return title;
    }

    /**
     * 获取当前URL
     *
     * @return
     */

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        SeleniumUtil.log(log,"当前URL是： " + url);
        return url;
    }

    /**
     * 检查定损单在数据库中状态是否符合期望
     *
     * @param sql
     * @param expectedClaimStatus
     * @return true/false
     */

    public Boolean checkClaimStatus(String sql, String expectedClaimStatus) {
        int maxRetryTime = 10;
        Boolean b = false;
        Map<String, Object> sql_result;


        SeleniumUtil.log(log,sql);
        SeleniumUtil.log(log,"期望定损单的状态码为：" + expectedClaimStatus);
        outer:
        for (int i = 1; i <= maxRetryTime; i++) {

            SeleniumUtil.log(log,"第" + i + "次查询数据库");
            sql_result = getSingleResultSet(sql);

            if (!(sql_result == null || sql_result.size() == 0)) {
                Iterator<Map.Entry<String, Object>> it = sql_result.entrySet().iterator();
                Map.Entry<String, Object> e = it.next();
                SeleniumUtil.log(log,"定损单状态码：" + e.getValue());

                if (e.getValue().equals(expectedClaimStatus)) {
                    b = true;
                    this.sleep();
                    break outer;
                }
            }

            this.sleep();
        }
        return b;
    }

    /**
     * 检查搜索的配件别名在数据库中对应的标准件是否符合期望
     *
     * @param sql
     * @param partName
     * @return true/false
     */

    public Boolean checkText(String partName, String sql) {
        int maxRetryTime = 10;
        Boolean b = false;
        Map<String, Object> sql_result;


        SeleniumUtil.log(log,sql);
        SeleniumUtil.log(log,"当前文本内容为：" + partName);
        outer:
        for (int i = 1; i <= maxRetryTime; i++) {

            SeleniumUtil.log(log,"第" + i + "次查询数据库");
            sql_result = getSingleResultSet(sql);

            if (!(sql_result == null || sql_result.size() == 0)) {
                Iterator<Map.Entry<String, Object>> it = sql_result.entrySet().iterator();
                Map.Entry<String, Object> e = it.next();
                SeleniumUtil.log(log,"期望文本内容为：" + e.getValue());

                if (partName.equals(e.getValue())) {
                    b = true;
                    this.sleep();
                    break outer;
                }
            }

            this.sleep();
        }
        return b;
    }

    /**
     * 数据库执行sql  查询单个
     *
     * @param sql
     * @return
     */
    public String getSingleResult(String sql) {
        String result = null;
        Map<String, Object> sql_result;
        sql_result = getSingleResultSet(sql);
        SeleniumUtil.log(log,sql);
        if (!(sql_result == null || sql_result.size() == 0)) {
            Iterator<Map.Entry<String, Object>> it = sql_result.entrySet().iterator();
            Map.Entry<String, Object> e = it.next();
            SeleniumUtil.log(log,"查询结果为：" + e.getValue());
            result = e.getValue().toString();
        }
        return result;
    }

    /**
     * 数据库执行sql  修改某表某字段的值
     *
     * @param sql
     * @return
     */
    public void updateResult(String sql) {
        SeleniumUtil.log(log,sql);
        if (!(sql == null || sql.length() == 0)) {
            updateSQL(sql);
        }
    }

    /**
     * 数据库执行sql
     *
     * @param sql
     * @return
     */

    public Request checkBD(String sql) {

        Request result = DBUtil.getSelectResult(sql);
        return result;

    }

    /**
     * 数据库执行sql
     * 基于dbcp2的配置
     *
     * @param dbName
     * @param sql
     * @return
     */

    public Request checkBD(String dbName, String sql) {

        Request result = DBUtil.getSelectResult(dbName, sql);
        return result;

    }

    /**
     * 判断是否有弹框出现
     *
     * @return
     */

    public boolean isAlertPresent() {

        try {
            driver.switchTo().alert();
            return true;

        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    /**
     * 关闭所有的弹框
     */

    public void closeAllAlerts() {


        while (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            String s = alert.getText();
            SeleniumUtil.log(log,"弹出框信息：" + s);

            alert.accept();
            longSleep();

        }

    }

    /**
     * 返回当前的窗口数量
     *
     * @return
     */

    public int windowNum() {
        Set<String> handles = driver.getWindowHandles();
        return handles.size();
    }

    /**
     * 多次点击操作（最多10次）
     *
     * @param element
     */

    public void clickRetry(WebElement element) {

        int i = 1;
        while (i <= 10 && windowNum() == 1) {
            SeleniumUtil.log(log,"第" + i + "次点击按钮");
            element.click();
            i++;
        }

    }

    public boolean isElementExist(String xpath){

        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        int i = driver.findElements(By.xpath(xpath)).size();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        return i==0?false:true;
    }

    /**
     * 获取某个element的属性值
     *
     * @param element
     * @param attribute
     * @return
     */

    public String getElementAttribute(WebElement element, String attribute) {

        String attributeValue = element.getAttribute(attribute);
        return attributeValue;

    }

    /**
     * IE----select下拉框选择，
     * 根据option
     */
    public void selectOption(WebElement webElement, String option) {

        Select select = new Select(webElement);

        SeleniumUtil.log(log,"选择：" + option);
        select.selectByValue(option);

    }

    /**
     * IE----select下拉框选择，
     * 根据index
     */
    public void selectOption(WebElement webElement, int index) {

        Select select = new Select(webElement);


        SeleniumUtil.log(log,"选择：" + index);
        select.selectByIndex(index);

    }

    public void keepOneWindow() {

        if (windowNum() > 1) {
            Set<String> allWindowHandles = driver.getWindowHandles();
            String curWindowHandle = driver.getWindowHandle();

            for (String s : allWindowHandles) {
                if (s.equals(curWindowHandle)) {
                    continue;
                } else {
                    driver.switchTo().window(s);
                    driver.close();
                }
            }

            driver.switchTo().window(curWindowHandle);

        }
    }


    public static void log(Logger log,String msg){
        log.info(msg);
        step(msg);
    }

    /**
     *
     *
     * @param second 等待的最长 秒数
     * @param xpath 要操作的元素xpath
     * @param action 要操作的元素的 动作
     */
    public void sleep(int second,String xpath,int action) {
        int count=0;
        while(count<second){
            if(this.isElementExist(xpath)){
                if(action==0){
                    break;
                }
                if(action==1){
                    driver.findElement(By.xpath(xpath)).click();
                    break;
                }
            }
            count++;
        }
    }

    /**
     *
     * @param xpath 要操作的元素xpath
     */
    public void sleep(String xpath){
        while (this.isElementExist(xpath)){
            this.sleep();
        }
    }

}
