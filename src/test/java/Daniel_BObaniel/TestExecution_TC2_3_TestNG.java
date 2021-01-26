package Daniel_BObaniel;

import io.github.bonigarcia.wdm.WebDriverManager;
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
            linkToPostLinkInMessage, linkTextInputField, linkInputField, saveButton , sendMessageButton;
    String password = "UserUser";

    @BeforeClass
    public void setUpBrowserAndGoToEnvironment() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //GOES TO TEST ENVIRONMENT
        driver.get("https://login2.nextbasecrm.com");
    }

    @AfterClass
    public void tearDownWindow() {
        sleep();
        driver.quit();
    }


    @BeforeMethod
    public void logIn() {
        usernameField = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameField.clear();
        usernameField.sendKeys("hr51@cybertekschool.com");

        sleep();
        passwordField = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordField.sendKeys(password);

        sleep();
        loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
    }

    @AfterMethod
    public void logOut() {
        //CANT FIND LOGOUT BECAUSE THE INPUT FIELD ISNT CLEAR AND HAS TEXT IN IT.
        userSettingsLink = driver.findElement(By.xpath("//span[@id='user-name']"));
        userSettingsLink.click();

        sleep();
        logoutLink = driver.findElement(By.xpath("//span[.='Log out']"));
        logoutLink.click();

    }


    @Test
    public void TestZ() {
        messageLink = driver.findElement(By.xpath("//span[.='Message']"));
        messageLink.click();
        sleep();

        linkToPostLinkInMessage =  xPath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']");
        linkToPostLinkInMessage.click();

        sleep();
        Assert.assertTrue(xPath("//div[@class='bx-core-adm-dialog-head']").isDisplayed());    //div[@class='bx-core-adm-dialog-head']
        sleep();

        linkTextInputField = xPath("//input[@id='linkidPostFormLHE_blogPostForm-text']");
        linkTextInputField.sendKeys("GOOGLE1");

        linkInputField = xPath("//input[@id='linkidPostFormLHE_blogPostForm-href']");
        linkInputField.sendKeys("https://www.google.com");

        saveButton = xPath("//input[@id='undefined']");
        saveButton.click();



        /*sendMessageButton = xPath("//button[@id='blog-submit-button-save']");
        sendMessageButton.click();*/

    }

   @Test
    public void TestG(){
        System.out.println("This should run last! Alphabetically");
    }

    @Test
    public void TestA(){
        System.out.println("This runs first! Alphabetically");
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement xPath(String xpathString){
        WebElement webElement = driver.findElement(By.xpath(xpathString));
        return webElement;
    }


}
