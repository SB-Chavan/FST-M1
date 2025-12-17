package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void BeforeMethod() {
		
		driver.get("https://training-support.net/webelements/target-practice/");
		
	}
	
	
	@Test
	public void testcase1() {
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Selenium: Target Practice");
	}
	
	@Test
	public void testcase2() {
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
    	
        Assert.assertTrue(blackButton.isDisplayed());
	    Assert.assertEquals(blackButton.getText(), "black");
		
	}
	
	@Test (enabled = false)
	public void testcase3() {
		
        String subHeading = driver.findElement(By.className("sub")).getText();
    	Assert.assertTrue(subHeading.contains("Practice"));
	}
	
	@Test
	public void testcase4() {
		throw new SkipException("Skipping test case");
		
	}
	
	
	
	@AfterTest
	public void AfterMethod() {
		
		driver.close();
		
		
	}
	
	
	

}
