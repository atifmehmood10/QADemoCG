package stepDefinitions.bookStoreSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static demoQA.pages.MyPages.bookDetailsPage;
import static demoQA.pages.MyPages.bookStorePage;

public class BookDetailsPage_Steps {


    @Then("User verifies book details from {} file")
    public void verify_book_details_from_json_file(String jsonFile){
        Assert.assertTrue(bookDetailsPage.compareBookDetailsToJsonFile(jsonFile));
    }

    @When("User add {} book to collection")
    public void add_book_to_user_collection(String bookTitle){
        bookStorePage.searchBookWithTitle(bookTitle);
        bookStorePage.openSearchedBook();
        bookDetailsPage.addBookToCollection();
    }
}
