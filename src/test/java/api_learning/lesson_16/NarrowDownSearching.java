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
import java.util.HashMap;
import java.util.List;

public class NarrowDownSearching {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {

            //Get window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int height = windowSize.getHeight();
            int width = windowSize.getWidth();

            //Declare start point & end point
            int xStartPoint = 50*width/100;
            int xEndPoint = 50*width/100;

            int yStartPoint = 0;
            int yEndPoint = 50*height/100;

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

            // Get notification info
            List<MobileElement> listNotification = appiumDriver.findElements(MobileBy.id("android:id/notification_main_column"));
            System.out.println(listNotification.size());
            HashMap<String, String> notificationContents = new HashMap<>();

            for (MobileElement notification : listNotification) {

                MobileElement titleElem = notification.findElement(MobileBy.id("android:id/title"));
                MobileElement textElem = notification.findElement(MobileBy.id("android:id/text"));
                notificationContents.put(titleElem.getText().trim(),textElem.getText().trim());

            }

            for (String title : notificationContents.keySet()) {
                System.out.println("Title: "+title);
                System.out.println("Content: "+notificationContents.get(title));
            }

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
}
