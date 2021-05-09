package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.page.googlecloud.GoogleCloudHomePage;
import by.epam.learn.automation.task0304.service.InstanceCreator;
import by.epam.learn.automation.task0304.service.SoleTeenantNodeCreator;
import org.openqa.selenium.WebDriver;

public class CommonTestData {

    protected WebDriver driver = DriverSingleton.getDriver();

    protected ComputeEngineTab openComputeEngineTab(WebDriver driver) {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculatorLink()
                .goToPricingCalculatorHomePage()
                .openComputeEngineTab();
    }

    protected GoogleCalculatorResultsBar fillInstanceFormAndAddToEstimate(ComputeEngineTab computeEngineTab) {
        return computeEngineTab
                .instancesForm()
                .fillForm(InstanceCreator.getNumberOfInstances(), InstanceCreator.createInstance())
                .addToEstimate();
    }

    protected GoogleCalculatorResultsBar fillSoleTeenantNodeFormAndAddToEstimate(ComputeEngineTab computeEngineTab) {
        return computeEngineTab
                .soleTenantNodesForm()
                .fillForm(SoleTeenantNodeCreator.getNumberOfSoleTeenantNodes(), SoleTeenantNodeCreator.createNode())
                .addToEstimate();
    }

}
