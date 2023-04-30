package api_learning.lesson_18;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginPOMMod3;
import platform.Platform;

public class LoginWithPOMMod3 {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Click Login Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            //Fill data & login
            LoginPOMMod3 loginPOMMod3 = new LoginPOMMod3(appiumDriver);
            loginPOMMod3.inputEmail("teo@sth.com").inputPassword("12345678").clickOnLogin();

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();


    }
}
