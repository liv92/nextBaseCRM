package Stephanie;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoTesting_US3_AC1 {

    public static void main(String[] args) throws InterruptedException {

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

        //Step 1: From the home page, user should be able to click in search input box
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).click();

        //Step 2: User should be able to enter/type valid data into the search box.
        // Enter "employee"
        driver.findElement(By.xpath("//input[@id = 'search-textbox-input']")).sendKeys("employee");





    }

}


/*

     Step 1: From the home page, user should be able to click in search input box
     Step 2: User should be able to enter/type valid data into the search box

     Data: users (hr, marketing and helpdesk) search a valid info : employee, doc, post, task ..

 */