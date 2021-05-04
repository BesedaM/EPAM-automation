package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import by.epam.learn.automation.task0304.page.googlecalculator.ContactsForm;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorHomePage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResultsBar;
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
        startWebDriver();

        GoogleCalculatorResultsBar resultsTab = fillGoogleCalculatorForm();
        String calculatorWindowName = driver.getWindowHandle();

        totalEstimatedCostFromCalculator = resultsTab.getTotalEstimatedMonthlyCost().getText();
        ContactsForm contactsForm
                = resultsTab.pressEmailEstimate();

        YopMailGeneratorPage emailGeneratorPage
                = new YopMailGeneratorPage(driver)
                .openPage();
        String emailGeneratorWindowName = driver.getWindowHandle();
        String emailAddress = emailGeneratorPage.getEmail();

        PageUtils.navigateToPage(driver, calculatorWindowName);
        GoogleCalculatorHomePage.switchToMainFrame(driver);
        contactsForm
                .enterEmail(emailAddress)
                .sendEmail();

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
