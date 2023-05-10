package api_learning.lesson_16;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import platform.Platform;

import java.time.Duration;

public class SwipeVertically {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            //Navigate to Form Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navLoginScreenBtnElem.click();

            //Get window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int height = windowSize.getHeight();
            int width = windowSize.getWidth();

            //Declare start point & end point
            int xStartPoint = 50*width/100;
            int xEndPoint = 50*width/100;

            int yStartPoint = 50*height/100;
            int yEndPoint = 10*height/100;

            //Declare Coordinate
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint,yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint,yEndPoint);

            //Touch to point
            TouchAction touchAction = new TouchAction<>(appiumDriver);
            touchAction
                    .press(startPoint)
                    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                    .moveTo(endPoint)
                    .release().perform();

            // Click Active button
            MobileElement activeBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtnElem.click();

            MobileElement dialogMsgElem = appiumDriver.findElement(MobileBy.id("android:id/message"));
            System.out.println(dialogMsgElem.getText());


            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

}
