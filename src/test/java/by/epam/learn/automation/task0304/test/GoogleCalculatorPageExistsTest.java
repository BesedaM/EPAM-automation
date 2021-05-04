package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorHomePage;
import by.epam.learn.automation.task0304.page.googlecloud.GoogleCloudHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCalculatorPageExistsTest extends CommonTestData{

    private GoogleCalculatorHomePage calculatorHomePage;

    @BeforeClass(alwaysRun = true)
    public void executeScenario() {
        startWebDriver();
        calculatorHomePage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculatorLink()
                .goToPricingCalculatorHomePage();
    }

    @Test
    public void computeEngineTabExists(){
        Assert.assertEquals(calculatorHomePage.openComputeEngineTab().getClass().getSimpleName(),
                "ComputeEngineTab");
    }

    @AfterClass(alwaysRun = true)
    private void browserClose() {
        DriverSingleton.closeDriver();
    }

}
