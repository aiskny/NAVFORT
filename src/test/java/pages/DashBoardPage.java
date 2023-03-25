package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LogoutPage {
    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    public WebElement userProfileButton;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutButton;

}
