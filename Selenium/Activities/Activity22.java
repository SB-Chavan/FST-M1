package example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //Open URL
        driver.get("https://training-support.net/webelements/popups");
        // Title of the Page--Print
        System.out.println("Page title: " + driver.getTitle());

        // Click on Launcher Button
        driver.findElement(By.id("launcher")).click();

        // Wait until username field appears
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        // Finding fields on page to login process
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        
        // Enter details for username and password credentials
        username.sendKeys("admin");
        password.sendKeys("password");
        
        // Click --> submit button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Print the success message
        String message = driver.findElement(By.cssSelector("h2.text-center")).getText();
        System.out.println("Login message: " + message);

        // Close the browser
        driver.quit();
    }
}