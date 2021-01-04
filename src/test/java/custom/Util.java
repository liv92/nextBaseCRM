package custom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Util {

    public static String hr55 = "hr55@cybertekschool.com";
    public static String hr56 = "hr56@cybertekschool.com";
    public static String marketing55 = "marketing55@cybertekschool.com";
    public static String marketing56 = "marketing56@cybertekschool.com";
    public static String helpDesk55 = "helpdesk55@cybertekschool.com";
    public static String getHelpDesk56 = "helpdesk56@cybertekschool.com";

    public static String[] usersArr = { hr55, hr56, marketing55, marketing56, helpDesk55, getHelpDesk56};


    public static String password = "UserUser";

    public static String loginURL = "https://login2.nextbasecrm.com";

    public static WebDriver logIn(String username){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(loginURL);
        WebElement loginInput = driver.findElement(By.name("USER_LOGIN"));
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return driver;
    }




}
