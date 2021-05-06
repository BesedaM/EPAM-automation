package by.epam.learn.automation.task0304.page.mail;

import by.epam.learn.automation.task0304.page.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopMailBoxHomePage extends AbstractPage {

    private static final By TOTAL_ESTIMATED_MONTHLY_COST = By.xpath("//table[@class='quote']/tbody/tr[3]/td[2]");
    private static final By RELOAD_PAGE_BUTTON = By.xpath("//a[@id='lrefr']");

    private static final String MAINFRAME = "ifmail";

    private static final int WAITING_TO_RELOAD_PAGE_IN_SECONDS = 3;
    private static final int MAX_NUMBER_OF_FAILS = 4;

    private int numberOfFails;


    public YopMailBoxHomePage(WebDriver driver) {
        super(driver);
        numberOfFails = 0;
    }

    public WebElement getEstimatedMonthlyCostResult() {
        WebElement cost = null;
        while (cost == null) {
            try {
                driver.switchTo().frame(MAINFRAME);
                cost = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TO_RELOAD_PAGE_IN_SECONDS))
                        .until(ExpectedConditions.presenceOfElementLocated(TOTAL_ESTIMATED_MONTHLY_COST));
            } catch (TimeoutException e) {
                if (numberOfFails < MAX_NUMBER_OF_FAILS) {
                    numberOfFails++;
                    reloadPage();
                } else {
                    e.printStackTrace();
                }
            }
        }
        return cost;
    }


    private YopMailBoxHomePage reloadPage() {
        driver.switchTo().parentFrame();
        waitForElementBeClickable(RELOAD_PAGE_BUTTON).click();
        return this;
    }
}
