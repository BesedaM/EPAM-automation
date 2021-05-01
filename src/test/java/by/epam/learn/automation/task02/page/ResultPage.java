package by.epam.learn.automation.task02.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage  extends Page {

    private static final By RAW_TEXT_XPATH = By.xpath("//textarea");
    private static final By PASTE_NAME_XPATH = By.xpath("//div[@class='post-view']/descendant::h1");
    private static final By PASTE_DATA_CONTAINER_XPATH = By.xpath("//ol");
    private static final String ATTRIBUTE_WITH_PROPERTY = "class";
    private static final String PROPERTY_VALUE = "bash";


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRawPaste(){
        return waitForElementLocatedBy(driver, RAW_TEXT_XPATH);
    }

    public WebElement getPasteName(){
        return waitForElementLocatedBy(driver, PASTE_NAME_XPATH);
    }

    public boolean pasteSyntaxStyleIsBash(){
        return waitForElementLocatedBy(driver, PASTE_DATA_CONTAINER_XPATH).getAttribute(ATTRIBUTE_WITH_PROPERTY).equals(PROPERTY_VALUE);
    }
}
