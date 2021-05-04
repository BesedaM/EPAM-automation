package by.epam.learn.automation.task0304.page.googlecloud;

import by.epam.learn.automation.task0304.page.AbstractPage;
import by.epam.learn.automation.task0304.page.googlecalculator.GoogleCalculatorHomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String GOOGLE_CLOUD_HOME_PAGE = "https://cloud.google.com/";
    private static final String PRICING_CALCULATOR_FULL_NAME = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchButton;

    @FindBy(xpath="//div[@class='gs-title']/descendant::*[text()='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement priceCalculatorLink;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(GOOGLE_CLOUD_HOME_PAGE);
        return this;
    }

    public GoogleCloudHomePage searchForPricingCalculatorLink() {
        searchButton.click();
        searchButton.sendKeys(PRICING_CALCULATOR_FULL_NAME, Keys.ENTER);
        return this;
    }

    public GoogleCalculatorHomePage goToPricingCalculatorHomePage(){
        priceCalculatorLink.click();
        return new GoogleCalculatorHomePage(driver);
    }

}
