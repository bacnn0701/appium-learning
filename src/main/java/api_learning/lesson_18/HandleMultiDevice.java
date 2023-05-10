package api_learning.lesson_18;

import driver.DriverFactory;
import driver.IAppPackage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import platform.Platform;

import java.time.Duration;

public class HandleMultiDevice {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {

            // Open app to login
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            //Fill data & login
            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passInputElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailInputElem.sendKeys("teo@sth.com");
            passInputElem.sendKeys("12345678");
            loginBtnElem.click();

            //Put app to in background
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            // Open Setting
            appiumDriver.activateApp(IAppPackage.SETTING);

            MobileElement connectionsElem = appiumDriver.findElement(MobileBy.xpath("//*[@text='Connections']"));
            connectionsElem.click();

            MobileElement wifiToggleElem = appiumDriver.findElement(MobileBy.AccessibilityId("Wi-Fi"));
            wifiToggleElem.click();

            //Come back webdriverIO app
            appiumDriver.activateApp(IAppPackage.WEBDRIVER_IO);

            MobileElement okBtnElem = appiumDriver.findElement(MobileBy.xpath("//*[@text='OK']"));
            okBtnElem.click();

            //PURPOSE DEBUG
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
