package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.form.FormComp;
import models.components.global.BottomNavComp;

public class FormScreen {

    AppiumDriver<MobileElement> appiumDriver;

    public FormScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public FormComp formComp() {
        return new FormComp(appiumDriver);
    }

    public BottomNavComp bottomNavComp(){
        return new BottomNavComp(appiumDriver);
    }
}
