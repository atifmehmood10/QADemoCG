package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static demoQA.pages.MyPages.demoQAHomePage;

public class DemoQAFirst_Steps {


    @Given("User opens DemoQA homepage")
    public void user_opens_demoqa_homepage() {
        demoQAHomePage.openHomePage();
        demoQAHomePage.navigateToAlertsFramesWindows();
    }

    @Then("User verifies header links")
    public void user_verifies_header_links(){
//        demoQAHomePage.verifyHeaderLink();
    }


}
