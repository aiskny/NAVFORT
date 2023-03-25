package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
    @Before
    public void setup() {
        String url = ConfigurationReader.getProperty("login.url");
        Driver.getDriver().get(url);
    }

    @After
    public void teardownScenario(Scenario scenario) {
        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            BrowserUtils.sleep(3);
        }
        //BrowserUtils.sleep(5);
        Driver.closeDriver();
        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }
}
