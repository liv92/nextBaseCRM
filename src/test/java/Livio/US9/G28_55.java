package Livio.US9;


import custom.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class G28_55 extends Util {

    public static void main(String[] args) throws InterruptedException {

/**
 Please refer to Test Case G28-55 for more details on each step. This test case has 6 steps.
**/

        //Log in to home page
        WebDriver driver = logIn(hr55);

        //Step 1 "From home page user click on Event Module Tab."
        WebElement eventTab = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/div/div[2]/div/div[1]/div/div/div[1]/div/span[3]"));
        eventTab.click();
        Thread.sleep(1000);
        //Step 2 "User sees a dropdown input field labeled "Event" appear above activity stream."
        String expectedResult = "feed-add-post-form-link feed-add-post-form-link-active";
        String actualResult = eventTab.getAttribute("class");
        if (expectedResult.equals(actualResult)){
            System.out.println(true);
        }else{
            System.out.println(false);
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
        }

        //Step 3 Click on Event Name field.
        WebElement eventName = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/div/div[2]/div/div[1]/div/div/div[3]/div/div/form/div[2]/div[4]/div/div[1]/input"));
        //Step 4 Input words/characters in Event field name.
        eventName.sendKeys("Selenium Test");

        //




    }

}
