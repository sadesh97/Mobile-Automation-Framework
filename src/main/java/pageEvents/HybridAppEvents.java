package pageEvents;

import base.DriverBase;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.HybridAppElements;

import java.net.URL;
import java.util.Set;

/*
 *1/4/2024 created by Sadesh Maheeshakya
 */
public class HybridAppEvents extends DriverBase {

    public static void openHybridApp(String appPackageName, String appActivityName) {

        try {
            setUp();

            capabilities.setCapability("appPackage", appPackageName);
            capabilities.setCapability("appActivity", appActivityName);
            URL url = new URL("http://127.0.0.1:4723/");
            androidDriver = new AndroidDriver(url, capabilities); //used androidDriver for context change (native/ WEB)

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void clickWebViewBtn() {
        HybridAppElements.webViewBtn().click();
    }

    public static void switchAppToWebViewContext() {
        //get context handles
        Set<String> handles = androidDriver.getContextHandles();
        //set context handles for WebView hybrid
        androidDriver.context((String) handles.toArray()[1]);
    }

    public static void clickMenuBtn() {
        HybridAppElements.menuBtn().click();
    }

    public static void clickThemeChangerBtn() {
        HybridAppElements.themeChangerBtn().click();
    }

    public static void clickCloseSign() {
        HybridAppElements.closeSign().click();
    }

    public static void clickLoginBtn() {
        HybridAppElements.loginBtn().click();
    }

    public static void switchAppToNativeContext() {
        androidDriver.context("NATIVE_APP");
    }

    public static Boolean isLoginSectionAppears() {
        return HybridAppElements.loginSection().isDisplayed();
    }


}
