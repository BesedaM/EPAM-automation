package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.page.AbstractPage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SoleTenantNodesForm extends AbstractPage {

    @FindBy(xpath = "//label[contains(text(),'Number of nodes')]/following-sibling::input")
    private WebElement soleTenantNodesNumberInput;

    @FindBy(xpath = "//div[contains(text(),'Add GPUs.')]/preceding-sibling::div")
    private WebElement addGpuMark;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeSelect;

    private static final By GPU_TYPE_NVIDIA_TESLA = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement gpuNumberSelect;

    private static final By GPU_NUMBER_EIGHT = By.xpath("//label[text()='Number of GPUs']/following::md-option[@value='8']");

    @FindBy(xpath="//label[text()='Local SSD']/following-sibling::md-select")
    private WebElement localSsdSelect;

    private static final By LOCAL_SSD_TYPE_24x375_GB = By.xpath("//div[text()='24x375 GB']/parent::md-option");

    @FindBy(xpath = "//h2[text()='Sole-tenant nodes']/following::md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocation;

    @FindBy(xpath="//div[@aria-hidden='false']/descendant::div[contains(text(),'Iowa')]/parent::md-option")
    private WebElement concreteDatacenterLocation;

    @FindBy(xpath="//form[@name='SoleTenantForm']//child::md-select[@placeholder='Committed usage']/md-select-value")
    private WebElement committedUsageSelect;

    @FindBy(xpath="//div[@aria-hidden='false']//div[contains(text(),'1 Year')]/parent::md-option")
    private WebElement concreteCommittedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][not(@disabled)]")
    private WebElement addToEstimateButton;

    public SoleTenantNodesForm(WebDriver driver) {
        super(driver);
    }

    /**
     * The scenario of filling the form of Google Pricing Calculator
     *
     * @return GoogleCalculatorPageFormFiller page
     */
    public SoleTenantNodesForm fillForm() {
        moveScreenToElement(soleTenantNodesNumberInput);
        soleTenantNodesNumberInput.sendKeys(2 + "");

        this.addDataOnGPU();

        localSsdSelect.click();
        clickOnElement(LOCAL_SSD_TYPE_24x375_GB);

        datacenterLocation.click();
        concreteDatacenterLocation.click();

        committedUsageSelect.click();
        concreteCommittedUsage.click();
        return this;
    }


    private void addDataOnGPU() {
        moveScreenToAndClickOnElement(addGpuMark);
        gpuTypeSelect.click();
        clickOnElement(GPU_TYPE_NVIDIA_TESLA);

        gpuNumberSelect.click();
        clickOnElement(GPU_NUMBER_EIGHT);
    }


    public GoogleCalculatorResultsBar addToEstimate() {
        addToEstimateButton.click();
        return new GoogleCalculatorResultsBar(driver);
    }


}
