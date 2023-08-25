package stepDefinitions.bookStoreSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static demoQA.pages.MyPages.userProfilePage;

public class UserProfilePage_Steps {

    @Then("User can verify {} book is present in collection")
    public void user_verifies_newly_added_book(String bookTitle){
        userProfilePage.searchBookWithTitle(bookTitle);
        boolean isBookPresent = userProfilePage.getBookInUserCollectionByBookTitle(bookTitle);
        Assert.assertTrue(isBookPresent);
    }

    @When("User press delete button")
    public void userPressDeleteButton() {

        userProfilePage.deleteSelectedBook();

    }

    @Then("{} is removed from collection")
    public void gitPocketGuideIsRemovedFromCollection(String bookTitle) {
        boolean isBookFound = userProfilePage.getBookInUserCollectionByBookTitle(bookTitle);
        Assert.assertFalse(isBookFound);
    }

}
