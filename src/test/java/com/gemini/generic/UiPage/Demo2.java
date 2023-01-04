package com.gemini.generic.UiPage;

import com.gemini.generic.MobileAction;
import com.gemini.generic.MobileDriverManager;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import net.serenitybdd.core.pages.PageObject;

import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Demo2 extends PageObject
{

//    @Managed(driver = "appium")
//        WebDriver driver;

    public static AppiumDriver driver = null;
    public static String username ="tusharmahajan_jMg0u2";
    public static String accessKey = "MBZ7BsjPqomq6hoUdEkG";


    public void app() throws InterruptedException, MalformedURLException {
//        Thread.sleep(2000);
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("deviceName", "Pixel12");
//        cap.setCapability("udid", "emulator-5554");
//        cap.setCapability("platformName", "Android");
//        cap.setCapability("app","C:\\projects\\MobileAutomationSeries\\app\\ApiDemos.apk");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
         System.out.println("Launched application");
         driver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();


    }

    public void clickOnOption() throws InterruptedException
    {
        Thread.sleep(2000);
        try {
            driver.findElement(Locators.pref).click();
        }
        catch (Exception e)
        {
            System.out.println("exception");
        }
    }


    public void clickOnPreferenceDependencies()
    {
    driver.findElement(Locators.prefDependencies).click();
    }

    public void clickWifi()
{
    clickOn(driver.findElement(Locators.wifiCheckBox));
}
    public void wifiSettingss()
    {
    waitABit(2000);
    WebElement ele=driver.findElement(Locators.wifiSettings);
    ele.click();
    typeInto(driver.findElement(Locators.wifiTextBox),"Tushar");
    }

    public void clickView() throws InterruptedException {
    Thread.sleep(2000);
    clickOn(driver.findElement(Locators.views));
    }
    public void clickexpandable()
    {
        driver.findElement(Locators.expandableLists).click();
    }

public void customAdaptorss()

{
    driver.findElement(Locators.customAdaptor).click();
}

public void people(){
    LongPressOptions lpress=new LongPressOptions();
    lpress.withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(driver.findElement(Locators.peopleName)));
    TouchAction ta=new TouchAction((PerformsTouchActions) driver);
    ta.longPress(lpress).release().perform();
    }
    public void alert() throws InterruptedException {
    clickOn(driver.findElement(Locators.app_option));
    clickOn(driver.findElement(Locators.alert_dialogs));
    clickOn(driver.findElement(Locators.okCancel_alert));
    Thread.sleep(2000);
    clickOn(driver.findElement(Locators.cancel));
    }


    public void clickGallery() throws InterruptedException {
        Thread.sleep(2000);
        clickOn(driver.findElement(Locators.gallery));
    }

    public void clickPhotos() throws InterruptedException {
        Thread.sleep(2000);
        clickOn(driver.findElement(Locators.photos));
    }

    public void swipe() throws InterruptedException {
        Thread.sleep(3000);
        WebElement img = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        try {
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) img).getId(),
                    "direction", "left",
                    "percent", "0.75"));
    }
        catch (Exception e)
        {
            System.out.println("Error");
            Assert.assertFalse("Its throwing error",false);
        }
    }



    public void dropDown() throws InterruptedException{

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popup Menu\"));"));

        clickOn(driver.findElement(Locators.popMenu));

        clickOn(driver.findElement(Locators.makePop));
        Thread.sleep(2000);

        List<WebElement> dropDown = driver.findElements(AppiumBy.xpath("//android.widget.LinearLayout//android.widget.TextView"));
        for(WebElement ele: dropDown){
            System.out.println(ele.getText());
            if(ele.getText().equals("Search")) {
                ele.click();
                Thread.sleep(2000);
                break;
            }
        }

    }

    public void scrollfunc() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        Thread.sleep(2000);
    }

public void toastMessage() throws InterruptedException {

    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popup Menu\"));"));

    clickOn(driver.findElement(Locators.popMenu));

    clickOn(driver.findElement(Locators.makePop));

    clickOn(driver.findElement(Locators.search));

    waitABit(1000);

    String str=driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("text");

    System.out.println("toast msg "+ str);


try {
    Assert.assertEquals(str,"Clicked popup menu item Search");
}
    catch (Exception e)
    {
        System.out.println("error");
    }
}
    public void dragDropsbtn() throws InterruptedException
    {
    clickOn(driver.findElement(Locators.dragAndDrop));
    }

public void drop()
{

    ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
        "elementId", ((RemoteWebElement) driver.findElement(Locators.src)).getId(),
            "endX", 818,
            "endY", 729
    ));

 waitABit(2000);

    String msg=driver.findElement(Locators.drop).getText();
    System.out.println(msg);
    try {
        Assert.assertEquals(msg, "Dropped!");
    }
    catch (Exception e)
    {
        System.out.println("error");
    }
}


    public void login() {
        MobileAction.waitSec(5);
        MobileAction.typeText(Locators.name, "ABC", "Enter Username");
        MobileAction.waitSec(1);
        MobileAction.click(Locators.countryDropdown, "open country select dropdown");
        MobileAction.waitSec(1);
        MobileAction.click(Locators.countrySelect, "Select Angola");
        MobileAction.waitSec(1);
        MobileAction.click(Locators.male, "Select gender Male");
        MobileAction.click(Locators.btnLogin, "Click Submit");
    }


    public void openJordanRetro()
    {
            waitABit(2000);
            MobileAction.click(Locators.airJordan,"ADD TO CART");
    }
    public void Add_item_to_cart()
    {
        MobileAction.waitSec(2);
        MobileAction.click(Locators.btnCart);
        MobileAction.waitSec(2);
    }


    public void checkLoco()
    {
        MobileAction.click(Locators.checkBox);
    }
    public void websites()
    {
    MobileAction.click(Locators.website);
    }
    public void loginSerenity()
    {
        typeInto(MobileAction.getElement(Locators.name),"ABC");
        waitABit(2000);
        clickOn(MobileAction.getElement(Locators.btnLogin));
    }
    public void openJordenShoes()
    {
        clickOn(MobileAction.getElement(Locators.airJordan));
        waitABit(2000);
       clickOn(MobileAction.getElement(Locators.btnCart));
       waitABit(2000);
    }


    public void checkAndSubmit()
    {
        clickOn(MobileAction.getElement(Locators.checkBox));
        clickOn(MobileAction.getElement(Locators.website));
    }

    public void visit() {

//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("chromedriverExecutable","C:\\projects\\MobileAutomationSeries\\driver\\chromedriver.exe");
        MobileAction.waitSec(2);
        MobileAction.click(Locators.websiteName);

        ((AndroidDriver) MobileDriverManager.getAppiumDriver()).context("WEBVIEW_com.androidsample.generalstore");

        MobileAction.typeText(Locators.googleSearch, "GeminiSolutions");

        MobileDriverManager.getAppiumDriver().findElement(Locators.googleSearch).sendKeys(Keys.ENTER);

        MobileAction.waitSec(2);
        MobileAction.click(Locators.link);
        MobileAction.navigateBack(false);
        MobileAction.waitSec(2);
        MobileAction.navigateForward(false);
        MobileAction.waitSec(2);

        MobileAction.navigateToUrl("https://www.youtube.com/", false);

        MobileAction.refresh(false);
        MobileAction.waitSec(2);
    }
}