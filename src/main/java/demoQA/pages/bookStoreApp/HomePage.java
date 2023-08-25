package demoQA.pages.bookStoreApp;

import demoQA.pages.MyPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static demoQA.utils.GestureUtils.scrollTillElementFound;
import static demoQA.utils.WaitUtils.waitForSeconds;

public class HomePage extends MyPages {

    // Menu Navigation
    @FindBy(id = "login")
    private WebElement loginMenuButton;

    @FindBy(xpath = "//span[contains(text(),'Book Store')]")
    private WebElement bookStoreMenuButton;

    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    private WebElement profileMenuButton;

    private WebDriver webDriver;

    public HomePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void navigateToLoginScreen(){
        loginMenuButton.click();
    }

    public void navigateToBookStore(){
        scrollTillElementFound(bookStoreMenuButton);
        bookStoreMenuButton.click();
    }

    public void navigateToProfileScreen(){
        scrollTillElementFound(profileMenuButton);
        profileMenuButton.click();
    }

}
