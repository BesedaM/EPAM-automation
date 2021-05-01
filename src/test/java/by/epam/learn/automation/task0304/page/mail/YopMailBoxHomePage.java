package by.epam.learn.automation.task0304.page.mail;

import by.epam.learn.automation.task0304.page.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopMailBoxHomePage extends Page {

    private static final By TOTAL_ESTIMATED_MONTHLY_COST = By.xpath("//table[@class='quote']/tbody/tr[3]/td[2]");
    private static final By RELOAD_PAGE_BUTTON = By.xpath("//a[@id='lrefr']");

    public YopMailBoxHomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement estimatedMonthlyCostResult() {
        WebElement cost = null;
        while (cost == null) {
            try {
                driver.switchTo().frame("ifmail");
                cost = new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.presenceOfElementLocated(TOTAL_ESTIMATED_MONTHLY_COST));
            } catch (TimeoutException e) {
                reloadPage();
            }
        }


        return cost;
    }

    private YopMailBoxHomePage reloadPage() {
        driver.switchTo().parentFrame();
        selectWebElement(RELOAD_PAGE_BUTTON);
        return this;
    }
}
