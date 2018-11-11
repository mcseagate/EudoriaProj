package Testcases;

import BaseProj.TestBase;
import PageElements.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage LG;


    public LoginTest(){
        super();
    }


    @BeforeMethod
    public void setup(){
        initialization();
        LG = new LoginPage();
    }


    @Test
    public void LoginPageTest(){
        LG.login();
    }



    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

}
