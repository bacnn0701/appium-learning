package models.components.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComp {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By inputEmailSel = MobileBy.AccessibilityId("input-email");
    private final static By incorrectEmailTextSel = MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private final static By passEmailSel = MobileBy.AccessibilityId("input-password");
    private final static By incorrectPassTextSel = MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    private final static By successCredsTextSel = MobileBy.xpath("//*[contains(@text,'Success')]");
    public LoginFormComp(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public void inputEmail(String email) {
        if (!email.isEmpty()) appiumDriver.findElement(inputEmailSel).sendKeys(email);
    }
    public String getIncorrectEmailText() {
        return appiumDriver.findElement(incorrectEmailTextSel).getText();
    }
    public void inputPassword(String pass) {
        if (!pass.isEmpty()) appiumDriver.findElement(passEmailSel).sendKeys(pass);
    }
    public String getIncorrectPassText() {
        return appiumDriver.findElement(incorrectPassTextSel).getText();
    }
    public void clickOnLogin() {
        appiumDriver.findElement(loginBtnSel).click();
    }

    public String getSuccessLoginText() {
        return appiumDriver.findElement(successCredsTextSel).getText();
    }


}
