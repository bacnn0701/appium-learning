package api_learning.lesson_18;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.LoginScreen;
import platform.Platform;

public class LoginWithComponent {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {

            LoginScreen loginScreen = new LoginScreen(appiumDriver);

            //Click Login Screen
            loginScreen.bottomNavComp().clickOnLoginIcon();

            //Fill data & login
            loginScreen.loginFormComp().inputEmail("teo@sth.com");
            loginScreen.loginFormComp().inputPassword("12345678");
            loginScreen.loginFormComp().clickOnLogin();

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}
