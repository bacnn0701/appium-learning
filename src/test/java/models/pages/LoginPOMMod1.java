package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPOMMod1 {

    // Return element

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By inputEmailSel = MobileBy.AccessibilityId("input-email");
    private final static By passEmailSel = MobileBy.AccessibilityId("input-password");
    private final static By loginBtnSel = MobileBy.AccessibilityId("button-LOGIN");

    public LoginPOMMod1(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement inputEmailElem() {
        return appiumDriver.findElement(inputEmailSel);
    }

    public MobileElement passEmailElem() {
        return appiumDriver.findElement(passEmailSel);
    }

    public MobileElement loginBtnElem() {
        return appiumDriver.findElement(loginBtnSel);
    }
}
