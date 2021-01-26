package Stephanie;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAutomation_US3_US4 {


    WebDriver driver;

    @BeforeClass
    public void setUpClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");

    }

    @AfterClass
    public void teardownClass() {
        sleep();
        driver.close();
    }

    @BeforeMethod
    public void logIn() {

        //Login - User Name input
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("hr55@cybertekschool.com");

        //Login - Password input
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("UserUser");

        //Click "Log In" button
        driver.findElement(By.xpath("//input[@class = 'login-btn']")).click();

    }

    @AfterMethod
    public void logOut() {

        //Logout from home page
        driver.findElement(By.xpath("//div[@id = 'user-block']")).click();
        sleep();
        driver.findElement(By.xpath("//span[.='Log out']")).click();

        //Clear Login input box prior login info
        sleep();
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).clear();

    }


    @Test
    public void us3_TC51() {

        //Step 1: From the home page, user should be able to click in search input box
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).click();

        //Step 2: User should be able to enter/type valid data into the search box.
        // Enter "employee"
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).sendKeys("employee");

    }

    @Test
    public void us3_TC61() { //Cannot use the logout method as the href changes

        //Step 1: From the home page, user should be able to click in search input box
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).click();

        //Step 2: User should be able to enter/type valid data into the search box.
        // Enter "jane doe"
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).sendKeys("jane doe" + Keys.ENTER);

        //Step 3: User should not not be able to find invalid data. "Nothing found" message should be displayed
        WebElement confirmation_message = driver.findElement(By.xpath("//div[@class = 'feed-wrap-empty']"));

        String expectedMessage = "Nothing found";
        String actualMessage = confirmation_message.getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Message verification Passed!!!");
        } else {
            System.out.println("Message verification Failed!!!");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        sleep();

/*
        //Logout from home page
        driver.findElement(By.xpath("//div[@id = 'user-block']")).click();
        sleep();
        driver.findElement(By.xpath("//a[@href ='/auth/?logout=yes&backurl=%2Fstream%2F%3Fapply_filter%3DY%26FIND%3Djane%2520doe']")).click();

        //Clear Login input box prior login info
        sleep();
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).clear();


 */
    }

    @Test
    public void us3_TC62() {

        //Step 1: From the home page, user should be able to click in search input box
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).click();
        sleep();

        //Step 2: User should be able to enter/type valid data into the search box.
        // Enter "employee"
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).sendKeys("employee");

        sleep();

        //Step 3: User should be able to see display menu of available options regarding inputted valid data
        driver.findElement(By.xpath("//div[@class = 'search-title-top-result']"));

        sleep();


    }

    @Test
    public void us4_TC63 (){

        //Step 1: From the home page, user should be able to click in poll module
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-vote']")).click();

        //Step 3: User should be able to enter/type valid Poll message data into the "Message" input box
        // Enter "Poll question?"
       sleep();
       driver.findElement(By.xpath("//span[@id = 'bx-b-quote-blogPostForm']")).click();
        //*[@id="bx-b-quote-blogPostForm"]

       sleep();
       driver.findElement(By.xpath("//blockquote[@class = 'bxhtmled-quote']")).sendKeys("Poll question?");


        //Step 4: User should be able to enter/type valid question data into the "Question" input box
        // Enter "What to ask?"
        sleep();
        driver.findElement(By.xpath("//input[@id = 'question_0']")).sendKeys("What to ask?");

        //Step 5: User should be able to enter/type valid answer data into the "Answer" input box
        //Enter: "Option 1"
        sleep();
        driver.findElement(By.xpath("//input[@class = 'vote-block-inp adda']")).sendKeys("Option 1");

        //Step 6: User should be able to click the send button
        sleep();
        driver.findElement(By.xpath("//button[@class = 'ui-btn ui-btn-lg ui-btn-primary']")).click();

        //Step 7: User should be able to see the poll message created displayed in the "Activity Stream" window
        sleep();
        WebElement pollMessage = driver.findElement(By.xpath("//div[. = 'Poll question?']"));

        String actualPollMessage = pollMessage.getText();
        String expectedPollMessage = "Poll question?";

        if(actualPollMessage.equals(expectedPollMessage)){
            System.out.println("Verification Passed!");
        }else{
            System.out.println("Verification Failed!");
        }

        sleep();

    }

    @Test
    public void us4_TC64 (){//Cannot use the logout method as the href changes

        //Step 1: From the home page, user should be able to click in poll module
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-vote']")).click();

        //Step 3: User should be able to enter/type valid question data into the "Question" input box
        // Enter "What to ask?"
        sleep();
        driver.findElement(By.xpath("//input[@id = 'question_0']")).sendKeys("What to ask?");

        //Step 5: User should be able to enter/type valid answer data into the "Answer" input box
        //Enter: "Option 1"
        sleep();
        driver.findElement(By.xpath("//input[@class = 'vote-block-inp adda']")).sendKeys("Option 1");

        //Step 6: User should be able to click the send button
        sleep();
        driver.findElement(By.xpath("//button[@class = 'ui-btn ui-btn-lg ui-btn-primary']")).click();

        //Step 7: User should be able to see error message "The message title is not specified"
        sleep();
        WebElement errorPollMessage = driver.findElement(By.xpath("//span[@class = 'feed-add-info-text']"));

        String actualErrorPollMessage = errorPollMessage.getText();
        String expectedErrorPollMessage = "The message title is not specified";

        Assert.assertTrue(actualErrorPollMessage.equals(expectedErrorPollMessage));

        sleep();
/*
        //Logout from home page
        driver.findElement(By.xpath("//div[@id = 'user-block']")).click();
        sleep();
        driver.findElement(By.xpath("//a[@href ='/auth/?logout=yes&backurl=%2Fstream%2F%3Fb24statAction%3DaddLogEntry%26b24statTab%3Dvote']")).click();

        //Clear Login input box prior login info
        sleep();
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).clear();


 */

    }

    @Test
    public void us4_TC65 (){

        //Step 1: From the home page, user should be able to click in poll module
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-vote']")).click();

        //Step 2: User should be able to click on "Allow multiple choice" option
        sleep();
        driver.findElement(By.xpath("//input[@id = 'multi_0']")).click();
        sleep();

    }


    @Test
    public void us4_TC132 (){

        //Step 1: From the home page, user should be able to click in poll module
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-vote']")).click();

        //Step 2: User should be able to click on "Add Question" link
        sleep();
        driver.findElement(By.xpath("//a[@class = 'vote-new-question-link addq']")).click();

        //Step 3. Verify a new set of question and answer is displayed
        sleep();

        List<WebElement> allQuestions = driver.findElements(By.xpath("//li[@class = 'vote-question']"));

        if(allQuestions.size() > 1){
            System.out.println("Verification Passed!");
        }else{
            System.out.println("Verification Failed!");
        }

        sleep();

    }


    @Test
    public void us4_TC72 (){//Cannot use the logout method as the href changes

        //Step 1: From the home page, user should be able to click in poll module
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-vote']")).click();

        //Step 3: User should be able to enter/type valid question data into the "Question" input box
        // Enter "What to ask?"
        sleep();
        driver.findElement(By.xpath("//input[@id = 'question_0']")).sendKeys("What to ask?");

        //Step 5: User should be able to enter/type valid answer data into the "Answer" input box
        //Enter: "Option 1"
        sleep();
        driver.findElement(By.xpath("//input[@class = 'vote-block-inp adda']")).sendKeys("Option 1");

        //Step 6: User should be able to click the cancel button
        sleep();
        driver.findElement(By.xpath("//button[@class = 'ui-btn ui-btn-lg ui-btn-link']")).click();

        //Step 7: User should be able to return to the Activity Stream window
        sleep();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class = 'pagetitle']"));

        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Activity Stream";

        Assert.assertTrue(actualPageTitle.equals(expectedPageTitle));
        sleep();


    }

    public static void sleep() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

    }


}
