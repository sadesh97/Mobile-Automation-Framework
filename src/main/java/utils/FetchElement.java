package utils;

import base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;


/*
 *1/4/2024 created by Sadesh Manaranju
 */
public class FetchElement extends DriverBase {

    public static WebElement getWebElementFromAppiumDriver(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> appiumDriver.findElement(By.xpath(identifierValue));
            case "CSS" -> appiumDriver.findElement(By.cssSelector(identifierValue));
            case "ID" -> appiumDriver.findElement(By.id(identifierValue));
            case "NAME" -> appiumDriver.findElement(By.name(identifierValue));
            case "CLASSNAME" -> appiumDriver.findElement(By.className(identifierValue));
            default -> null;
        };
    }

    public static List<WebElement> getWebElementsFromAppiumDriver(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> appiumDriver.findElements(By.xpath(identifierValue));
            case "CSS" -> appiumDriver.findElements(By.cssSelector(identifierValue));
            case "ID" -> appiumDriver.findElements(By.id(identifierValue));
            case "NAME" -> appiumDriver.findElements(By.name(identifierValue));
            case "CLASSNAME" -> appiumDriver.findElements(By.className(identifierValue));
            default -> null;
        };
    }


    public static WebElement getWebElementFromAndroidDriver(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> androidDriver.findElement(By.xpath(identifierValue));
            case "CSS" -> androidDriver.findElement(By.cssSelector(identifierValue));
            case "ID" -> androidDriver.findElement(By.id(identifierValue));
            case "NAME" -> androidDriver.findElement(By.name(identifierValue));
            case "CLASSNAME" -> androidDriver.findElement(By.className(identifierValue));
            default -> null;
        };
    }

    public static List<WebElement> getWebElementsFromAndroidDriver(String identifierType, String identifierValue) {
        return switch (identifierType) {
            case "XPATH" -> androidDriver.findElements(By.xpath(identifierValue));
            case "CSS" -> androidDriver.findElements(By.cssSelector(identifierValue));
            case "ID" -> androidDriver.findElements(By.id(identifierValue));
            case "NAME" -> androidDriver.findElements(By.name(identifierValue));
            case "CLASSNAME" -> androidDriver.findElements(By.className(identifierValue));
            default -> null;
        };
    }

    public static void addWait(String nativeOrHybrid, long time) {
        if (nativeOrHybrid.equals("Hybrid")) {
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        } else if (nativeOrHybrid.equals("Native")) {
            appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        }

    }


}
