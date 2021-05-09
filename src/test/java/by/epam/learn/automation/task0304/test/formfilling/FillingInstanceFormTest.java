package by.epam.learn.automation.task0304.test.formfilling;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.model.Instance;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.service.InstanceCreator;
import by.epam.learn.automation.task0304.test.CommonTestData;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FillingInstanceFormTest extends CommonTestData {

    private GoogleCalculatorResultsBar resultsPage;
    private Instance instance;

    @BeforeSuite
    public void goToCalculatorPage() {
        openComputeEngineTab(driver);
    }

    @BeforeClass
    public void createInstanceAndFillInstanceForm() {
        instance = InstanceCreator.createInstance();
        resultsPage = fillInstanceFormAndAddToEstimate(new ComputeEngineTab(driver));
    }

    @Test
    public void instanceVmClassTest() {
        Assert.assertTrue(resultsPage.getComputeEngineVmClass().getText()
                .contains(instance.getMachineClass()));
    }

    @Test
    public void instanceTypeTest() {
        Assert.assertTrue(resultsPage.getComputeEngineInstanceType().getText()
                .contains(instance.getMachineType().toLowerCase()));
    }

    @Test
    public void instanceRegionTest() {
        System.out.println(resultsPage.getComputeEngineRegion().getText().toLowerCase());
        System.out.println(instance.getLocation().name().toLowerCase());
        Assert.assertTrue(resultsPage.getComputeEngineRegion().getText().toLowerCase()
                .contains(instance.getLocation().name().toLowerCase()));
    }

    @Test
    public void instanceCommitmentTermTest() {
        Assert.assertTrue(resultsPage.getComputeEngineCommitmentTerm().getText()
                .contains(instance.getPeriod()));
    }

    @AfterSuite
    public void closeWebDriver() {
        DriverSingleton.closeDriver();
    }
}
