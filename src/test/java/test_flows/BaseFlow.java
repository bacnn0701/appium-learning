package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreen;
import org.openqa.selenium.By;

public class BaseFlow {

    protected AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickToLoginScreen() {
        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        loginScreen.bottomNavComp().clickOnLoginIcon();
    }
}
