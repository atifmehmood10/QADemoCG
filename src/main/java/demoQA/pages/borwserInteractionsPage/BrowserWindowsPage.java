package demoQA.pages.borwserInteractionsPage;

import demoQA.pages.MyPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static demoQA.utils.WaitUtils.waitForSeconds;

public class BrowserWindowsPage extends MyPages {


    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    private WebDriver driver;

    public BrowserWindowsPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public String switchToNewTabAndGetText(){
        String originalWindow = driver.getWindowHandle();
        newTabButton.click();
        waitForSeconds(2);
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(browserTabs.get(1));
        String sampleText =  getWebDriver().findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        driver.switchTo().window(originalWindow);

        return sampleText;
    }

    public String switchToNewWindow(){

        String originalWindow = driver.getWindowHandle();
        newWindowButton.click();
        waitForSeconds(2);
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(browserTabs.get(1));
        String sampleText =  getWebDriver().findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        driver.switchTo().window(originalWindow);

        return sampleText;
    }


}
