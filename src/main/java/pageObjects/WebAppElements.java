package pageObjects;

import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.FetchElement;

/*
 *1/4/2024 created by Sadesh Manaranju
 */
public interface WebAppElements {

    String email = "m_login_email";
    String password = "m_login_password";
    String loginBtn = "//button[@name='login']";
    String errorMsg = "//div[@class='_52je']";


    static WebElement email() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.id, email);
    }

    static WebElement password() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.id, password);
    }

    static WebElement loginBtn() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.xPath, loginBtn);
    }

    static WebElement errorMsg() {
        return FetchElement.getWebElementFromAppiumDriver(Constants.xPath, errorMsg);
    }
}
