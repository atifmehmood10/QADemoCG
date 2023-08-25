package stepDefinitions.bookStoreSteps;

import demoQA.constants.DemoQAConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static demoQA.pages.MyPages.*;

public class UserHomePage_Steps {

    @Given("User is already logged in")
    public void user_navigated_to_home_screen_and_logged_in(){
        demoQAHomePage.openHomePage();
        demoQAHomePage.navigateToBookStoreApp();
        homePage.navigateToLoginScreen();
        loginPage.enterLoginCredentials(DemoQAConstants.USERNAME, DemoQAConstants.PASSWORD);
        loginPage.clickLoginButton();
    }

    @Then("User is logged in to the system")
    public void user_is_logged_in(){
        boolean isLoggedIn =  userHomePage.getLoggedInUserName();
        Assert.assertTrue(isLoggedIn);
    }

}
