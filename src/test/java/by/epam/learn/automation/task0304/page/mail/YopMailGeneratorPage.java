package by.epam.learn.automation.task0304.page.mail;

import by.epam.learn.automation.task0304.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class YopMailGeneratorPage extends AbstractPage {

    private static final String YOP_MAIL_GENERATOR_PAGE = "http://www.yopmail.com/ru/email-generator.php";
    private static final String EMAIL_ATTRIBUTE_NAME = "value";

    @FindBy(xpath = "//input[@id='login']")
    private WebElement emailAddress;

    @FindBy(xpath="//input[@type='submit']")
    private WebElement goToEmailPageButton;

    public YopMailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public YopMailGeneratorPage openPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(YOP_MAIL_GENERATOR_PAGE);
        return this;
    }

    public String getEmail() {
        return emailAddress.getAttribute(EMAIL_ATTRIBUTE_NAME);
    }

    public YopMailBoxHomePage goToEmailPage() {
        goToEmailPageButton.click();
        return new YopMailBoxHomePage(driver);
    }
}
