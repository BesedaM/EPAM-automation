package by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab;

import by.epam.learn.automation.task0304.page.Page;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InstancesForm extends Page {

    private static final By NUMBER_OF_INSTANCES_INPUT = By.xpath("//label[contains(text(),'Number of instances')]/following-sibling::input[@name='quantity']");
    private static final String NUMBER_OF_INSTANCES = 4 + "";
    private static final By OS_SELECT = By.xpath("//label[text()='Operating System / Software']/following-sibling::md-select");
    private static final By FREE_OS = By.xpath("//md-option/child::div[contains(text(),'Free')]");
    private static final By VM_CLASS_SELECT = By.xpath("//md-select[@placeholder='VM Class']");
    private static final By REGULAR_VM_CLASS = By.xpath("//div[@aria-hidden='false']//child::md-option[@value='regular']");
    private static final By INSTANCE_TYPE_SELECT = By.xpath("//md-select[@placeholder='Instance type']");
    private static final By CONCRETE_INSTANCE_TYPE = By.xpath("//div[contains(text(),'e2-standard-8')]");

    private static final By DATACENTER_LOCATION_SELECT = By.xpath("//h2[text()='Instances']/following::md-select[@placeholder='Datacenter location'][1]");
    private static final By DATACENTER_LOCATION_IOWA = By.xpath("//div[@aria-hidden='false']/descendant::div[contains(text(),'Iowa')]/parent::md-option");
    private static final By COMMITTED_USAGE_SELECT = By.xpath("//form[@name='ComputeEngineForm']//child::md-select[@placeholder='Committed usage']/md-select-value");
    private static final By COMMITTED_USAGE_1_YEAR = By.xpath("//div[@aria-hidden='false']//div[contains(text(),'1 Year')]/parent::md-option");
    private static final By ADD_TO_ESTIMATE_BUTTON = By.xpath("//button[@aria-label='Add to Estimate'][not(@disabled)]");


    public InstancesForm(WebDriver driver) {
        super(driver);
    }


    /**
     * The scenario of filling the Instances form of Google Pricing Calculator
     *
     * @return GoogleCalculatorPageFormFiller page
     */
    public InstancesForm fillForm() {
        waitForElementLocatedBy(driver, NUMBER_OF_INSTANCES_INPUT).sendKeys(NUMBER_OF_INSTANCES);

        selectWebElement(OS_SELECT);
        selectWebElement(FREE_OS);

        selectWebElement(VM_CLASS_SELECT);
        selectWebElement(REGULAR_VM_CLASS);

        selectWebElement(INSTANCE_TYPE_SELECT);
        selectWebElement(CONCRETE_INSTANCE_TYPE);

        selectWebElement(DATACENTER_LOCATION_SELECT);
        selectWebElement(DATACENTER_LOCATION_IOWA);

        selectWebElement(COMMITTED_USAGE_SELECT);
        selectWebElement(COMMITTED_USAGE_1_YEAR);

        return this;
    }

    public GoogleCalculatorResults addToEstimate() {
        selectWebElement(ADD_TO_ESTIMATE_BUTTON);
        return new GoogleCalculatorResults(driver);
    }

}
