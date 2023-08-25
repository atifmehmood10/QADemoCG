package demoQA.pages.bookStoreApp;

import demoQA.pages.MyPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static demoQA.utils.GestureUtils.acceptAlertBox;
import static demoQA.utils.WaitUtils.waitForWebElementToBePresent;

public class UserProfilePage extends MyPages {

    private WebDriver driver;

    private By allBooksBy = By.xpath("//a[contains(@href, '/profile?book')]");

    private By searchBoxBy = By.id("searchBox");

    private By deleteIconBy = By.id("delete-record-undefined");


    public UserProfilePage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void searchBookWithTitle(String titleName){
        waitForWebElementToBePresent(searchBoxBy,10);
        WebElement searchBox = getWebDriver().findElement(searchBoxBy);
        searchBox.sendKeys(titleName);
        // click book to open
    }
    public boolean getBookInUserCollectionByBookTitle(String bookTitle) {
        boolean isBookPresent = false;

        List<WebElement> allBooks = getWebDriver().findElements(allBooksBy);
        for(WebElement book: allBooks){
            if(book.getText().equals(bookTitle)){
                isBookPresent = true;
                break;
            }
        }
        return isBookPresent;
    }

    public void deleteSelectedBook() {

        WebElement deleteButton = getWebDriver().findElement(deleteIconBy);
        deleteButton.click();

        By confirmDeleteBy = By.id("closeSmallModal-ok");

        WebElement confirmDelete = waitForWebElementToBePresent(confirmDeleteBy, 10);
        confirmDelete.click();

        acceptAlertBox();
    }
}
