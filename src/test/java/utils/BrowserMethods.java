package utils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BrowserMethods{

    static WebDriver  driver = Driver.getDriver();

    /**
     *This method clicks on WebElement
     * @param element
     */
    public static void clickOnElement(WebElement element){
        clickAbilityOfElement(driver,10,element);
        element.click();
    }

    /**
     *  This method send text to WebElement
     * @param element
     * @param text
     */
    public static void enterTextToElement(WebElement element,String text){
        visibilityOfElement(driver,10,element);
        element.clear();
        element.sendKeys(text);
    }


    /**
     *This method waits until page fully loaded
     */
    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }



    /**
     * This method verifies links working properly
     * @param linkUrl
     * @return
     */
    public static String verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();

            if(httpURLConnect.getResponseCode()!=200) {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
                return linkUrl;
            }
        }catch (Exception e) {
        }
        return null;
    }



    /**
     * This method scroll down to WebElement
     * @param element
     */
    public static void scrollDownToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * This method waits until WebElement to be visible
     * @param driver
     * @param timeInSecond
     * @param element
     * @return
     */
    public static WebElement visibilityOfElement(WebDriver driver, long timeInSecond, WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeInSecond);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * This method waits until WebElement to be clickable
     * @param driver
     * @param timeInSecond
     * @param element
     * @return
     */
    public static WebElement clickAbilityOfElement(WebDriver driver, long timeInSecond, WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,timeInSecond);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * This method checks the WebElement at a specific frequency
     * @param driver
     * @param totalSecond
     * @param pollingSecond
     * @param locator
     * @return
     */
    public static WebElement fluentWait(WebDriver driver, long totalSecond, long pollingSecond, By locator){
        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalSecond))
                .pollingEvery(Duration.ofSeconds(pollingSecond))
                .ignoring(RuntimeException.class);

        return wait.until(driver1 -> driver1.findElement(locator));
    }

}
