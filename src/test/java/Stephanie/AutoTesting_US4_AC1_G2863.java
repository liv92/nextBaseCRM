package Stephanie;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.util.Builder;
import jdk.nashorn.internal.runtime.arrays.AnyElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AutoTesting_US4_AC1_G2863 {

    public static void main(String[] args) throws InterruptedException, AWTException {

        //Set up
        WebDriverManager.chromedriver().setup();

        //Open Browser
        WebDriver driver = new ChromeDriver();

        //Open website https://login2.nextbasecrm.com/
        driver.manage().window().maximize(); //maximizing window
        Thread.sleep(3000);
        driver.get("https://login2.nextbasecrm.com/");

        //Login - User Name input
        driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys("hr55@cybertekschool.com");

        //Login - Password input
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("UserUser");

        //Click "Log In" button
        driver.findElement(By.xpath("//input[@class = 'login-btn']")).click();

        Thread.sleep(3000);

        //Step 1: From the home page, user should be able to click in poll module
        driver.findElement(By.xpath("//span[@id = 'feed-add-post-form-tab-vote']")).click();


        //Step 2: User should be able to enter/type valid Poll message data into the "Message" input box
        // Enter "Poll question?"
        Thread.sleep(3000);
      driver.findElement(By.xpath("//div[@class = 'feed-add-post-text']")).sendKeys("Hello");


        //Step 3: User should be able to enter/type valid question data into the "Question" input box
        // Enter "What to ask?"
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id = 'question_0']")).sendKeys("What to ask?");

        //Step 4: User should be able to enter/type valid answer data into the "Answer" input box
        //Enter: "Option 1"
        driver.findElement(By.xpath("//input[@class = 'vote-block-inp adda']")).sendKeys("Option 1");

        //Step 5: User should be able to enter/type valid answer data into the "Answer" input box
        driver.findElement(By.xpath("//button[@class = 'ui-btn ui-btn-lg ui-btn-primary']")).click();



    }

}


/*

     Step 1: From the home page, user should be able to click in poll module
     Step 2: User should be able to enter/type valid Poll message data into the "Message" input box
     Step 3: User should be able to enter/type valid question data into the "Question" input box
     Step 4: User should be able to enter/type valid answer data into the "Answer" input box
     Step 5: User should be able to click the "Send" button
     Step 6: User should be able to see the poll message created displayed in the "Activity Stream" window

     Data: users (hr, marketing and helpdesk) search a valid info : employee, doc, post, task ..

 */