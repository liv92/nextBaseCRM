package Daniel_BObaniel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestExecution_US2_TC3 {

    public WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://login2.nextbasecrm.com");
    }


    @BeforeMethod
    public void logIn() {
        String username = "hr51@cybertekschool.com";
        String password = "UserUser";

        WebElement usernameField = findElementXpath("//input[@name='USER_LOGIN']");
        sleep(1);
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement passwordField = findElementXpath("//input[@name='USER_PASSWORD']");
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton = findElementXpath("//input[@class='login-btn']");
        loginButton.click();

    }

    @Test
    public void test1() {
        //========================================================================
        //After logging in, click the "Message" link/module
        WebElement messageModule = findElementXpath("//span[@id='feed-add-post-form-tab-message']");
        sleep(1);
        messageModule.click();

        //========================================================================
        //Click on the button that looks like a chain-link.. thats the "link" option button
        WebElement attachALink = findElementXpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']");
        attachALink.click();
        Assert.assertTrue(findElementXpath("//span[.='Link']").isDisplayed(),"ELEMENT NOT FOUND");


        //========================================================================
        //Put in the link text and the actualURL that you want the link that you create to go to.
        String textOfLink = "Go to google";
        String URL = "https://www.google.com";

        WebElement linkTextInputField = findElementXpath("//input[@id='linkidPostFormLHE_blogPostForm-text']");
        linkTextInputField.sendKeys(textOfLink);

        WebElement linkURLInputField = findElementXpath("//input[@id='linkidPostFormLHE_blogPostForm-href']");
        linkURLInputField.sendKeys(URL);

        //========================================================================
        //Click on "Save"
        WebElement saveButton = findElementXpath("//input[@id='undefined']");
        saveButton.click();

        WebElement cancelButton = findElementXpath("//button[@id='blog-submit-button-cancel']");
        cancelButton.click();

    }


    @AfterMethod
    public void logOut() {
        WebElement userEmailForLogout = findElementXpath("//span[@class='user-name']");
        userEmailForLogout.click();

        sleep(1);
        WebElement logoutLink = findElementXpath("//span[.='Log out']");
        logoutLink.click();

        sleep(1);
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle,"pageTitle is "+actualTitle+". We expected "+ expectedTitle);

    }

    @AfterClass
    public void tearDownBrowser() {
        sleep(2);
        driver.close();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement findElementXpath(String xPathString) {
        WebElement webElement = driver.findElement(By.xpath(xPathString));
        return webElement;
    }

}
