package demoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static demoQA.pages.MyPages.initializeAllPages;
import static demoQA.utils.PropertiesUtils.properties;
import static demoQA.utils.StringUtils.getDemoQABaseURL;

public class DemoQABasePage {

    public static WebDriver driver;

    public static WebDriver getWebDriver(){
        return driver;
    }

    public static void startWebBrowser() {
        if (properties.getProperty("webBrowser").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            if (properties.getProperty("headless").equals("true")) {
                chromeOptions.addArguments("--headless");
            }

            driver= new ChromeDriver(chromeOptions);
        }
        String url = getDemoQABaseURL();
        initializeAllPages();
        getWebDriver().manage().window().maximize();
        getWebDriver().get(url);
    }

    public static void endWebBrowser(){
        if (getWebDriver() != null) getWebDriver().quit();
    }

}
