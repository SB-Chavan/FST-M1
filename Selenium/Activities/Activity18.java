package example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {
    public static void main(String[] args) {
       
    	
        WebDriver driver = new FirefoxDriver();

        
        driver.get("https://training-support.net/webelements/alerts");
        //Title of the Page:
        System.out.println("Page title: " + driver.getTitle());

        // Find and click the button to open the alert
        driver.findElement(By.id("simple")).click();

        // Switch to  alert
        Alert simpleAlert = driver.switchTo().alert();

        // Text of the alert
        String alertText = simpleAlert.getText();
        System.out.println("Text in alert: " + alertText);

        // Close the alert->click OK
        simpleAlert.accept();
        
        // Print the message
        System.out.println(driver.findElement(By.id("result")).getText());

        // Close the browser
        driver.quit();
    }
}