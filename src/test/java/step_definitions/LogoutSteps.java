package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import utilities.Driver;

public class LogoutSteps {
    DashboardPage dashboardPage= new DashboardPage();

    @When("user logs out by clicking the Logout button")
    public void user_logs_out_by_clicking_the_logout_button() {
        dashboardPage.userProfileButton.click();
        dashboardPage.logoutButton.click();
    }

    @When("user navigates back")
    public void user_navigates_back() {
        Driver.getDriver().navigate().back();
    }


}