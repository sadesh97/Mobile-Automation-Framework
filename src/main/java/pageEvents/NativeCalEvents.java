package pageEvents;

import base.DriverBase;
import io.appium.java_client.AppiumDriver;
import pageObjects.NativeCalElements;

import java.net.URL;

/*
 *1/4/2024 created by Sadesh Manaranju
 */
public class NativeCalEvents extends DriverBase {

    public static void openNativeCalculatorApp(String appPackageName, String appActivityName) {

        try {
            setUp();

//            capabilities.setCapability("appPackage", "com.miui.calculator");
//            capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
            capabilities.setCapability("appPackage", appPackageName);
            capabilities.setCapability("appActivity", appActivityName);
            URL url = new URL("http://127.0.0.1:4723/");
            appiumDriver = new AppiumDriver(url, capabilities);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static void chooseFrameLayout() {
        NativeCalElements.frameLayout().click();
    }

    public static void clickNumberSeven() {
        NativeCalElements.seven().click();
    }

    public static void clickNumberTwo() {
        NativeCalElements.two().click();
    }

    public static void clickNumberOne() {
        NativeCalElements.one().click();
    }

    public static void clickPlusSign() {
        NativeCalElements.plusSign().click();
    }

    public static void clickEqualSign() {
        NativeCalElements.equalSign().click();
    }

    public static String answerFieldValue() {
        return NativeCalElements.answerTextField().getText();
    }


}
