package pageEvents;

import base.DriverBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.WebAppElements;

import java.net.URL;

/*
 *1/4/2024 created by Sadesh Manaranju
 */
public class WebAppEvents extends DriverBase {

    public static void openWebBrowser() {

        try {
            setUp();
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            URL url = new URL("http://127.0.0.1:4723/");
            appiumDriver = new AppiumDriver(url, capabilities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        appiumDriver.get("https://facebook.com");

        //Note: If your chrome not support with driver, start appium with this command below,
        //appium --allow-insecure chromedriver_autodownload

    }


    public static void enterEmail(String email) {
        WebAppElements.email().click();
        WebAppElements.email().sendKeys(email);

    }

    public static void enterPassword(String password) {
        WebAppElements.password().click();
        WebAppElements.password().sendKeys(password);

    }

    public static void clickLoginBtn() {
        WebAppElements.loginBtn().click();

    }

    public static String getErrorMsg() {
        return WebAppElements.errorMsg().getText();

    }


}
