package demoQA.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static demoQA.DemoQABasePage.getWebDriver;

public class WaitUtils {

    public static WebElement waitForWebElementToBePresent(By elemLocator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOutInSeconds));
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(elemLocator));
            } catch (Exception e) {
            return null;
        }

    }

    public static void waitForSeconds(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e){

        }
    }
}
