package PageElements;

import BaseProj.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {


    @FindBy(css="#login_button_container > div > form > input:nth-child(1)")
    WebElement username;

    @FindBy(css="#login_button_container > div > form > input:nth-child(2)")
    WebElement password;

    @FindBy(css="#login_button_container > div > form > input.login-button")
    WebElement submit;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public static String ValidatePageTitle(){
        return driver.getTitle();

    }

    public void username(){
        username.sendKeys(prop.getProperty("username"));
    }

    public void password(){
        password.sendKeys(prop.getProperty("password"));
    }

    public void submit(){
        submit.click();
    }

    public void login(){
        username();
        password();
        submit();
    }

}
