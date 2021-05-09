package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.model.SoleTenantNode;
import by.epam.learn.automation.task0304.page.AbstractPage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.util.StringUtils;
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

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement gpuNumberSelect;

    @FindBy(xpath = "//label[text()='Local SSD']/following-sibling::md-select")
    private WebElement localSsdSelect;

    @FindBy(xpath = "//h2[text()='Sole-tenant nodes']/following::md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//form[@name='SoleTenantForm']//child::md-select[@placeholder='Committed usage']/md-select-value")
    private WebElement committedUsageSelect;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][not(@disabled)]")
    private WebElement addToEstimateButton;

    private static final String GPU_TYPE = "//md-option[@value='**']";
    private static final String GPU_NUMBER = "//label[text()='Number of GPUs']/following::md-option[@value='**'][@aria-disabled='false']";
    private static final String LOCAL_SSD_NUMBER = "//div[@aria-hidden='false']//md-option[@value='**']";
    private static final String DATACENTER_LOCATION = "//div[@aria-hidden='false']//md-option[@value='**']";
    private static final String COMMITTED_USAGE_PERIOD = "//div[@aria-hidden='false']//md-option[@value='**']";


    public SoleTenantNodesForm(WebDriver driver) {
        super(driver);
    }

    /**
     * The scenario of filling the form of Google Pricing Calculator
     *
     * @return GoogleCalculatorPageFormFiller page
     */
    public SoleTenantNodesForm fillForm(Integer number, SoleTenantNode node) {
        moveScreenToElementJS(soleTenantNodesNumberInput);
        soleTenantNodesNumberInput.sendKeys(number + "");

        this.addDataOnGPU(node);

        localSsdSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(LOCAL_SSD_NUMBER, node.getLocalSsdNumber())).click();

        datacenterLocation.click();
        waitForElementBeClickable(StringUtils.useValueInString(DATACENTER_LOCATION, node.getLocation().getValue())).click();

        committedUsageSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(COMMITTED_USAGE_PERIOD, node.getPeriod() + "")).click();
        return this;
    }


    private void addDataOnGPU(SoleTenantNode node) {
        moveScreenToAndClickOnElementJS(addGpuMark);
        gpuTypeSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(GPU_TYPE,node.getGpuTypeLastName())).click();

        gpuNumberSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(GPU_NUMBER, node.getMaxNumberOfGPUForNode()+"")).click();
    }


    public GoogleCalculatorResultsBar addToEstimate() {
        addToEstimateButton.click();
        return new GoogleCalculatorResultsBar(driver);
    }


}
