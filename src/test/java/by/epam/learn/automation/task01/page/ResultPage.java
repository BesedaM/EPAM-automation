package by.epam.learn.automation.task01.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage  extends Page{

    public static final By RAW_TEXT_XPATH = By.xpath("//textarea");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRawPaste(){
        return waitForElementLocatedBy(driver, RAW_TEXT_XPATH);
    }

}
