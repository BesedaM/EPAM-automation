package by.epam.learn.automation.task0304.test;

import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorResults;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.util.List;

public class GoogleCalculatorDataProvider {

    private static GoogleCalculatorResults page;

    private GoogleCalculatorDataProvider() {
    }

    public static void initDataProviders(GoogleCalculatorResults pageResultsChecker) {
        page = pageResultsChecker;
    }

    @DataProvider(name = "instance_types")
    public static Object[][] getInstanceTypes() {
        List<WebElement> instanceTypeResult = page.getInstanceTypes();
        Object[][] data = new Object[instanceTypeResult.size()][1];
        for (int i = 0; i < instanceTypeResult.size(); i++) {
            data[i][0] = instanceTypeResult.get(i);
        }
        return data;
    }

    @DataProvider(name = "regions")
    public static Object[][] getRegions() {
        List<WebElement> regions = page.getRegions();
        Object[][] data = new Object[regions.size()][1];
        for (int i = 0; i < regions.size(); i++) {
            data[i][0] = regions.get(i);
        }
        return data;
    }

    @DataProvider(name = "commitment_terms")
    public static Object[][] getCommitmentTerms() {
        List<WebElement> commitmentTerms = page.getCommitmentTerms();
        Object[][] data = new Object[commitmentTerms.size()][1];
        for (int i = 0; i < commitmentTerms.size(); i++) {
            data[i][0] = commitmentTerms.get(i);
        }
        return data;
    }
}
