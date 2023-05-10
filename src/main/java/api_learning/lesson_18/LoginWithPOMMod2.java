package api_learning.lesson_18;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginPOMMod2;
import platform.Platform;

public class LoginWithPOMMod2 {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            //Click Login Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            //Fill data & login
            LoginPOMMod2 loginPOMMod2 = new LoginPOMMod2(appiumDriver);
            loginPOMMod2.inputEmail("teo@sth.com");
            loginPOMMod2.inputPassword("12345678");
            loginPOMMod2.clickOnLogin();

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();


    }
}
