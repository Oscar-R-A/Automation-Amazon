package Tests;

import Pages.HomePage;
import Utils.MyDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    MyDriver driver;
    public String url = "https://www.amazon.com/";
    @BeforeMethod (alwaysRun = true)
    public void beforeMethod(){
        driver = new MyDriver();
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get(url);
    }
    public HomePage loadFirstPage(){
        return new HomePage(driver.getDriver());
    }
    @AfterMethod
    public void afterMethod(){
        driver.getDriver().quit();
    }
}
