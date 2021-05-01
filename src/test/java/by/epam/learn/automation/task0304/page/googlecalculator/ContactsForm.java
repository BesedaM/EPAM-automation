package by.epam.learn.automation.task0304.page.googlecalculator;

import by.epam.learn.automation.task0304.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsForm extends Page {

    private static By EMAIL_ADDRESS_FIELD = By.xpath("//label[contains(text(),'Email')]/following-sibling::input");
    private static By SEND_EMAIL_BUTTON = By.xpath("//button[@aria-label='Send Email']");

    public ContactsForm(WebDriver driver) {
        super(driver);
    }

    public ContactsForm enterEmail(String email) {
        waitForElementBeClickable(driver, EMAIL_ADDRESS_FIELD).sendKeys(email);
        return this;
    }

    public ContactsForm sendEmail() {
        waitForElementBeClickable(driver,SEND_EMAIL_BUTTON).click();
        return this;
    }
}
