package by.epam.learn.automation.task0304.page.googlecloud;

import by.epam.learn.automation.task0304.page.Page;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCloudHomePage extends Page {

    private static final String GOOGLE_CLOUD_HOME_PAGE = "https://cloud.google.com/";
    private static final By SEARCH_BUTTON = By.xpath("//input[@name='q']");
    private static final String PRICING_CALCULATOR_FULL_NAME = "Google Cloud Platform Pricing Calculator";
    private static final By PRICE_CALCULATOR_LINK = By.xpath("//div[@class='gs-title']/descendant::*[text()='Google Cloud Platform Pricing Calculator']/parent::a");


    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(GOOGLE_CLOUD_HOME_PAGE);
        return this;
    }

    public GoogleCloudHomePage searchForPricingCalculatorLink() {
        WebElement searchButton = waitForElementLocatedBy(driver, SEARCH_BUTTON);
        searchButton.click();
        searchButton.sendKeys(PRICING_CALCULATOR_FULL_NAME, Keys.ENTER);
        return this;
    }

    public GoogleCalculatorHomePage goToPricingCalculatorHomePage(){
        waitForElementLocatedBy(driver, PRICE_CALCULATOR_LINK).click();
        return new GoogleCalculatorHomePage(driver);
    }

}
