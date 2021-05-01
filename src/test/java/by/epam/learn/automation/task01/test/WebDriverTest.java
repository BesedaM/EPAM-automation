package by.epam.learn.automation.task01.test;

import by.epam.learn.automation.task01.page.PastebinHomePage;
import by.epam.learn.automation.task01.page.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("User-Agent=\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36\"");
        options.addArguments("Accept=\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\"");
        options.addArguments("Content-Type=\"text/html; charset=utf-8\"");
        options.addArguments("Content-Language=\"ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3\"");


        driver = new ChromeDriver(options);

    }

    @Test
    public void createPasteTest() {
        String text = "Hello from WebDriver";

        PastebinHomePage homePage = new PastebinHomePage(driver);


        ResultPage resultPage = null;
        resultPage = homePage.openPage()
                .fillFormAndSubmit(text);

        Assert.assertEquals(resultPage.getRawPaste().getText(), text);
    }


    @AfterMethod(alwaysRun = true)
    private void browserClose() {
        driver.quit();
        driver = null;
    }

}
