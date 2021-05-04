package by.epam.learn.automation.task0304.util;

import org.openqa.selenium.WebDriver;

public class PageUtils {

    public static void navigateToPage(WebDriver driver, String windowName) {
        driver.switchTo().window(windowName);
    }
}
