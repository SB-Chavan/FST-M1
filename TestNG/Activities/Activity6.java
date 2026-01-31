package examples;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


import org.testng.annotations.Parameters;

public class Activity6 {
	
	/*

    Create a TestNG Class with the annotations
        @Test 	@BeforeClass	@AfterClass
    Once the Class file is created, import
        By
        WebDriver
        FirefoxDriver
        WebElement
        Parameters

*/
	
	WebDriver driver = new FirefoxDriver();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@BeforeClass
	public void beforeClass() {
		driver.get("https://training-support.net/webelements/login-form");
		
		//wait =new WebDriverWait(driver, DurationOfS)
	}
	
	
	@Test
	@Parameters({"username","password"})
	public void loginTestCase(String username, String password) {
		
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
		usernameField.sendKeys("admin");
		passwordField.sendKeys("password");
		loginBtn.click();
		
		wait.until(ExpectedConditions.titleContains("Success"));
		
		//Assert login Message:
		
		String loginMsg = driver.findElement(By.cssSelector("h2.text-center")).getText();
		
		Assert.assertEquals(loginMsg, "Welcome Back, Admin!");
		
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
