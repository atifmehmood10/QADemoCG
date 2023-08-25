package stepDefinitions.browserInteractionSteps;

import io.cucumber.java.en.Given;

import static demoQA.pages.MyPages.browserInteractionsSubMenu;
import static demoQA.pages.MyPages.demoQAHomePage;

public class InteractionsMenu_Steps {


    @Given("User is on Alerts, Frames & Windows Page")
    public void user_is_on_alerts_frames_windows_page()
    {
        demoQAHomePage.openHomePage();
        demoQAHomePage.navigateToAlertsFramesWindows();
        browserInteractionsSubMenu.navigateToWindowsPage();
    }
}
