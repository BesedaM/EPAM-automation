package by.epam.learn.automation.task0304.page.googlecalculator;

import by.epam.learn.automation.task0304.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleCalculatorResultsBar extends AbstractPage {

    @FindBy(xpath = "//md-card-content[@id='resultBlock']/descendant::div[contains(text(),'VM class:')]")
    private WebElement computeEngineMachineClass;

    @FindBy(xpath = "//md-content[@id='compute']/descendant::div[contains(text(),'Instance type:')]")
    private WebElement computeEngineInstanceType;

    @FindBy(xpath = "//md-content[@id='soleTenant']/descendant::div[contains(text(),'Instance type:')]")
    private WebElement soleTenantInstanceType;

    @FindBy(xpath = "//md-content[@id='compute']/descendant::div[contains(text(),'Region')]")
    private WebElement computeEngineRegion;

    @FindBy(xpath = "//md-content[@id='soleTenant']/descendant::div[contains(text(),'Region')]")
    private WebElement soleTenantRegion;

    @FindBy(xpath = "//md-content[@id='compute']/descendant::div[contains(text(),'Commitment term')]")
    private WebElement computeEngineCommitmentTerm;

    @FindBy(xpath = "//md-content[@id='soleTenant']/descendant::div[contains(text(),'Commitment term')]")
    private WebElement soleTenantCommitmentTerm;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']/descendant::div[contains(text(),'local SSD')]")
    private WebElement localSsdSpaceResult;

    private static final By EMAIL_ESTIMATE_BUTTON = By.xpath("//button[@id='email_quote']");

    @FindBy(xpath = "//*[contains(text(),'Total Estimated Cost:')]")
    private WebElement totalEstimatedMonthlyCost;


    public GoogleCalculatorResultsBar(WebDriver driver) {
        super(driver);
    }


    public WebElement getComputeEngineVmClass() {
        return computeEngineMachineClass;
    }

    public WebElement getComputeEngineInstanceType(){
        return computeEngineInstanceType;
    }

    public WebElement getComputeEngineRegion(){
        return computeEngineRegion;
    }

    public WebElement getComputeEngineCommitmentTerm(){
        return computeEngineCommitmentTerm;
    }

    public WebElement getSoleTenantRegion(){
        return soleTenantRegion;
    }

    public WebElement getSoleTenantCommitmentTerm(){
        return soleTenantCommitmentTerm;
    }

    public WebElement getSoleTenantLocalSsdSpace() {
        return localSsdSpaceResult;
    }


    public WebElement getTotalEstimatedMonthlyCost() {
        return totalEstimatedMonthlyCost;
    }

    public ContactsForm pressEmailEstimate() {
        waitForElementBeClickable(EMAIL_ESTIMATE_BUTTON).click();
        return new ContactsForm(driver);
    }

}
