package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.page.googlecloud.GoogleCloudHomePage;
import by.epam.learn.automation.task0304.service.InstanceCreator;
import by.epam.learn.automation.task0304.service.SoleTeenantNodeCreator;
import by.epam.learn.automation.task0304.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonTestData {

    protected WebDriver driver = DriverSingleton.getDriver();
    protected Logger logger= LogManager.getLogger("INFO");

    protected ComputeEngineTab openComputeEngineTab(WebDriver driver) {
        logger.info("Opening Compute engine tab");
        return new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculatorLink()
                .goToPricingCalculatorHomePage()
                .openComputeEngineTab();
    }

    protected GoogleCalculatorResultsBar fillInstanceFormAndAddToEstimate(ComputeEngineTab computeEngineTab) {
        logger.info("filling 'Instance' form and adding data to estimate");
        return computeEngineTab
                .instancesForm()
                .fillForm(InstanceCreator.getNumberOfInstances(), InstanceCreator.createInstance())
                .addToEstimate();
    }

    protected GoogleCalculatorResultsBar fillSoleTeenantNodeFormAndAddToEstimate(ComputeEngineTab computeEngineTab) {
        logger.info("filling 'Sole-teenant node' form and adding data to estimate");
        return computeEngineTab
                .soleTenantNodesForm()
                .fillForm(SoleTeenantNodeCreator.getNumberOfSoleTeenantNodes(), SoleTeenantNodeCreator.createNode())
                .addToEstimate();
    }

}
