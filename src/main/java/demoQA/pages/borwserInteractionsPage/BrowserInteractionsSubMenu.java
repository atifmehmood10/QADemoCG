package demoQA.pages.borwserInteractionsPage;

import demoQA.pages.MyPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserInteractionsSubMenu extends MyPages {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    private WebElement browserWindows;

    @FindBy(xpath = "//span[contains(text(),'Frames')]")
    private WebElement frames;

    private By pageInfoMessage = By.xpath("//div[contains(text(),'Please select an item from left to start practice.')]");

    public BrowserInteractionsSubMenu(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(getWebDriver(), this);
    }

    public void waitForWindowsAlertsFramesPageToLoad(){}


    public void navigateToWindowsPage(){
        waitForWindowsAlertsFramesPageToLoad();
        browserWindows.click();
    }

}
