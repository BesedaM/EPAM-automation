package by.epam.learn.automation.task0304.test.formfilling;

import by.epam.learn.automation.task0304.model.SoleTenantNode;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.service.SoleTeenantNodeCreator;
import by.epam.learn.automation.task0304.test.CommonTestData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FillingSoleTenantNodeFormTest extends CommonTestData {

    private GoogleCalculatorResultsBar resultsPage;
    private SoleTenantNode node;

    @BeforeClass
    public void createNodeAndFillNodeForm() {
        node = SoleTeenantNodeCreator.createNode();
        resultsPage = fillSoleTeenantNodeFormAndAddToEstimate(new ComputeEngineTab(driver));
    }

    @Test
    public void soleTenantRegionTest() {
        Assert.assertTrue(resultsPage.getSoleTenantRegion().getText().toLowerCase()
                .contains(node.getLocation().nameToLowerCase()));
    }

    @Test
    public void soleTenantCommitmentTermTest() {
        Assert.assertTrue(resultsPage.getSoleTenantCommitmentTerm().getText()
                .contains(node.getPeriod()));
    }

    @Test(timeOut = 5)
    public void soleTenantLocalSsdTest() {
        Assert.assertTrue(resultsPage.getSoleTenantLocalSsdSpace().getText()
                .contains(node.getLocalSsdNumber()));

    }
}
