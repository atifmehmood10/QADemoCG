package demoQA.pages.bookStoreApp;

import demoQA.pages.MyPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static demoQA.utils.WaitUtils.waitForSeconds;
import static demoQA.utils.WaitUtils.waitForWebElementToBePresent;

public class UserHomePage extends MyPages {

    private By loggedInUserBy = By.id("userName-value");

    @FindBy(xpath = "//button[contains(text(),'Log out')]")
    private WebElement logOut;
    @FindBy(id="searchBox")
    private WebElement searchBox;

    private WebDriver webDriver;

    public UserHomePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean getLoggedInUserName(){
        waitForWebElementToBePresent(loggedInUserBy, 5);
        boolean isLoggedIn = false;
        WebElement loggedInUser = getWebDriver().findElement(loggedInUserBy);
        if(loggedInUser.isDisplayed()){
            isLoggedIn = true;
        }
        return isLoggedIn;
    }

    public void searchBookInUserCollection(String bookTitle){
        searchBox.sendKeys(bookTitle);
    }

    public void logOut() {
        waitForSeconds(2);
        logOut.click();
    }


}
