package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class valid_login_step_definition {
    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("login.url");
        Driver.getDriver().get(url);
    }


    @When("user login as {string}")
    public void user_login_as(String userType) {
        String format = String.format("%s.username", userType);
        String username =ConfigurationReader.getProperty(format); //driver.username
        String password =ConfigurationReader.getProperty(String.format("%s.password",userType));
        loginPage.logIn(username,password);

    }


    @Then("user should land on the {string} page")
    public void user_should_land_on_the_page(String pagename) {
        BrowserUtils.sleep(3);
        Assert.assertEquals(pagename,loginPage.header.getText());
    }

}
