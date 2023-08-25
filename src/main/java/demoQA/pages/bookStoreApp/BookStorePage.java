package demoQA.pages.bookStoreApp;

import demoQA.pages.MyPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static demoQA.utils.WaitUtils.waitForSeconds;
import static demoQA.utils.WaitUtils.waitForWebElementToBePresent;

public class BookStorePage extends MyPages {


    private By searchedBooksCount = By.xpath("//a[contains(@href,\"/books\")]");
    private By searchedBookBy = By.cssSelector(".action-buttons");

    @FindBy(id = "searchBox")
    private WebElement searchBox;

    private WebDriver webDriver;

    public BookStorePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchBookWithTitle(String titleName){
        searchBox.sendKeys(titleName);
        // click book to open
    }

    public int getAllAvailableBooks() {

        waitForSeconds(2);
        waitForWebElementToBePresent(searchedBooksCount, 5);

        List<WebElement> availableBookRows = getWebDriver().findElements(searchedBooksCount);
        return availableBookRows.size();
    }

    public void openSearchedBook() {
        waitForWebElementToBePresent(searchedBookBy, 5);
        WebElement searchedBook = getWebDriver().findElement(searchedBookBy);
        searchedBook.click();
    }


}
