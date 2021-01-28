package Daniel_BObaniel;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.layout.Priority;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestExecution_TC2_3_TestNG {

    WebDriver driver;
    WebElement usernameField, passwordField, loginButton, userSettingsLink, logoutLink, messageLink,
            linkToPostLinkInMessage, linkTextInputField, linkInputField, saveButton, sendMessageButton;
    String password = "UserUser";

    @BeforeClass
    public void setUpBrowserAndGoToEnvironment() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //GOES TO TEST ENVIRONMENT
        driver.get("https://login2.nextbasecrm.com");
    }

    @AfterClass
    public void tearDownWindow() {
        sleep(3);
        driver.quit();
    }


    @BeforeMethod
    public void logIn() {
        usernameField = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameField.clear();
        usernameField.sendKeys("hr51@cybertekschool.com");

        sleep(1);
        passwordField = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordField.sendKeys(password);

        sleep(1);
        loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
    }

    @AfterMethod
    public void logOut() {
        //CANT FIND LOGOUT BECAUSE THE INPUT FIELD ISNT CLEAR AND HAS TEXT IN IT.
        userSettingsLink = driver.findElement(By.xpath("//span[@id='user-name']"));
        userSettingsLink.click();

        sleep(3);
        logoutLink = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutLink.click();

        sleep(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();



    }


    @Test (priority = 3)
    public void TestA() {
        messageLink = driver.findElement(By.xpath("//span[.='Message']"));
        messageLink.click();
        sleep(2);

        linkToPostLinkInMessage = xPath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']");
        linkToPostLinkInMessage.click();

        sleep(2);
        Assert.assertTrue(xPath("//div[@class='bx-core-adm-dialog-head']").isDisplayed());    //div[@class='bx-core-adm-dialog-head']
        sleep(2);

        linkTextInputField = xPath("//input[@id='linkidPostFormLHE_blogPostForm-text']");
        linkTextInputField.sendKeys("GOOGLE1");

        linkInputField = xPath("//input[@id='linkidPostFormLHE_blogPostForm-href']");
        linkInputField.sendKeys("https://www.google.com");

        saveButton = xPath("//input[@id='undefined']");
        saveButton.click();



        /*sendMessageButton = xPath("//button[@id='blog-submit-button-save']");
        sendMessageButton.click();*/

    }

    @Test (priority = 1)
    public void TestG() {

        System.out.println("Test for inputing into the iFrame input field");
        messageLink = driver.findElement(By.xpath("//span[.='Message']"));
        messageLink.click();
        sleep(2);

        WebElement mainIframe = xPath("//iFrame[@class='bx-editor-iframe']");
        driver.switchTo().frame(mainIframe);

        sleep(1);
        xPath("//body[@contenteditable='true']").sendKeys("HelloWorld");

        driver.switchTo().parentFrame();

    }

    @Test (priority = 2)
    public void TestZ() {
        System.out.println("This runs first! Alphabetically");
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement xPath(String xpathString) {
        return driver.findElement(By.xpath(xpathString));

    }


}
