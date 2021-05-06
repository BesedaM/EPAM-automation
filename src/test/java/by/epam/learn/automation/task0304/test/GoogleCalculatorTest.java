package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.model.ComputeNode;
import by.epam.learn.automation.task0304.model.Instance;
import by.epam.learn.automation.task0304.model.SoleTenantNode;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCalculatorTest extends CommonTestData {

    private GoogleCalculatorResultsBar resultsPage;

    private Instance.MachineClass EXPECTED_VM_CLASS = Instance.MachineClass.REGULAR;
    private Instance.MachineType EXPECTED_INSTANCE_TYPE_COMPUTE_ENGINE = Instance.MachineType.E2_STANDARD_8;
    private ComputeNode.DatacenterLocation EXPECTED_REGION = ComputeNode.DatacenterLocation.IOWA;
    private ComputeNode.CommittedUsagePeriod EXPECTED_COMMITMENT_TERM = ComputeNode.CommittedUsagePeriod.ONE_YEAR;
    private SoleTenantNode.LocalSsdNumber SSD_NUMBER = SoleTenantNode.LocalSsdNumber.MAX_NUMBER;

    @BeforeClass(alwaysRun = true)
    public void executeScenario() {
        startWebDriver();
        resultsPage = fillGoogleCalculatorForm();
    }

    @Test
    public void instanceVmClassTest() {
        Assert.assertTrue(resultsPage.getComputeEngineVmClass().getText()
                .contains(EXPECTED_VM_CLASS.getValue()));
    }

    @Test
    public void instanceTypeTest() {
        Assert.assertTrue(resultsPage.getComputeEngineInstanceType().getText()
                .contains(EXPECTED_INSTANCE_TYPE_COMPUTE_ENGINE.getValue().toLowerCase()));
    }

    @Test
    public void instanceRegionTest() {
        Assert.assertTrue(resultsPage.getComputeEngineRegion().getText().toLowerCase()
                .contains(EXPECTED_REGION.name().toLowerCase()));
    }

    @Test
    public void instanceCommitmentTermTest() {
        Assert.assertTrue(resultsPage.getComputeEngineCommitmentTerm().getText()
                .contains(EXPECTED_COMMITMENT_TERM.getPeriod() + ""));
    }

    @Test
    public void soleTenantRegionTest() {
        Assert.assertTrue(resultsPage.getSoleTenantRegion().getText().toLowerCase()
                .contains(EXPECTED_REGION.name().toLowerCase()));
    }

    @Test
    public void soleTenantCommitmentTermTest() {
        Assert.assertTrue(resultsPage.getSoleTenantCommitmentTerm().getText()
                .contains(EXPECTED_COMMITMENT_TERM.getPeriod() + ""));
    }

    @Test
    public void soleTenantLocalSsdTest() {
        Assert.assertTrue(resultsPage.getSoleTenantLocalSsdSpace().getText()
                .contains(SSD_NUMBER.getNumber() + ""));
    }

    @AfterClass(alwaysRun = true)
    private void browserClose() {
        DriverSingleton.closeDriver();
    }
}
