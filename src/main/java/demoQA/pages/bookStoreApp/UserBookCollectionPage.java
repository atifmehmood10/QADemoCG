package demoQA.pages.bookStoreApp;

import demoQA.pages.MyPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserBookCollectionPage extends MyPages {

    private WebDriver driver;

    public UserBookCollectionPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    // verify added book to collection
    public String getAddedBooks(){

        return "";
    }

    // delete book and verify
    public void removeBookFromCollection(String bookTitle){

    }

}
