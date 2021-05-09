package by.epam.learn.automation.task0304.util;

import by.epam.learn.automation.task0304.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private static final String SCREENSHOT_ADDRESS = ".//target/screenshots/**.png";
    private static final String DATE_FORMAT = "uuuu-MM-dd_HH-mm-ss";
    private Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestFailure(ITestResult result) {
        this.saveScreenShot();
    }

    private void saveScreenShot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture,
                    new File(SCREENSHOT_ADDRESS.replace("**", this.getCurrentTimeAsString())));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return ZonedDateTime.now().format(formatter);
    }
}
