package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComp;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;

public class LoginFlow {

    AppiumDriver<MobileElement> appiumDriver;
    private String username;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        this.appiumDriver = appiumDriver;
        this.username = username;
        this.password = password;
    }

    public void login() {

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComp loginFormComp = loginScreen.loginFormComp();

        if (!username.isEmpty()) loginFormComp.inputEmail(username);
        if (!password.isEmpty()) loginFormComp.inputPassword(password);
        loginFormComp.clickOnLogin();
    }

    public void verification() {

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComp loginFormComp = loginScreen.loginFormComp();

        boolean isUsernameValid = EmailValidator.getInstance().isValid(username);
        boolean isPassValid = password.length() >= 8;

        if (isUsernameValid && isPassValid) {

            String act = loginFormComp.getSuccessLoginText();
            Assert.assertEquals(act,"Success");
        }

        if (!isUsernameValid) {
            Assert.assertEquals(loginFormComp.getIncorrectEmailText(),"Please enter a valid email address");
        }

        if (!isPassValid) {
            Assert.assertEquals(loginFormComp.getIncorrectPassText(),"Please enter at least 8 characters");
        }
    }
}
