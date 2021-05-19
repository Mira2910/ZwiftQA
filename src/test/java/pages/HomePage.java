package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//button[@class='_1y_LNCV6bN8pLbpzSLHKCd']")
    public WebElement burgerButton;

    @FindBy(xpath = "//span[text()='Events']")
    public WebElement eventsButton;

    @FindBy(xpath = "//span[text()='Participate in Meetups']")
    public WebElement participateInMeetupsBtn;

    @FindBy(xpath = "//a")
    public List<WebElement> homePageLinks;

    @FindBy(xpath = "//img")
    public List<WebElement> homePageImages;

    @FindBy(xpath = "//button[text()='Accept All']")
    public WebElement acceptAllCookiesBtn;




}
