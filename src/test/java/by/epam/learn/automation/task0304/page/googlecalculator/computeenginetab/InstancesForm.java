package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.model.ComputeNode;
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

    private static final String NUMBER_OF_INSTANCES = 4 + "";
    private static final String OPERATING_SYSTEM = "//md-option[@value='**']";
    private static final String VIRTUAL_MACHINE_CLASS = "//div[@aria-hidden='false']//md-option[@value='**']";
    private static final String MACHINE_TYPE = "//md-option[contains(@value,'**')]";
    private static final String DATACENTER_LOCATION = "//div[@aria-hidden='false']//md-option[@value='**']";
    private static final String COMMITTED_USAGE_PERIOD = "//div[@aria-hidden='false']//md-option[@value='**']";

    private Instance instance;

    public InstancesForm(WebDriver driver) {
        super(driver);
        instance = new Instance();
        instance.setMachineClass(Instance.MachineClass.REGULAR);
        instance.setMachineType(Instance.MachineType.E2_STANDARD_8);
        instance.setOperatingSystem(Instance.OperatingSystem.FREE);
        instance.setLocation(ComputeNode.DatacenterLocation.IOWA);
        instance.setPeriod(ComputeNode.CommittedUsagePeriod.ONE_YEAR);
    }


    /**
     * The scenario of filling the Instances form of Google Pricing Calculator
     *
     * @return GoogleCalculatorPageFormFiller page
     */
    public InstancesForm fillForm() {
        numberOfInstances.sendKeys(NUMBER_OF_INSTANCES);

        operationSystemSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(OPERATING_SYSTEM,instance.getOperatingSystem())).click();

        virtualMachineClassSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(VIRTUAL_MACHINE_CLASS,instance.getMachineClass())).click();

        instanceTypeSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(MACHINE_TYPE,instance.getMachineType())).click();

        datacenterLocationSelect.click();
        waitForElementBeClickable(StringUtils.useValueInString(DATACENTER_LOCATION,instance.getLocation())).click();

        moveScreenToAndClickOnElement(committedUsageSelect);
        waitForElementBeClickable(StringUtils.useValueInString(COMMITTED_USAGE_PERIOD,instance.getPeriod()+"")).click();
        return this;
    }

    public GoogleCalculatorResultsBar addToEstimate() {
        addToEstimateButton.click();
        return new GoogleCalculatorResultsBar(driver);
    }

}
