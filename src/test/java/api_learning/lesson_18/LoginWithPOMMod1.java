package api_learning.lesson_18;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginPOMMod1;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class LoginWithPOMMod1 {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Click Login Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            //Fill data & login
            LoginPOMMod1 loginPOMMod1 = new LoginPOMMod1(appiumDriver);
            loginPOMMod1.inputEmailElem().sendKeys("teo@sth.com");
            loginPOMMod1.passEmailElem().sendKeys("12345678");
            loginPOMMod1.loginBtnElem().click();

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();


    }
}
