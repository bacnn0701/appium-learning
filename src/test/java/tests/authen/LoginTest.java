package tests.authen;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import platform.Platform;
import test_data.DataObjectBuilder;
import test_data.models.LoginData;
import test_flows.BaseFlow;
import test_flows.authentication.LoginFlow;
import tests.BaseTest;

public class LoginTest extends BaseTest {
    @Description("Login Test with Data Driver")
    @Test(dataProvider = "loginData", description = "Login Test")
    public void loginTest(LoginData loginData) {

        System.out.println("Session ID: "+getDriver().getSessionId());
        LoginFlow loginFlow = new LoginFlow(getDriver(), loginData.getUsername(), loginData.getPassword());
        loginFlow.clickToLoginScreen();
        loginFlow.login();
        loginFlow.verification();

    }
    @DataProvider
    public LoginData[] loginData() {

        return DataObjectBuilder.buildDataObject("/src/test/java/test_data/data_file/AuthenData.json", LoginData[].class);
    }


}
