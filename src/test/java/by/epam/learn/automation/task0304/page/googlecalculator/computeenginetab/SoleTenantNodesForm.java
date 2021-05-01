package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.page.Page;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SoleTenantNodesForm extends Page {

    private static final By SOLE_TENANT_NODES_NUMBER_INPUT = By.xpath("//label[contains(text(),'Number of nodes')]/following-sibling::input");
    private static final By ADD_GPU_MARK = By.xpath("//div[contains(text(),'Add GPUs.')]/preceding-sibling::div");
    private static final By GPU_TYPE_SELECT = By.xpath("//md-select[@placeholder='GPU type']");
    private static final By GPU_TYPE_NVIDIA_TESLA = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private static final By NUMBER_OF_GPUS_SELECT = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private static final By GPU_NUMBER_EIGHT = By.xpath("//label[text()='Number of GPUs']/following::md-option[@value='8']");
    private static final By LOCAL_SSD_SELECT = By.xpath("//label[text()='Local SSD']/following-sibling::md-select");
    private static final By LOCAL_SSD_TYPE_24x375_GB = By.xpath("//div[text()='24x375 GB']/parent::md-option");

    private static final By DATACENTER_LOCATION_SELECT = By.xpath("//h2[text()='Sole-tenant nodes']/following::md-select[@placeholder='Datacenter location']");
    private static final By DATACENTER_LOCATION_IOWA = By.xpath("//div[@aria-hidden='false']/descendant::div[contains(text(),'Iowa')]/parent::md-option");
    private static final By COMMITTED_USAGE_SELECT = By.xpath("//form[@name='SoleTenantForm']//child::md-select[@placeholder='Committed usage']/md-select-value");
    private static final By COMMITTED_USAGE_1_YEAR = By.xpath("//div[@aria-hidden='false']//div[contains(text(),'1 Year')]/parent::md-option");
    private static final By ADD_TO_ESTIMATE_BUTTON = By.xpath("//button[@aria-label='Add to Estimate'][not(@disabled)]");

    public SoleTenantNodesForm(WebDriver driver) {
        super(driver);
    }

    /**
     * The scenario of filling the form of Google Pricing Calculator
     *
     * @return GoogleCalculatorPageFormFiller page
     */
    public SoleTenantNodesForm fillForm() {
        waitForElementLocatedBy(driver, SOLE_TENANT_NODES_NUMBER_INPUT).sendKeys(2 + "");

        this.addDataOnGPU();

        selectWebElement(LOCAL_SSD_SELECT);
        selectWebElement(LOCAL_SSD_TYPE_24x375_GB);

        selectWebElement(DATACENTER_LOCATION_SELECT);
        selectWebElement(DATACENTER_LOCATION_IOWA);

        selectWebElement(COMMITTED_USAGE_SELECT);
        selectWebElement(COMMITTED_USAGE_1_YEAR);

        return this;
    }


    private void addDataOnGPU() {
        selectWebElement(ADD_GPU_MARK);

        selectWebElement(GPU_TYPE_SELECT);
        selectWebElement(GPU_TYPE_NVIDIA_TESLA);

        selectWebElement(NUMBER_OF_GPUS_SELECT);
        selectWebElement(GPU_NUMBER_EIGHT);
    }


    public GoogleCalculatorResults addToEstimate() {
        selectWebElement(ADD_TO_ESTIMATE_BUTTON);
        return new GoogleCalculatorResults(driver);
    }


}
