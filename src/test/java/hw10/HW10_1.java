/*Enter https://dgotlieb.github.io/Selenium/synchronization.html
         Press on “remove checkbox” button and find the new element
        that will show up under the CheckBox - use Implicit Wait.
         Press on “Show hidden” button and find the new element that
        will replace the “Show hidden” button - use Thread.sleep().
         Press on “render” button and find the new element that will
        show under “render” button – use Explicit Wait.*/

package hw10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import static hw10.Constants.*;

public class HW10_1 {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Constants.URL);
    }
    @Test   (priority = 1)    /*Press on “remove checkbox” button and find the new element
                                  that will show up under the CheckBox - use Implicit Wait.*/
    public static void checkBox(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(REMOVE_CHECKBOX)).click();
    }

    @Test  (priority = 2)     /*Press on “Show hidden” button and find the new element that
                                  will replace the “Show hidden” button - use Thread.sleep().*/
    public static void showHidden() throws InterruptedException{
        driver.findElement(By.cssSelector(SHOWHIDDEN)).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div#finish1 h4")).getText();
        Assert.assertEquals( driver.findElement(By.cssSelector("div#finish1 h4")).getText(),
                "My Hidden Element!");
    }
    @Test  (priority = 3)
    public static void render() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(RENDER)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish2 h4")));
    }
}
