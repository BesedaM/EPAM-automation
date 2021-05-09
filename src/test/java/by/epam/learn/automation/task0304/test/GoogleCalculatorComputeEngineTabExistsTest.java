package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCalculatorComputeEngineTabExistsTest extends CommonTestData {

    private ComputeEngineTab computeEngineTab;

    @BeforeClass(alwaysRun = true)
    public void executeScenario() {
        computeEngineTab = openComputeEngineTab(driver);
    }

    @Test
    public void computeEngineTabExists() {
        Assert.assertEquals(computeEngineTab.getClass().getSimpleName(),
                "ComputeEngineTab");
    }

    @AfterClass(alwaysRun = true)
    private void browserClose() {
        DriverSingleton.closeDriver();
    }

}
