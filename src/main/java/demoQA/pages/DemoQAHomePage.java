package demoQA.pages;

import demoQA.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static demoQA.utils.WaitUtils.waitForWebElementToBePresent;

public class DemoQAHomePage extends MyPages {

    @FindBy(xpath = "//header/a")
    private WebElement headerLink;

    @FindBy(css = "div.home-body > div > div:nth-child(6) > div")
    private WebElement bookStoreApplication;

    @FindBy(xpath = "//h5[contains(text(), 'Alerts, Frame & Windows')]")
    private WebElement alertsFramesWindows;


    private WebDriver webDriver;

    public DemoQAHomePage(WebDriver webdriver){ // write a generic function to init all
        this.webDriver = webdriver;
        PageFactory.initElements(webdriver, this);
    }

    public void openHomePage(){
        String url = StringUtils.getDemoQABaseURL();
        getWebDriver().get(url);
    }

    public void navigateToBookStoreApp(){
        bookStoreApplication.click();

        By loginButtonLocator = By.cssSelector("#app > div > div > div.pattern-backgound.playgound-header > div");
        waitForWebElementToBePresent(loginButtonLocator, 5);
    }

    public void navigateToAlertsFramesWindows() {
        alertsFramesWindows.click();
    }
}
