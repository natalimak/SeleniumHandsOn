/*Create a TestNG test using tests efficiency techniques:
        1. Constants.
        2. POM (Page Object Model).
         Enter https://dgotlieb.github.io/WebCalculator/
         Print “7” button dimensions (using Constant).
         Check if “6” button is displayed
         Prepare an int variable with any number
         Calculate a mathematical formula that will give the result you
        choose in the int variable earlier (using POM)
         Use assert to check if you got the expected result
         Use a Singleton class to create and return your driver.*/
package hw10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hw10.Constants.*;

public class WebCalculator {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = DriverSingleton.getDriverInstance();
        driver.get(Constants.URL2);
    }
    @Test (priority = 1)
    public static void WebCalculator7Button(){
        WebElement button7 = driver.findElement(By.id(BUTTON7));
        System.out.println("Height of button 7: " + button7.getRect().getHeight());
        System.out.println("Width of button 7: " + button7.getRect().getWidth());

    }
    @Test (priority = 2)
    public static void WebCalculator(){
        WebCalculate_Tool res=new WebCalculate_Tool();
        WebElement result = driver.findElement(By.cssSelector(RESULT));
        WebElement button6 = driver.findElement(By.id(BUTTON6));
        WebElement button5 = driver.findElement(By.id(BUTTON5));
        WebElement add = driver.findElement(By.id(ADD));
        WebElement equal = driver.findElement(By.id(EQUAL));

        button5.click();
        add.click();
        button6.click();
        equal.click();
        System.out.println(result.getText());
        int results=Integer.valueOf(result.getText());

        int result_e= res.Add(6,5);
        Assert.assertEquals(result_e,results);
    }
}
