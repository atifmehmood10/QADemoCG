package stepDefinitions.browserInteractionSteps;

import io.cucumber.java.en.Then;
import org.testng.Assert;

import static demoQA.pages.MyPages.browserWindowsPage;

public class WindowInteraction_Steps {

    @Then("User clicks on new window button and verifies sample heading")
    public void user_clicks_on_new_window_button_and_verifies_sample_heading(){
        String newTabText = browserWindowsPage.switchToNewWindow();
        Assert.assertEquals(newTabText, "This is a sample page");
    }

}
