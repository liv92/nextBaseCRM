package Stephanie;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class AutoTesting_LogIn_LogOut {

    public static void main(String[] args) throws InterruptedException {


        //Set up
        WebDriverManager.chromedriver().setup();

        //Open Browser
        WebDriver driver = new ChromeDriver();

        //Open website https://login2.nextbasecrm.com/
        driver.manage().window().maximize(); //maximizing window
        Thread.sleep(3000);
        driver.get("https://login2.nextbasecrm.com/");


        ArrayList<String> userListNames = new ArrayList<String>();
        userListNames.addAll(Arrays.asList("helpdesk55@cybertekschool.com", "helpdesk56@cybertekschool.com", "hr55@cybertekschool.com",
                "hr56@cybertekschool.com", "marketing55@cybertekschool.com", "marketing56@cybertekschool.com"));

        String password = "UserUser";

        for (String each : userListNames) {

            //Login - User Name input
            driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).sendKeys(each);

            //Login - Password input
            driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(password + Keys.ENTER);
            Thread.sleep(3000);

            //Logout from home page
            driver.findElement(By.xpath("//div[@id = 'user-block']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[@href = '/auth/?logout=yes&backurl=%2Fstream%2F']")).click();

            //Clear Login input box prior login info
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']")).clear();


        }

    }
}


/*
User ID:
helpdesk55@cybertekschool.com
helpdesk56@cybertekschool.com

hr55@cybertekschool.com
hr56@cybertekschool.com                "

marketing55@cybertekschool.com
marketing56@cybertekschool.com"

Password:
UserUser

 */