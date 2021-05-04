package by.epam.learn.automation.task0304.page.googlecalculator;

import by.epam.learn.automation.task0304.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsForm extends AbstractPage {

    private static By EMAIL_ADDRESS_FIELD = By.xpath("//label[contains(text(),'Email')]/following-sibling::input");

    @FindBy(xpath="//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;


    public ContactsForm(WebDriver driver) {
        super(driver);
    }

    public ContactsForm enterEmail(String email) {
        waitForElementBeClickable(EMAIL_ADDRESS_FIELD).sendKeys(email);
        return this;
    }

    public ContactsForm sendEmail() {
        moveScreenToAndClickOnElement(sendEmailButton);
        return this;
    }
}
