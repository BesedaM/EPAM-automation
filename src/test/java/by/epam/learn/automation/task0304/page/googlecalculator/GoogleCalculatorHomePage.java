package by.epam.learn.automation.task0304.page.googlecalculator;

import by.epam.learn.automation.task0304.page.Page;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleCalculatorHomePage extends Page {

    private static final By COMPUTE_ENGINE_TAB = By.xpath("//md-tab-item/div[@title='Compute Engine']");

    public GoogleCalculatorHomePage(WebDriver driver) {
        super(driver);
        switchToMainFrame(driver);
    }

    public static void switchToMainFrame(WebDriver driver) {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
    }

    public ComputeEngineTab openComputeEngineTab() {
        selectWebElement(COMPUTE_ENGINE_TAB);
        return new ComputeEngineTab(driver);
    }

}
