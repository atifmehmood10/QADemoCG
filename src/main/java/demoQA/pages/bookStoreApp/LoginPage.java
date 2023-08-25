package demoQA.pages.bookStoreApp;

import demoQA.pages.MyPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static demoQA.utils.WaitUtils.waitForWebElementToBePresent;

public class LoginPage extends MyPages {

    @FindBy(id="userName")
    private WebElement userNameField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="login")
    private WebElement loginButton;

    private By loginErrorMessage = By.id("name");

    private WebDriver webDriver;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLoginCredentials(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public boolean getErrorOnEmptyFields(){
        boolean inputRequired = false;

        if(!userNameField.getAttribute("required").isEmpty() &&
           !passwordField.getAttribute("required").isEmpty()){
            inputRequired = true;
        }

        return inputRequired;
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getErrorOnIncorrectCredentials(){
        waitForWebElementToBePresent(loginErrorMessage,5);
        WebElement errorOnIncorrectCredentialsElem = getWebDriver().findElement(loginErrorMessage);
        return errorOnIncorrectCredentialsElem.getText();
    }

}
