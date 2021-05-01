package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.page.googlecalculator.ContactsForm;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorHomePage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResults;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.page.googlecloud.GoogleCloudHomePage;
import by.epam.learn.automation.task0304.page.mail.YopMailGeneratorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleCalculatorEmailTest {

    private WebDriver driver;
    private String totalEstimatedCostFromCalculator;
    private String totalEstimatedCostFromEmail;

    @BeforeMethod(alwaysRun = true)
    public void executeScenario() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        GoogleCalculatorResults resultsTab = fillGoogleCalculatorFormScenario();
        String calculatorWindowName = driver.getWindowHandle();

        totalEstimatedCostFromCalculator = resultsTab.getTotalEstimatedMonthlyCost().getText();
        ContactsForm contactsForm
                = resultsTab.pressEmailEstimate();

        YopMailGeneratorPage mailGeneratorPage
                = new YopMailGeneratorPage(driver)
                .openPage();
        String emailGeneratorWindowName = driver.getWindowHandle();
        String email = mailGeneratorPage.getEmail();

        navigateToPage(calculatorWindowName);
        GoogleCalculatorHomePage.switchToMainFrame(driver);
        contactsForm
                .enterEmail(email)
                .sendEmail();

        navigateToPage(emailGeneratorWindowName);
        totalEstimatedCostFromEmail = mailGeneratorPage
                .goToEmailPage()
                .estimatedMonthlyCostResult()
                .getText();
    }

    private GoogleCalculatorResults fillGoogleCalculatorFormScenario() {
        ComputeEngineTab computeEngineTab = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculatorLink()
                .goToPricingCalculatorHomePage()
                .openComputeEngineTab();

        computeEngineTab
                .instancesForm()
                .fillForm()
                .addToEstimate();

        GoogleCalculatorResults resultsPage = computeEngineTab
                .soleTenantNodesForm()
                .fillForm()
                .addToEstimate();
        return resultsPage;
    }

    private void navigateToPage(String address){
        driver.switchTo().window(address);
    }

    @Test
    public void compareResultsWithEmailTotalEstimatedCost() {
        Assert.assertTrue(totalEstimatedCostFromCalculator.contains(totalEstimatedCostFromEmail));
    }


    @AfterMethod(alwaysRun = true)
    private void browserClose() {
        driver.quit();
        driver = null;
    }

}
