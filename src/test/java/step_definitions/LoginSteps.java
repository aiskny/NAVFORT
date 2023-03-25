package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @When("user login with {string} and {string}")
    public void user_login_with_and(String username, String password) {
        loginPage.logIn(username, password);
    }

    @Then("{string} message should be displayed for invalid credentials")
    public void message_should_be_displayed_for_invalid_credentials(String expedtedWarningMessageForCredentials) {
        Assert.assertEquals(expedtedWarningMessageForCredentials, loginPage.warningMessage.getText());

    }

    @Then("{string} message should be thrown from password field")
    public void message_should_be_thrown_from_password_field(String expectedWMessageForField) {
        // loginPage.logInButton.click();
        String warningMessage = loginPage.inputPassword.getAttribute("validationMessage");
        Assert.assertEquals(expectedWMessageForField, warningMessage);

    }

    @Then("{string} message should be thrown from username field")
    public void message_should_be_thrown_from_username_field(String expectedWMessageForField) {

        String warningMessage = loginPage.inputUsername.getAttribute("validationMessage");
        Assert.assertEquals(expectedWMessageForField, warningMessage);
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        loginPage.logInButton.click();
    }

    @Then("user can see {string}")
    public void user_can_see(String userName) {
        BrowserUtils.waitForVisibilityOf(loginPage.name);
        String actualName = loginPage.name.getText().trim();
        System.out.println("actualName = " + actualName);
        Assert.assertEquals(userName, actualName);

    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("login.url");
        Driver.getDriver().get(url);
    }

    @When("user login as {string}")
    public void user_login_as(String userType) {
        String format = String.format("%s.username", userType);
        String username = ConfigurationReader.getProperty(format); //driver.username
        String password = ConfigurationReader.getProperty(String.format("%s.password", userType));
        loginPage.logIn(username, password);

    }

    @Then("user should land on the {string} page")
    public void user_should_land_on_the_page(String pagename) {
        BrowserUtils.sleep(3);
        Assert.assertEquals(pagename, loginPage.header.getText());
    }

}
