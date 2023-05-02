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
import test_flows.BaseFlow;
import test_flows.authentication.LoginFlow;
import tests.BaseTest;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginData")
    public void loginTest(LoginData loginData) {

        LoginFlow loginFlow = new LoginFlow(appiumDriver, loginData.getUsername(), loginData.getPassword());
        loginFlow.clickToLoginScreen();
        loginFlow.login();
        loginFlow.verification();

    }

    @DataProvider
    public LoginData[] loginData() {

        return DataObjectBuilder.buildDataObject("/src/test/java/test_data/data_file/AuthenData.json", LoginData[].class);
    }


}
