package tests;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;
import platform.Platform;

import java.sql.Driver;

public class BaseTest {

    protected AppiumDriver<MobileElement> appiumDriver;
    @BeforeTest
    public void initDriver(){
        appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {
        appiumDriver.quit();
    }
}
