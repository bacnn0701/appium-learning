package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComp;
import models.components.login.LoginFormComp;

public class LoginScreen {

    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComp loginFormComp() {
        return new LoginFormComp(appiumDriver);
    }
    public BottomNavComp bottomNavComp() {
        return new BottomNavComp(appiumDriver);
    }
}
