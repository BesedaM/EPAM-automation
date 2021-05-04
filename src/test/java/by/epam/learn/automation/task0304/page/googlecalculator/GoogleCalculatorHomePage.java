package by.epam.learn.automation.task0304.page.googlecalculator;

import by.epam.learn.automation.task0304.page.AbstractPage;
import by.epam.learn.automation.task0304.page.googlecalculator.computeenginetab.ComputeEngineTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCalculatorHomePage extends AbstractPage {

    private static final int OUTER_FRAME_INDEX = 0;
    private static final String MAINFRAME = "myFrame";

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineTab;

    public GoogleCalculatorHomePage(WebDriver driver) {
        super(driver);
        switchToMainFrame(driver);
    }

    public static void switchToMainFrame(WebDriver driver) {
        driver.switchTo().frame(OUTER_FRAME_INDEX);
        driver.switchTo().frame(MAINFRAME);
    }

    public ComputeEngineTab openComputeEngineTab() {
        computeEngineTab.click();
        return new ComputeEngineTab(driver);
    }

}
