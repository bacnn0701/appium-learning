package api_learning.lesson_17;

import context.IContext;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import platform.Platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandleHybridContext {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try {
            //Click Login Screen
            MobileElement navLoginScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Webview"));
            navLoginScreenBtnElem.click();

            //Get list context
            List<String> contextList = new ArrayList<>(appiumDriver.getContextHandles());

            for (String context : contextList) {
                System.out.println(context);
            }

            //Switch to webview
            appiumDriver.context(IContext.WEBDRIVER_IO);

            MobileElement navToggleElem = appiumDriver.findElement(By.xpath("//*[contains(@class,'navbar__toggle')]"));
            navToggleElem.click();

            // Get menu list
            List<MobileElement> menuList = appiumDriver.findElements(By.xpath("//*[@class='menu__list']//a"));
            Map<String,String> menuListContent = new HashMap<>();

            if (menuList.isEmpty())
                throw new RuntimeException("[ERR] There is no items in list!!!");

            for (MobileElement menuItem : menuList) {

                if (menuItem.getText().isEmpty()) {
                    continue;
                }
                else {
                    menuListContent.put(menuItem.getText(), menuItem.getAttribute("href"));
                }
            }

            for (String menuText : menuListContent.keySet()) {
                System.out.println("Menu Name: "+menuText);
                System.out.println("Link: "+menuListContent.get(menuText));
            }

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();

    }

}
