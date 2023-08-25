package demoQA.pages.bookStoreApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import demoQA.models.Book;
import demoQA.pages.MyPages;
import demoQA.utils.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static demoQA.constants.DemoQAConstants.RESOURCES_PATH;
import static demoQA.utils.GestureUtils.acceptAlertBox;
import static demoQA.utils.GestureUtils.scrollTillElementFound;
import static demoQA.utils.PropertiesUtils.properties;
import static demoQA.utils.WaitUtils.waitForSeconds;

public class BookDetailsPage extends MyPages {

    @FindBy(linkText = "Back To Book Store")
    private WebElement backToBookStore;

    @FindBy(xpath = "//button[contains(text(), 'Add To Your Collection')]")
    private WebElement addToCollection;

    @FindBy(css = "#ISBN-wrapper > div:nth-child(2) > label")
    private WebElement isbn;

    @FindBy(css = "#title-wrapper > div:nth-child(2) > label")
    private WebElement title;

    @FindBy(css = "#subtitle-wrapper > div:nth-child(2) > label")
    private WebElement subTitle;

    @FindBy(css = "#author-wrapper > div:nth-child(2) > label")
    private WebElement author;

    @FindBy(css = "#publisher-wrapper > div:nth-child(2) > label")
    private WebElement publisher;

    @FindBy(css = "#pages-wrapper > div:nth-child(2) > label")
    private WebElement totalPages;

    @FindBy(css = "#description-wrapper > div:nth-child(2) > label")
    private WebElement description;

    @FindBy(css = "#website-wrapper > div:nth-child(2) > label")
    private WebElement webSite;

    private WebDriver webDriver;

    public BookDetailsPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addBookToCollection(){
        waitForSeconds(2);
        scrollTillElementFound(addToCollection);
        addToCollection.click();
        waitForSeconds(1);

        acceptAlertBox();
    }

    public void navigateBackToBookStore(){
        backToBookStore.click();
    }

    public boolean compareBookDetailsToJsonFile(String bookName) {

        boolean bookDetailsMatched = false;

        Book book = new Book();
        book.setAllFields(
                isbn.getText(),
                title.getText(),
                subTitle.getText(),
                author.getText(),
                publisher.getText(),
                totalPages.getText(),
                description.getText(),
                webSite.getText()
        );

        String pathToFile = System.getProperty("user.dir")+properties.getProperty(RESOURCES_PATH)+bookName+".json";

        // Should be comparing in a more efficient way
        Gson gson = new Gson();
        JsonReader data = FileUtils.getJSONFromFile(pathToFile);
        Book actualBook = gson.fromJson(data, Book.class);
            if(         book.getAuthor().equals(actualBook.getAuthor())
                    &&  book.getPublisher().equals(actualBook.getPublisher())
                    &&  book.getTitle().equals(actualBook.getTitle())
                    &&  book.getSubTitle().equals(actualBook.getSubTitle())
                    &&  book.getISBN().equals(actualBook.getISBN())
            ) {
                bookDetailsMatched = true;
            }
        return bookDetailsMatched;
    }

}
