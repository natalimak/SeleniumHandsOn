/*Open Google in first tab
        • Open YouTube on the second tab
        • Open Google translate in the third tab.
        • From translate go to Google and from Google go to YouTube.*/
package hw10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HW10_5FewTabs {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = DriverSingleton.getDriverInstance();
    }
    @Test (priority = 1)
    public static void GoogleTab(){
        driver.get(Constants.GOOGLE);

    }
    @Test (priority = 2)
    public static void YouTubeTab(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Constants.YOUTUBE);
    }
    @Test (priority = 3)
    public static void TranslateTab(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Constants.TRANSL);
    }
    @Test (priority = 4)
    public static void GoToTabs(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.findElement(By.className("gb_d")).click();
        driver.switchTo().window(tabs.get(1));
    }
}
