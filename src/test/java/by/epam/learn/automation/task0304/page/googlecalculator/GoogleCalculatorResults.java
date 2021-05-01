package by.epam.learn.automation.task0304.page.googlecalculator;

import by.epam.learn.automation.task0304.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleCalculatorResults extends Page {

    private static final By VM_CLASS_RESULT = By.xpath("//md-card-content[@id='resultBlock']/descendant::div[contains(text(),'VM class:')]");
    private static final By INSTANCE_TYPE_RESULTS = By.xpath("//md-card-content[@id='resultBlock']/descendant::div[contains(text(),'Instance type:')]");
    private static final By REGION_RESULTS = By.xpath("//md-card-content[@id='resultBlock']/descendant::div[contains(text(),'Region:')]");
    private static final By COMMITMENT_TERM_RESULTS = By.xpath("//md-card-content[@id='resultBlock']/descendant::div[contains(text(),'Commitment term:')]");
    private static final By LOCAL_SSD_RESULT = By.xpath("//md-card-content[@id='resultBlock']/descendant::div[contains(text(),'local SSD')]");
    private static final By EMAIL_ESTIMATE_BUTTON = By.xpath("//button[@id='email_quote']");
    private static final By TOTAL_ESTIMATED_MONTHLY_COST = By.xpath("//*[contains(text(),'Total Estimated Cost:')]");


    public GoogleCalculatorResults(WebDriver driver) {
        super(driver);
    }


    public WebElement getVmClass() {
        return waitForElementLocatedBy(driver, VM_CLASS_RESULT);
    }

    public List<WebElement> getInstanceTypes() {
        return waitForElementsLocatedBy(driver, INSTANCE_TYPE_RESULTS);
    }

    public List<WebElement> getRegions() {
        return waitForElementsLocatedBy(driver, REGION_RESULTS);
    }

    public List<WebElement> getCommitmentTerms() {
        return waitForElementsLocatedBy(driver, COMMITMENT_TERM_RESULTS);
    }

    public WebElement getLocalSsdSpace() {
        return waitForElementLocatedBy(driver, LOCAL_SSD_RESULT);
    }

    public WebElement getTotalEstimatedMonthlyCost() {
        return waitForElementLocatedBy(driver, TOTAL_ESTIMATED_MONTHLY_COST);
    }

    public ContactsForm pressEmailEstimate() {
        waitForElementLocatedBy(driver, EMAIL_ESTIMATE_BUTTON).click();
        return new ContactsForm(driver);
    }

}
