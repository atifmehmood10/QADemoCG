package stepDefinitions.browserInteractionSteps;

import io.cucumber.java.en.Then;
import org.testng.Assert;

import static demoQA.pages.MyPages.browserWindowsPage;

public class TabInteractions_Steps {

    @Then("User clicks on new tab button and verifies sample heading")
    public void user_clicks_on_new_tab(){
        String newTabText = browserWindowsPage.switchToNewTabAndGetText();
        Assert.assertEquals(newTabText, "This is a sample page");
    }
}
