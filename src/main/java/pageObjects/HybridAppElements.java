package pageObjects;

import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.FetchElement;

/*
 *1/4/2024 created by Sadesh Manaranju
 */
public interface HybridAppElements {
    //Hybrid App use Android driver

    String webViewBtn = "//android.widget.TextView[@text='Webview']";
    String menuBtn = "//button[@aria-label='Toggle navigation bar']//*[name()='svg']";
    String themeChangerBtn = "//button[@class='clean-btn toggleButton_gllP']/ancestor::div[@class='toggle_vylO margin-right--md']";
    String closeSign = "//button[@class='clean-btn navbar-sidebar__close']/*[name()='svg']";

    String loginBtn = "//android.widget.TextView[@text='Login']";
    //syntax //ClassName[@attribute]
    //WebElement loginSection = androidDriver.findElement(By.xpath("//android.widget.ScrollView[@content-desc='Login-screen']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]"));
    String loginSection = "//android.view.ViewGroup[@index='3']";


    static WebElement webViewBtn() {
        return FetchElement.getWebElementFromAndroidDriver(Constants.xPath, webViewBtn);
    }

    static WebElement menuBtn() {
        return FetchElement.getWebElementFromAndroidDriver(Constants.xPath, menuBtn);
    }

    static WebElement themeChangerBtn() {
        return FetchElement.getWebElementFromAndroidDriver(Constants.xPath, themeChangerBtn);
    }

    static WebElement closeSign() {
        return FetchElement.getWebElementFromAndroidDriver(Constants.xPath, closeSign);
    }

    static WebElement loginBtn() {
        return FetchElement.getWebElementFromAndroidDriver(Constants.xPath, loginBtn);
    }

    static WebElement loginSection() {
        return FetchElement.getWebElementFromAndroidDriver(Constants.xPath, loginSection);
    }


}
