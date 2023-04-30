package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottomNavComp {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By loginItemSel = MobileBy.AccessibilityId("Login");

    public BottomNavComp(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnLoginIcon() {
        appiumDriver.findElement(loginItemSel).click();
    }
}
