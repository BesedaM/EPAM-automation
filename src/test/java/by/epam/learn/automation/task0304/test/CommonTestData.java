package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.page.googlecloud.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;

public class CommonTestData {

    protected WebDriver driver;

    protected void startWebDriver() {
        driver = DriverSingleton.getDriver();
    }

    protected GoogleCalculatorResultsBar fillGoogleCalculatorForm() {
        ComputeEngineTab computeEngineTab = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculatorLink()
                .goToPricingCalculatorHomePage()
                .openComputeEngineTab();

        computeEngineTab
                .instancesForm()
                .fillForm()
                .addToEstimate();

        return computeEngineTab
                .soleTenantNodesForm()
                .fillForm()
                .addToEstimate();
    }

}
