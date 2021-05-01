package by.epam.learn.automation.task02.test;

import by.epam.learn.automation.task02.page.PastebinHomePage;
import by.epam.learn.automation.task02.page.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverTest {

    private WebDriver driver;

    private String TEXT = "git config --global user.name  \"New Sheriff in Town\"+\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")+\n"
            + "git push origin master --force";
    private String PASTE_NAME = "how to gain dominance among developers";

    private ResultPage resultPage;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();

        PastebinHomePage homePage = new PastebinHomePage(driver);
        try {
            resultPage = homePage.openPage()
                    .fillFormAndSubmit(TEXT, PASTE_NAME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void pasteNameTest() {
        Assert.assertEquals(resultPage.getPasteName().getText(), PASTE_NAME);
    }

    @Test
    public void bashSyntaxTest() {
        Assert.assertTrue(resultPage.pasteSyntaxStyleIsBash());
    }

    @Test
    public void pasteTextTest() {
        Assert.assertEquals(resultPage.getRawPaste().getText(), TEXT);
    }


    @AfterClass(alwaysRun = true)
    private void browserClose() {
        driver.quit();
        driver = null;
    }

}
