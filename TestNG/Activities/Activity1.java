package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


public class Activity1 {
	
	WebDriver driver = new FirefoxDriver();
	
	
	
	@BeforeClass
	public void setup() {
		driver.get("https://training-support.net");
		
	}
		
	
	@Test
	public void testPage() {
		
		String title = driver.getTitle();
		System.out.println("Page Title: " + title );
		
        // Assert page title
		Assert.assertEquals(driver.getTitle(), "Training Support");
		
        driver.findElement(By.linkText("About Us")).click();
        
        System.out.println("Page Title:\n" + driver.getTitle());
        
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	

}
