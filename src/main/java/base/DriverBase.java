package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 *1/4/2024 created by Sadesh Manaranju
 */
public class DriverBase {

    public static AppiumDriver appiumDriver;
    public static AndroidDriver androidDriver;
    public static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static void setUp() {

        //start appium by below from CMD,
        //Note: If your chrome not support with driver, start appium with this command below,
        //appium --allow-insecure chromedriver_autodownload


        capabilities.setCapability("deviceName", "KASM");
        capabilities.setCapability("udid", "597loflnlf6tkfkv"); //get by using "adb devices" command
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11 RP1A.200720.011");
        capabilities.setCapability("automationName", "UiAutomator2");

    }

    public static void finishUp() {
        if (appiumDriver != null) appiumDriver.quit();
        if (androidDriver != null) androidDriver.quit();

    }


}
