package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement inputUsername;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement logInButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement header;

    @FindBy(xpath = "//div[text()='Invalid user name or password.']")
    public WebElement warningMessage;

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement name;

    public void logIn(String username,String password){
        this.inputUsername.sendKeys(username);
        this.inputPassword.sendKeys(password);
        this.logInButton.click();

    }

}
