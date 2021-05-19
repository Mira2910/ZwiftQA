package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends BasePage {


    public EventsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Filter events']")
    public WebElement filterEventsBtn;

    @FindBy(xpath = "//button[text()='Running']")
    public WebElement sportRunning;

    @FindBy(xpath = " //button[text()='B']")
    public WebElement intensitiesB;

    @FindBy(xpath = " //button[text()='Morning']")
    public WebElement startTimesMorning;

    @FindBy(xpath = "//button[@class='apply-button']")
    public WebElement eventsApplyBtn;

    @FindBy(xpath = "//div[@class='map-title']")
    public List<WebElement> listSportTypeResult;

    @FindBy(xpath = "//div[@class='listing-header']//span")
    public List<WebElement> listSportTimeResult;

    @FindBy(xpath = "//div[@data-label='2']")
    public List<WebElement> listSportIntensitiesB;

    @FindBy(xpath = "//div[@class='tab-listing']")
    public List<WebElement> listOfEventsResult;

}
