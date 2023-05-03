package test_flows.form_flow;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import test_flows.BaseFlow;

import java.time.Duration;

public class FormFlow extends BaseFlow {

    public FormFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void form() {

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
    }
}
