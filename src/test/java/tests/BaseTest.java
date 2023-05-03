package tests;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import platform.Platform;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BaseTest {

    private static final List<DriverFactory> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    private String udid;
    private String systemPort;
    protected AppiumDriver<MobileElement> getDriver() {
        return driverThread.get().getDriver(Platform.ANDROID,udid,systemPort);
    }
    @BeforeTest
    @Parameters({"udid","systemPort"})
    public void initDriver(String udid, String systemPort){
        this.udid = udid;
        this.systemPort = systemPort;
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory driverThread = new DriverFactory();
            driverThreadPool.add(driverThread);
            return driverThread;
        });
    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driverThread.get().quitDriver();
    }

    @AfterMethod(description = "Capture screenshot if test is failed")
    public void tearDown(ITestResult iTestResult) {

        if (!iTestResult.isSuccess()) {
            //Get method name
            String testMethodName = iTestResult.getName();

            //Get current time
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            Date currentDate = new Date(System.currentTimeMillis());
            String formattedTime = formatter.format(currentDate);

            //File location
            File screenshotBase64Data = getDriver().getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + testMethodName + "-" + formattedTime + ".png";

            // save screenshot and attachment
            try {
                FileUtils.copyFile(screenshotBase64Data, new File(fileLocation));
                Path screenshotContentPath = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(screenshotContentPath);
                Allure.addAttachment(testMethodName,inputStream);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
