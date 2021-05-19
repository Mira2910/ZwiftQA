package stepdefenition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;
import pages.HomePage;

import utils.BrowserMethods;
import utils.Driver;

public class EventsPage_StepDef {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage(driver);
    EventsPage eventsPage = new EventsPage(driver);

    private static String sportType;
    private static String timeOfEvent;
    private static int hoursOfEvent;


    @When("user click on burger button")
    public void user_click_on_burger_button() {
        BrowserMethods.clickOnElement(homePage.acceptAllCookiesBtn);
        BrowserMethods.clickOnElement(homePage.burgerButton);
    }

    @Then("user click on events")
    public void userClickOnEvents() {
        BrowserMethods.clickOnElement(homePage.eventsButton);
    }

    @And("user validates events {string} page url")
    public void userValidatesEventsPageUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue("Events page URL is wrong",actualUrl.endsWith(expectedUrl));
    }

    @And("user click on filter events button")
    public void userClickOnFilterEventsButton() {
        BrowserMethods.clickOnElement(eventsPage.filterEventsBtn);
    }


    @Then("user populates the Sports Running, Intensities B, and Start Times Morning  dropdown fields and press apply filters")
    public void userPopulatesTheSportsRunningIntensitiesBAndStartTimesMorningDropdownFieldsAndPressApplyFilters() {
        BrowserMethods.clickOnElement(eventsPage.sportRunning);
        BrowserMethods.clickOnElement(eventsPage.intensitiesB);
        BrowserMethods.clickOnElement(eventsPage.startTimesMorning);
        BrowserMethods.clickOnElement(eventsPage.eventsApplyBtn);
    }

    @And("user validates events have changed according to populate")
    public void userValidatesEventsHaveChangedAccordingToPopulate() {

        if (eventsPage.listOfEventsResult.isEmpty()) {
            System.out.println("There are no events according to provided parameters");
        } else {
            eventsPage.listOfEventsResult.forEach(a -> {
                String[] arrayOfEventsInfo = a.getText().split("\n");
                timeOfEvent = arrayOfEventsInfo[0];
                hoursOfEvent = Integer.parseInt(arrayOfEventsInfo[0].substring(0, arrayOfEventsInfo[0].indexOf(":")));
                sportType = arrayOfEventsInfo[3];

                Assert.assertTrue("Time of event is wrong", timeOfEvent.contains("AM"));
                Assert.assertTrue("Time of event is wrong", hoursOfEvent < 12);
                Assert.assertEquals("Sport type is not matching", "RUNNING", sportType);
            });
        }
    }
}
