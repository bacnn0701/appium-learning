package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import platform.Platform;
import test_data.DataObjectBuilder;
import test_data.models.LoginData;
import test_flows.authentication.LoginFlow;

public class LoginTest {
    @Test(dataProvider = "loginData")
    public void loginTest(LoginData loginData) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            //Click Login Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtnElem.click();

            LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData.getUsername(), loginData.getPassword());
            loginFlow.login();
            loginFlow.verification();
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }
    @DataProvider
    public LoginData[] loginData() {

        return DataObjectBuilder.buildDataObject("/src/test/java/test_data/data_file/AuthenData.json", LoginData[].class);
    }


}
