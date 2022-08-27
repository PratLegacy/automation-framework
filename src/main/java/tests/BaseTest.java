package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.loggers.Log;

import java.time.Duration;

public class BaseTest {

    final String PATH = "/Users/pramakrishnan/Downloads/chromedriver104";
    final String URL = "https://demoqa.com/";
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", PATH);
        Log.info("Driver setup initiated");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);
    }

    public void driverTearDown() {
        Log.info("Driven teardown initiated");
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }


}
