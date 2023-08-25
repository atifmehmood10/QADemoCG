package stepDefinitions.bookStoreSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static demoQA.pages.MyPages.*;

public class BookStoreNavigation_Steps {

    @Given("User is on the login screen")
    public void user_is_on_login_screen() {
        demoQAHomePage.openHomePage();
        demoQAHomePage.navigateToBookStoreApp();
        homePage.navigateToLoginScreen();
    }

    @When("User provides {} and {} as credentials and hit login button")
    public void user_provides_credentials_and_logs_in(String username, String password){
        loginPage.enterLoginCredentials(username,password);
        loginPage.clickLoginButton();
    }

    @Then("Login error is shown to user due to incorrect credentials")
    public void loginErrorIsShownToUser() {
        String errorMessage = loginPage.getErrorOnIncorrectCredentials();
        Assert.assertEquals(errorMessage, "Invalid username or password!");
    }

    @When("User provides no credentials")
    public void userProvidesNoCredentials() {
        loginPage.clickLoginButton();
    }

    @Then("Required fields are marked red")
    public void requiredFieldsAreMarkedRed() {
        boolean errorMessageStatus = loginPage.getErrorOnEmptyFields();
        Assert.assertTrue(errorMessageStatus);
    }

    @When("User navigates to Books Page")
    public void navigateToBooksPage(){
        homePage.navigateToBookStore();
    }

    @Then("User can view different books")
    public void userCanViewDifferentBooks() {
        int availableBooks = bookStorePage.getAllAvailableBooks();
        Assert.assertEquals(availableBooks, 8);
    }

    @When("User search for book with title {}")
    public void userSearchForBookWithTitle(String bookTitle) {
        bookStorePage.searchBookWithTitle(bookTitle);
    }

    @Then("User verifies only given book is searched")
    public void userVerifiesOnlyGivenBookIsSearched() {
        int searchedBook = bookStorePage.getAllAvailableBooks();
        Assert.assertEquals(searchedBook, 1);
    }

    @Then("User opens the searched book")
    public void userOpensTheSearchedBook() {
        bookStorePage.openSearchedBook();
    }

    @Then("User logs out of application")
    public void userLogsOut(){
        userHomePage.logOut();
    }

    @Then("User navigates to User Profile")
    public void userNavigatesToUserProfile() {
        homePage.navigateToProfileScreen();
    }
}
