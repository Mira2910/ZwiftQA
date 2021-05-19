package stepdefenition;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utils.BrowserMethods;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class HomePage_StepDef {


    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage(driver);


    @Given("user navigates to zwift home page")
    public void user_navigates_to_zwift_home_page() {
        driver.navigate().to(ConfigurationReader.getProperty("configuration","baseUrl"));
    }

    @Then("user validates home page is fully loaded")
    public void user_validates_home_page_is_fully_loaded() {
        BrowserMethods.waitForPageLoaded();
    }

    @Then("user validates home page url {string}")
    public void userValidatesHomePageUrl(String expectedUrl) {
        String actualHomeUrl = driver.getCurrentUrl();
        Assert.assertEquals("Home page URL is wrong",expectedUrl,actualHomeUrl);
    }

    @Then("user validates home page title {string}")
    public void userValidatesHomePageTitle(String expectedTitle) {
        String actualHomeTitle = driver.getTitle();
        Assert.assertEquals("Home page title is wrong",expectedTitle,actualHomeTitle);
    }

    @And("user validates all links working properly")
    public void userValidatesAllLinksWorkingProperly() {
        List<String> brokenLinksList = new ArrayList<>();
        homePage.homePageLinks.forEach(e->{
            if(BrowserMethods.verifyLinks(e.getAttribute("href"))!=null){
                brokenLinksList.add(e.getAttribute("href"));
            }
        });
        Assert.assertTrue("Broken links are present",brokenLinksList.isEmpty());
    }

}
