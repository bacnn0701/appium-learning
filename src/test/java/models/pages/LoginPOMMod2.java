package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPOMMod2 {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By inputEmailSel = MobileBy.AccessibilityId("input-email");
    private final static By passEmailSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");
    public LoginPOMMod2(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public void inputEmail(String email) {
        if (!email.isEmpty()) appiumDriver.findElement(inputEmailSel).sendKeys(email);
    }
    public void inputPassword(String pass) {
        if (!pass.isEmpty()) appiumDriver.findElement(passEmailSel).sendKeys(pass);
    }
    public void clickOnLogin() {
        appiumDriver.findElement(loginBtnSel).click();
    }
}
