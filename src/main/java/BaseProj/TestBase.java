package BaseProj;

import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
   public static WebDriver driver;
   public static Properties prop;
   public static FileInputStream ip;


    public TestBase(){

        try {
            prop = new Properties();
            ip   = new FileInputStream("/Users/mcseagate/IdeaProjects/EudoriaProj/src/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e){
            e.printStackTrace();

        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
           System.setProperty("webdriver.chrome.driver", "/Users/mcseagate/Documents/Drivers/chromedriver");
           driver = new ChromeDriver();

        } else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/mcseagate/Documents/Drivers/geckodriver");
            driver = new FirefoxDriver();

        } else {
            System.out.println("Driver Not Found");
        }

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }



}
