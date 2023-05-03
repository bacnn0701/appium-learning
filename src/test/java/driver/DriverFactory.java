package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import platform.Platform;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx {

    private AppiumDriver<MobileElement> appiumDriver;
    public static AppiumDriver<MobileElement> getDriver(Platform platform) {

        AppiumDriver<MobileElement> appiumDriver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(UDID,"R52MB09ENDT");
        desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
        desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
        URL appiumServer = null;

        try {
            appiumServer = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appiumServer == null) {
            throw new RuntimeException("Can't construct appium server url @");
        }

        switch (platform) {
            case ANDROID:
                appiumDriver = new AndroidDriver<>(appiumServer,desiredCapabilities);
                break;
            case IOS:
                appiumDriver = new IOSDriver<>(appiumServer,desiredCapabilities);
                break;
        }

        appiumDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return appiumDriver;
    }

    public AppiumDriver<MobileElement> getDriver(Platform platform, String udid, String systemPort) {

        if (appiumDriver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(UDID,udid);
            desiredCapabilities.setCapability(SYSTEM_PORT,systemPort);
            desiredCapabilities.setCapability(APP_PACKAGE,"com.wdiodemoapp");
            desiredCapabilities.setCapability(APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
            URL appiumServer = null;
            String url = "http://192.168.1.164:4444/wd/hub";
            try {
                appiumServer = new URL(url);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (appiumServer == null) {
                throw new RuntimeException("Can't construct appium server url @");
            }

            switch (platform) {
                case ANDROID:
                    appiumDriver = new AndroidDriver<>(appiumServer,desiredCapabilities);
                    break;
                case IOS:
                    appiumDriver = new IOSDriver<>(appiumServer,desiredCapabilities);
                    break;
            }

            appiumDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }

        return appiumDriver;
    }

    public void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
