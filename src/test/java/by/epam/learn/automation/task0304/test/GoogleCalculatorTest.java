package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCalculatorTest extends CommonTestData {

    private GoogleCalculatorResultsBar resultsPage;

    private String EXPECTED_VM_CLASS = "regular";
    private String EXPECTED_INSTANCE_TYPE_COMPUTE_ENGINE = "e2-standard-8";
    private String EXPECTED_INSTANCE_TYPE_SOLE_TENANT = "n1-node-96-624";
    private String EXPECTED_REGION = "Iowa";
    private String EXPECTED_COMMITMENT_TERM = "1 Year";
    private String EXPECTED_SSD_SPACE = "24x375";

    @BeforeClass(alwaysRun = true)
    public void executeScenario() {
        startWebDriver();
        resultsPage = fillGoogleCalculatorForm();
    }

    @Test
    public void computeEngineVmClassTest() {
        Assert.assertTrue(resultsPage.getComputeEngineVmClass().getText().contains(EXPECTED_VM_CLASS));
    }

    @Test
    public void computeEngineInstanceTypeTest() {
        Assert.assertTrue(resultsPage.getComputeEngineInstanceType().getText()
                .contains(EXPECTED_INSTANCE_TYPE_COMPUTE_ENGINE));
    }

    @Test
    public void computeEngineRegionTest() {
        Assert.assertTrue(resultsPage.getComputeEngineRegion().getText()
                .contains(EXPECTED_REGION));
    }

    @Test
    public void computeEngineCommitmentTermTest() {
        Assert.assertTrue(resultsPage.getComputeEngineCommitmentTerm().getText()
                .contains(EXPECTED_COMMITMENT_TERM));
    }

    @Test
    public void soleTenantInstanceTypeTest() {
        Assert.assertTrue(resultsPage.getSoleTenantInstanceType().getText()
                .contains(EXPECTED_INSTANCE_TYPE_SOLE_TENANT));
    }

    @Test
    public void soleTenantRegionTest() {
        Assert.assertTrue(resultsPage.getSoleTenantRegion().getText()
                .contains(EXPECTED_REGION));
    }

    @Test
    public void soleTenantCommitmentTermTest() {
        Assert.assertTrue(resultsPage.getSoleTenantCommitmentTerm().getText()
                .contains(EXPECTED_COMMITMENT_TERM));
    }

    @Test
    public void soleTenantLocalSsdTest() {
        Assert.assertTrue(resultsPage.getSoleTenantLocalSsdSpace().getText()
                .contains(EXPECTED_SSD_SPACE));
    }

    @AfterClass(alwaysRun = true)
    private void browserClose() {
        DriverSingleton.closeDriver();
    }
}
