package by.epam.learn.automation.task0304.page.mail;

import by.epam.learn.automation.task0304.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class YopMailGeneratorPage extends Page {

    private static final String YOP_MAIL_GENERATOR_PAGE = "http://www.yopmail.com/ru/email-generator.php";
    private static final By YOP_EMAIL = By.xpath("//input[@id='login']");
    private static final By CHECK_EMAIL = By.xpath("//input[@type='submit']");
    private static final String EMAIL_ATTRIBUTE_NAME = "value";

    public YopMailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public YopMailGeneratorPage openPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YOP_MAIL_GENERATOR_PAGE);
        return this;
    }

    public String getEmail() {
        WebElement searchInput = waitForElementLocatedBy(driver, YOP_EMAIL);
        return searchInput.getAttribute(EMAIL_ATTRIBUTE_NAME);
    }

    public YopMailBoxHomePage goToEmailPage() {
        waitForElementLocatedBy(driver, CHECK_EMAIL).click();
        return new YopMailBoxHomePage(driver);
    }
}
