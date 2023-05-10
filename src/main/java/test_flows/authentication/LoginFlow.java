package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.login.LoginFormComp;
import models.pages.LoginScreen;
import org.apache.commons.validator.routines.EmailValidator;
import org.testng.Assert;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private String username;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String username, String password) {
        super(appiumDriver);
        this.username = username;
        this.password = password;
    }

    public void login() {

        LoginScreen loginScreen = new LoginScreen(appiumDriver);
        LoginFormComp loginFormComp = loginScreen.loginFormComp();

        if (username != null && !username.isEmpty()) loginFormComp.inputEmail(username);
        if (password != null && !password.isEmpty()) loginFormComp.inputPassword(password);
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
            Assert.assertEquals(loginFormComp.getIncorrectEmailText(),"Please enter a valid email");
        }

        if (!isPassValid) {
            Assert.assertEquals(loginFormComp.getIncorrectPassText(),"Please enter at least 8 characters");
        }
    }
}
