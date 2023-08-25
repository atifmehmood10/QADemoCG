package utilities;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static demoQA.DemoQABasePage.*;
import static demoQA.utils.PropertiesUtils.getConfig;

public class Hooks {

    @BeforeAll()
    public static void setUp() {
        getConfig();
        startWebBrowser();
    }

    @Before
    public static void beforeTest() {
    }

    @After
    public static void closeDown(io.cucumber.java.Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) getWebDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterAll
    public static void tearDown(){
        endWebBrowser();
    }

}
