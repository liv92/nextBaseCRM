package Sobir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
  public static void main(String[] args) throws InterruptedException {

    //hr and marketing team positive test

    String[] users = {
            "hr55@cybertekschool.com",
            "hr56@cybertekschool.com",
            "marketing55@cybertekschool.com",
            "marketing56@cybertekschool.com"
    };
    String pswd = "UserUser";
    String loginURL = "https://login2.nextbasecrm.com";

    WebDriverManager.chromedriver().setup();
    WebDriver dr = new ChromeDriver();
    dr.get(loginURL);
    for (String each : users){
      System.out.println("\t\t\t*********  Testing " + each + " ***********");
      System.out.println("1st step: Login for " + each);
      WebElement loginInput = dr.findElement(By.xpath("//input[@name='USER_LOGIN']"));
      WebElement pswdInput = dr.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
      WebElement loginButton = dr.findElement(By.xpath("//input[@class='login-btn']"));
      loginInput.clear();
      Thread.sleep(500L);
      loginInput.sendKeys(each);
      Thread.sleep(500L);
      pswdInput.clear();
      Thread.sleep(500L);
      pswdInput.sendKeys(pswd);
      Thread.sleep(500L);
      loginButton.click();
      Thread.sleep(500L);
      dr.findElement(By.xpath("//span[contains(text(), 'Activity Stream')]")).click();
      Thread.sleep(500L);
      String expectedHomeURL = "https://login2.nextbasecrm.com/stream/";
      String actualHomeURL = dr.getCurrentUrl();
      if(actualHomeURL.contains(expectedHomeURL)){
        System.out.println("\t"+each + " login PASSED");
      }else {
        System.out.println("\t"+each + " login FAILED");
        System.out.println("\t\tactualHomeURL = " + actualHomeURL);
        System.out.println("\t\texpectedHomeURL = " + expectedHomeURL);
        System.out.println("7th step: Logout " + each);
        dr.findElement(By.xpath("//div[@id='user-block']")).click();
        Thread.sleep(500L);
        dr.findElement(By.xpath("//span[.='Log out']")).click();
        Thread.sleep(500L);
        continue;
      }
      Thread.sleep(500L);
      System.out.println("2ng step: Click on \"Time and Reports\" module for " + each);
      WebElement timeAndReports = dr.findElement(By.xpath("//span[contains(text(), 'Time and Reports')]"));
      timeAndReports.click();
      Thread.sleep(500L);
      String expectedTimeURL = "https://login2.nextbasecrm.com/timeman";
      String actualTimeURL = dr.getCurrentUrl();
      if (actualTimeURL.contains(expectedTimeURL)){
        System.out.println("\t"+each + " Click on \"Time and Reports\" module PASS");
      }else {
        System.out.println("\t"+each + " Click on \"Time and Reports\" module FAIL");
        System.out.println("\t\tactualTimeURL = " + actualTimeURL);
        System.out.println("\t\texpectedTimeURL = " + expectedTimeURL);
        System.out.println("7th step: Logout " + each);
        dr.findElement(By.xpath("//div[@id='user-block']")).click();
        Thread.sleep(500L);
        dr.findElement(By.xpath("//span[.='Log out']")).click();
        Thread.sleep(500L);
        continue;
      }
      Thread.sleep(500L);
      System.out.println("3rd step: Click through filter absence chart tabs by day / week / month for " + each);
      WebElement day = dr.findElement(By.xpath("//span[contains(text(), 'Day')]"));
      day.click();
      Thread.sleep(500L);
      if(dr.findElement(By.xpath("//table[@class='bx-calendar-day-main-table']")).isDisplayed()){
        System.out.println("\t" + each + " filter absence chart tabs by day PASS");
      }else {
        System.out.println("\t" + each + " filter absence chart tabs by day FAIL");
      }
      WebElement week = dr.findElement(By.xpath("//span[contains(text(), 'Week')]"));
      week.click();
      Thread.sleep(500L);
      if(dr.findElement(By.xpath("//table[@class='bx-calendar-week-main-table']")).isDisplayed()){
        System.out.println("\t" + each + " filter absence chart tabs by week PASS");
      }else {
        System.out.println("\t" + each + " filter absence chart tabs by week FAIL");
      }
      WebElement month = dr.findElement(By.xpath("//span[contains(text(), 'Month')]"));
      month.click();
      Thread.sleep(500L);
      if(dr.findElement(By.xpath("//table[@class='bx-calendar-month-main-table']")).isDisplayed()){
        System.out.println("\t" + each + " filter absence chart tabs by month PASS");
      }else {
        System.out.println("\t" + each + " filter absence chart tabs by month FAIL");
      }
      Thread.sleep(500L);
      System.out.println("4th step: Click \"Worktime\" link for " + each);
      WebElement worktime = dr.findElement(By.xpath("//span[contains(text(), 'Worktime')]"));
      worktime.click();
      Thread.sleep(500L);
      String expertedWorktimeURL = "https://login2.nextbasecrm.com/timeman";
      String actualWorktimeURL = dr.getCurrentUrl();
      if(actualWorktimeURL.contains(expertedWorktimeURL)){
        System.out.println("\t" + each + " Click \"Worktime\" link PASS");
      }else {
        System.out.println("\t" + each + " Click \"Worktime\" link FAIL");
        System.out.println("\tactualWorktimeURL = " + actualWorktimeURL);
        System.out.println("\texpertedWorktimeURL = " + expertedWorktimeURL);
        System.out.println("7th step: Logout " + each);
        dr.findElement(By.xpath("//div[@id='user-block']")).click();
        Thread.sleep(500L);
        dr.findElement(By.xpath("//span[.='Log out']")).click();
        Thread.sleep(500L);
        continue;
      }
      Thread.sleep(500L);
      System.out.println("5th step: Click on \"Statistics\" checkbox for " + each);
      WebElement statistic = dr.findElement(By.xpath("//input[@id='stats']"));
      statistic.click();
      Thread.sleep(500L);
      WebElement table = dr.findElement(By.xpath("//div[contains(@class, 'tm-report')]"));
      if(!table.getAttribute("class").contains("bx-tm-wide-mode")){
        System.out.println("\t" + each + " click on \"Statistics\" checkbox PASS");
      }else {
        System.out.println("\t" + each + " click on \"Statistics\" checkbox FAIL");
      }
      Thread.sleep(500L);
      System.out.println("6th step: Click on \"Show start and end times' checkbox for " + each);
      if(!table.getAttribute("class").contains("bx-tm-additions-disabled")){
        System.out.println("\t" + each + " click on \"Statistics\" checkbox PASS");
      }else {
        System.out.println("\t" + each + " click on \"Statistics\" checkbox FAIL");
      }
      Thread.sleep(500L);
      System.out.println("7th step: Logout " + each);
      dr.findElement(By.xpath("//div[@id='user-block']")).click();
      Thread.sleep(500L);
      dr.findElement(By.xpath("//span[.='Log out']")).click();
      Thread.sleep(500L);
    }
    dr.close();
  }
}
