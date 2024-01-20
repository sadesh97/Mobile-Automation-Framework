package pageObjects;

import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.FetchElement;

/*
 *1/4/2024 created by Sadesh Manaranju
 */
public interface NativeCalElements {

    String frameLayout = "/hierarchy/android.widget.FrameLayout";
    String seven = "com.miui.calculator:id/btn_7_s"; // 9ine = //android.widget.TextView[@resource-id='com.miui.calculator:id/btn_9_s']
    String one = "//android.widget.TextView[@index='3']"; //syntax //ClassName[@attribute]
    String plusSign = "com.miui.calculator:id/btn_plus_s";
    String two = "com.miui.calculator:id/btn_2_s";
    String equalSign = "com.miui.calculator:id/btn_equal_s";
    String answerTextField = "com.miui.calculator:id/result";

    static WebElement frameLayout() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.xPath, frameLayout);
    }

    static WebElement seven() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.id, seven);
    }

    static WebElement one() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.xPath, one);
    }

    static WebElement plusSign() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.id, plusSign);
    }

    static WebElement two() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.id, two);
    }

    static WebElement equalSign() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.id, equalSign);
    }

    static WebElement answerTextField() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.id, answerTextField);
    }

}
