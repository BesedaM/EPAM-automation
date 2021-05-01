package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResults;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import by.epam.learn.automation.task0304.page.googlecloud.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleCalculatorTest {

    private GoogleCalculatorResults resultsPage;
    private WebDriver driver;

    private String EXPECTED_VM_CLASS = "regular";
    private String EXPECTED_INSTANCE_TYPE_01 = "e2-standard-8";
    private String EXPECTED_INSTANCE_TYPE_02 = "n1-node-96-624";
    private String EXPECTED_REGION = "Iowa";
    private String EXPECTED_COMMITMENT_TERM = "1 Year";
    private String EXPECTED_SSD_SPACE = "24x375";

    @BeforeClass(alwaysRun = true)
    public void executeScenario() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ComputeEngineTab computeEngineTab = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculatorLink()
                .goToPricingCalculatorHomePage()
                .openComputeEngineTab();

        computeEngineTab
                .instancesForm()
                .fillForm()
                .addToEstimate();

        resultsPage = computeEngineTab
                .soleTenantNodesForm()
                .fillForm()
                .addToEstimate();

        GoogleCalculatorDataProvider.initDataProviders(resultsPage);
    }

    @Test
    public void vmClassTest() {
        Assert.assertTrue(resultsPage.getVmClass().getText().contains(EXPECTED_VM_CLASS));
    }

    @Test(dataProviderClass = GoogleCalculatorDataProvider.class, dataProvider = "instance_types")
    public void instanceTypesTest(WebElement element) {
        Assert.assertTrue(element.getText().contains(EXPECTED_INSTANCE_TYPE_01) |
                element.getText().contains(EXPECTED_INSTANCE_TYPE_02));
    }

    @Test(dataProviderClass = GoogleCalculatorDataProvider.class, dataProvider = "regions")
    public void regionsTest(WebElement element) {
        Assert.assertTrue(element.getText().contains(EXPECTED_REGION));
    }

    @Test(dataProviderClass = GoogleCalculatorDataProvider.class, dataProvider = "commitment_terms")
    public void commitmentTermsTest(WebElement element) {
        Assert.assertTrue(element.getText().contains(EXPECTED_COMMITMENT_TERM));
    }

    @Test
    public void localSsdTest() {
        Assert.assertTrue(resultsPage.getLocalSsdSpace().getText().contains(EXPECTED_SSD_SPACE));
    }


    @AfterClass(alwaysRun = true)
    private void browserClose() {
        driver.quit();
        driver = null;
    }

}
