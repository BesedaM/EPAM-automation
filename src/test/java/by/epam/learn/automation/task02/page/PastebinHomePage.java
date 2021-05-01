package by.epam.learn.automation.task02.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinHomePage extends Page {

    private static final String PASTEBIN_HOME_PAGE = "https://pastebin.com";
    private static final By TEXTAREA_ID = By.id("postform-text");
    private static final By EXPIRATION_SELECTION_XPATH = By.xpath("//span[@id='select2-postform-expiration-container']//following::span");
    private static final By LIST_ELEMENT_EXPIRATION_SELECTION_XPATH = By.xpath("//li[text()='10 Minutes']");
    private static final By PASTE_NAME_ID = By.id("postform-name");
    private static final By SUBMIT_BUTTON_XPATH = By.xpath("//button[text()='Create New Paste']");
    public static final By HIGHLIGHTING_SELECTION_ID = By.id("select2-postform-format-container");
    public static final By LIST_ELEMENT_HIGHLIGHTING_SELECTION_XPATH = By.xpath("//li[@aria-label='------ ALL LANGUAGES -------']/descendant::li[text()='Bash']");


    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage(){
        driver.get(PASTEBIN_HOME_PAGE);
        return this;
    }

    public ResultPage fillFormAndSubmit(String message, String pasteName) throws InterruptedException {
        waitForElementLocatedBy(driver, TEXTAREA_ID).sendKeys(message);
        Thread.sleep(2000);

        waitForElementLocatedBy(driver, HIGHLIGHTING_SELECTION_ID).click();
        Thread.sleep(1000);
        waitForElementLocatedBy(driver, LIST_ELEMENT_HIGHLIGHTING_SELECTION_XPATH).click();
        Thread.sleep(2000);

        waitForElementLocatedBy(driver, EXPIRATION_SELECTION_XPATH).click();
        Thread.sleep(1000);
        waitForElementLocatedBy(driver, LIST_ELEMENT_EXPIRATION_SELECTION_XPATH).click();
        Thread.sleep(2000);

        waitForElementLocatedBy(driver, PASTE_NAME_ID).sendKeys(pasteName);
        Thread.sleep(2000);

        waitForElementLocatedBy(driver, SUBMIT_BUTTON_XPATH).click();
        return new ResultPage(driver);
    }


}
