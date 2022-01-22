/*Using ngWebDriver
        (https://github.com/paul-hammant/ngWebDriver)
         Enter https://dgotlieb.github.io/AngularJS/main.html
         Clear first name.
         Enter your first name instead.
         Assert result.*/
package hw10;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw10.Constants.*;

public class HW10_2 {
    private static WebDriver driver;
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(Constants.URL1);
    }
    @Test
    public static void insertNewData(){
        driver.findElement(ByAngular.model(NAME)).clear();
        driver.findElement(ByAngular.model(NAME)).sendKeys(MYNAME);
        Assert.assertEquals(MYNAME,
                driver.findElement(ByAngular.binding(NAME)).getText());
    }
}
