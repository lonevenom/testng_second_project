package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.FlightsPage;
import pages.HomePage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    SoftAssert softAssert;
    HomePage homePage;
    FlightsPage flightsPage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        homePage = new HomePage();
        flightsPage = new FlightsPage();
    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }
}