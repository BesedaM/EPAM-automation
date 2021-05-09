package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.model.Instance;
import by.epam.learn.automation.task0304.page.AbstractPage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InstancesForm extends AbstractPage {

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input[@name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//label[text()='Operating System / Software']/following-sibling::md-select")
    private WebElement operationSystemSelect;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement virtualMachineClassSelect;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement instanceTypeSelect;

    @FindBy(xpath = "//h2[text()='Instances']/following::md-select[@placeholder='Datacenter location'][1]")
    private WebElement datacenterLocationSelect;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//child::md-select[@placeholder='Committed usage']/md-select-value")
    private WebElement committedUsageSelect;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][not(@disabled)]")
    private WebElement addToEstimateButton;

    private static final String OPERATING_SYSTEM = "//md-option[@value='**']";
    private static final String VIRTUAL_MACHINE_CLASS = "//div[@aria-hidden='false']//md-option[@value='**']";
    private static final String MACHINE_TYPE = "//md-option[contains(@value,'**')]";
    private static final String DATACENTER_LOCATION = "//div[@aria-hidden='false']//md-option[@value='**']";
    private static final String COMMITTED_USAGE_PERIOD = "//div[@aria-hidden='false']//md-option[@value='**']";

    public InstancesForm(WebDriver driver) {
        super(driver);
    }

    /**
     * The scenario of filling the Instances form of Google Pricing Calculator
     *
     * @return GoogleCalculatorPageFormFiller page
     */
    public InstancesForm fillForm(Integer number, Instance instance) {
        numberOfInstances.sendKeys(number + "");

        operationSystemSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(OPERATING_SYSTEM, instance.getOperatingSystem())).click();

        virtualMachineClassSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(VIRTUAL_MACHINE_CLASS, instance.getMachineClass())).click();

        instanceTypeSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(MACHINE_TYPE, instance.getMachineType())).click();

        datacenterLocationSelect.click();
        WebElement locationFrankfurt = waitForElementBeClickable(StringUtils.useValueInString(DATACENTER_LOCATION, instance.getLocation().getValue()));
        clickOnElementJS(locationFrankfurt);

        moveScreenToAndClickOnElementJS(committedUsageSelect);
        waitForElementBeClickable(StringUtils.useValueInString(COMMITTED_USAGE_PERIOD, instance.getPeriod())).click();
        return this;
    }

    public GoogleCalculatorResultsBar addToEstimate() {
        addToEstimateButton.click();
        return new GoogleCalculatorResultsBar(driver);
    }

}
