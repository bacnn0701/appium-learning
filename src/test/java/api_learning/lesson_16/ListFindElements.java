package api_learning.lesson_16;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.List;

public class ListFindElements {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Click Login Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            //Fill data & login
            List<MobileElement> credInputElem = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));

            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            credInputElem.get(USERNAME_INDEX).sendKeys("teo@sth.com");
            credInputElem.get(PASSWORD_INDEX).sendKeys("12345678");

            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginBtnElem.click();

            //Print text
            WebDriverWait wait = new WebDriverWait(appiumDriver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            MobileElement loginDialogTitleElem = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println(loginDialogTitleElem.getText());

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
