package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowTest {

    /*
    http://practice.cybertekschool.com/windows
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        sleep(1);
        Set<String> allWindowHandles = driver.getWindowHandles();
        int i = 1;
        for (String eachWindowHandle : allWindowHandles) {
            sleep(1);
            driver.switchTo().window(eachWindowHandle);

            System.out.println("This is window number: " + i + " " + eachWindowHandle);
            i++;
        }
        sleep(1);
        System.out.println(driver.getTitle() + " " + driver.getWindowHandle());

        driver.get("https://www.google.com");
    }


    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
