package by.epam.learn.automation.task01.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinHomePage extends Page{

    private static final String PASTEBIN_HOME_PAGE = "https://pastebin.com";
    private static final By TEXTAREA_ID = By.id("postform-text");
    private static final By EXPIRATION_SELECTION_XPATH = By.xpath("//span[@id='select2-postform-expiration-container']//following::span");
    private static final By LIST_ELEMENT_EXPIRATION_SELECTION_XPATH = By.xpath("//li[text()='10 Minutes']");
    private static final By PASTE_NAME_ID = By.id("postform-name");
    private static final By SUBMIT_BUTTON_XPATH = By.xpath("//button[text()='Create New Paste']");
    private static final String PASTE_NAME = "helloweb";


    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage(){
        driver.get(PASTEBIN_HOME_PAGE);
        return this;
    }

    public ResultPage fillFormAndSubmit(String message) {
        waitForElementLocatedBy(driver, TEXTAREA_ID).sendKeys(message);
        waitForElementLocatedBy(driver, EXPIRATION_SELECTION_XPATH).click();
        waitForElementLocatedBy(driver, LIST_ELEMENT_EXPIRATION_SELECTION_XPATH).click();
        waitForElementLocatedBy(driver, PASTE_NAME_ID).sendKeys(PASTE_NAME);
        waitForElementLocatedBy(driver, SUBMIT_BUTTON_XPATH).click();
        return new ResultPage(driver);
    }


}
