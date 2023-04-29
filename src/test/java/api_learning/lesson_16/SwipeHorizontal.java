package api_learning.lesson_16;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SwipeHorizontal {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Navigate to Form Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            navLoginScreenBtnElem.click();

            WebDriverWait wait = new WebDriverWait(appiumDriver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[contains(@text,'Swipe horizontal')]")));

            //Get window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int height = windowSize.getHeight();
            int width = windowSize.getWidth();

            //Declare start point & end point
            int xStartPoint = 50*width/100;
            int xEndPoint = 10*width/100;

            int yStartPoint = 70*height/100;
            int yEndPoint = 70*height/100;

            //Declare Coordinate
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint,yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint,yEndPoint);

            //Touch to point
            TouchAction touchAction = new TouchAction<>(appiumDriver);

            for (int time = 0; time < 5; time++) {
                touchAction
                        .press(startPoint)
                        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                        .moveTo(endPoint)
                        .release().perform();

            }

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

}
