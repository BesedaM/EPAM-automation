package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.page.AbstractPage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstancesForm extends AbstractPage {

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input[@name='quantity']")
    private WebElement numberOfInstances;

    private static final String NUMBER_OF_INSTANCES = 4 + "";

    @FindBy(xpath = "//label[text()='Operating System / Software']/following-sibling::md-select")
    private WebElement operationSystemSelect;

    @FindBy(xpath = "//md-option/child::div[contains(text(),'Free')]")
    private WebElement operatingSystemType;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement virtualMachineClassSelect;

    @FindBy(xpath = "//div[@aria-hidden='false']//child::md-option[@value='regular']")
    private WebElement virtualMachineClassRegular;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement instanceTypeSelect;

    private static final By CONCRETE_INSTANCE_TYPE = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-E2-STANDARD-8']");

    @FindBy(xpath = "//h2[text()='Instances']/following::md-select[@placeholder='Datacenter location'][1]")
    private WebElement datacenterLocationSelect;

    @FindBy(xpath = "//div[@aria-hidden='false']/descendant::div[contains(text(),'Iowa')]/parent::md-option")
    private WebElement customDatacenterLocation;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//child::md-select[@placeholder='Committed usage']/md-select-value")
    private WebElement committedUsageSelect;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[contains(text(),'1 Year')]/parent::md-option")
    private WebElement concreteCommittedUsagePeriod;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][not(@disabled)]")
    private WebElement addToEstimateButton;


    public InstancesForm(WebDriver driver) {
        super(driver);
    }


    /**
     * The scenario of filling the Instances form of Google Pricing Calculator
     *
     * @return GoogleCalculatorPageFormFiller page
     */
    public InstancesForm fillForm() {
        numberOfInstances.sendKeys(NUMBER_OF_INSTANCES);

        operationSystemSelect.click();
        operatingSystemType.click();

        virtualMachineClassSelect.click();
        virtualMachineClassRegular.click();

        instanceTypeSelect.click();
        clickOnElement(CONCRETE_INSTANCE_TYPE);

        datacenterLocationSelect.click();
        customDatacenterLocation.click();

        moveScreenToAndClickOnElement(committedUsageSelect);
        concreteCommittedUsagePeriod.click();

        return this;
    }

    public GoogleCalculatorResultsBar addToEstimate() {
        addToEstimateButton.click();
        return new GoogleCalculatorResultsBar(driver);
    }

}
