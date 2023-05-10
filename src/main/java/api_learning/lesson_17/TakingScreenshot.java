package api_learning.lesson_17;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.io.File;

public class TakingScreenshot {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            //Click Login Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            //Wait
            WebDriverWait wait = new WebDriverWait(appiumDriver,3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[contains(@text,'Login')]")));

            //Taking screenshot full screen
            File base64 = appiumDriver.getScreenshotAs(OutputType.FILE);
            File loginScreen = new File(System.getProperty("user.dir").concat("/screenshots").concat("/LoginFullScreen.png"));
            FileUtils.copyFile(base64,loginScreen);

            //Taking screenshot form login
            base64 = appiumDriver.findElement(MobileBy.AccessibilityId("Login-screen")).getScreenshotAs(OutputType.FILE);
            loginScreen = new File(System.getProperty("user.dir").concat("/screenshots").concat("/LoginForm.png"));
            FileUtils.copyFile(base64,loginScreen);

            //Taking login button
            base64 = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN")).getScreenshotAs(OutputType.FILE);
            loginScreen = new File(System.getProperty("user.dir").concat("/screenshots").concat("/LoginButton.png"));
            FileUtils.copyFile(base64,loginScreen);

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}
