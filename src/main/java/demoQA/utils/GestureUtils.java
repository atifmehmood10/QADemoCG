package demoQA.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static demoQA.DemoQABasePage.getWebDriver;

public class GestureUtils {

    public static void scrollTillElementFound(WebElement elem){
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", elem);
    }

    public static void acceptAlertBox(){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
    }

}
