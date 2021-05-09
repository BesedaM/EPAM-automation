package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.ContactsForm;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorHomePage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.page.mail.YopMailGeneratorPage;
import by.epam.learn.automation.task0304.util.PageUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCalculatorEmailTest extends CommonTestData {

    private String totalEstimatedCostFromCalculator;
    private String totalEstimatedCostFromEmail;

    @BeforeClass(alwaysRun = true)
    public void executeScenario() {
        ComputeEngineTab computeEngineTab = openComputeEngineTab(driver);
        GoogleCalculatorResultsBar resultsBar = fillInstanceFormAndAddToEstimate(computeEngineTab);
        fillSoleTeenantNodeFormAndAddToEstimate(computeEngineTab);

        String calculatorWindowName = driver.getWindowHandle();

        totalEstimatedCostFromCalculator = resultsBar.getTotalEstimatedMonthlyCost().getText();
        logger.info("trying to send results data to email");
        ContactsForm contactsForm
                = resultsBar.pressEmailEstimate();

        logger.info("opening yopmail generator page to get the email address");
        YopMailGeneratorPage emailGeneratorPage
                = new YopMailGeneratorPage(driver)
                .openPage();
        String emailGeneratorWindowName = driver.getWindowHandle();
        String emailAddress = emailGeneratorPage.getEmail();

        logger.info("filling in the form the email address and sending data to the mail box");
        PageUtils.navigateToPage(driver, calculatorWindowName);
        GoogleCalculatorHomePage.switchToMainFrame(driver);
        contactsForm
                .enterEmail(emailAddress)
                .sendEmail();

        logger.info("go to mail box and waiting for the letter to come");
        PageUtils.navigateToPage(driver, emailGeneratorWindowName);
        totalEstimatedCostFromEmail = emailGeneratorPage
                .goToEmailPage()
                .getEstimatedMonthlyCostResult()
                .getText();
    }

    @Test
    public void compareResultsWithEmailTotalEstimatedCost() {
        Assert.assertTrue(totalEstimatedCostFromCalculator.contains(totalEstimatedCostFromEmail));
    }

    @AfterClass(alwaysRun = true)
    private void browserClose() {
        DriverSingleton.closeDriver();
    }

}
