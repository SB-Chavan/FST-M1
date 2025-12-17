package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	public void beforeClass() {
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
	
	
	
	@Test
	public void loginTest() {
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		
		username.sendKeys("admin");
		password.sendKeys("password");
		
		//Click on login button
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//Read login text
		String loginMsg = driver.findElement(By.cssSelector("h2.text-center")).getText();
		
		//Read the confirmation message and make and assertion to check if the correct message has been printed
		//Assert.assertEquals("Expected message", "Actual Message");
		Assert.assertEquals(loginMsg, "Welcome Back, Admin!");
		
	
		
	}
	
	
	
	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
	
	

}
