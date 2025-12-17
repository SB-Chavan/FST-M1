package examples;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver = new FirefoxDriver();
	
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		
		driver.get("https://training-support.net/webelements/target-practice");
	}
	
	
	@Test(groups = {"HeaderTests", "ButtonTests"})
	public void checkPageTitle() {
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Selenium: Target Practice");
		
	}
	
	/*
    Find the third header and assert the text in the h3 tag.
    Find and assert the colour of the fifth header tag element.
    */

	@Test(dependsOnMethods = "checkPageTitle", groups = {"HeaderTests"})
	public void headerTest1() {
		WebElement thirdHeader = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
		Assert.assertEquals(thirdHeader.getText(), "Heading #3");
		
		
	}
	
	
	@Test(dependsOnMethods = "checkPageTitle", groups = {"HeaderTests"})
	public void headerTest2() {
        Color header5Color = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
    	
        Assert.assertEquals(header5Color.asHex(), "#9333ea");
		
        
	}
	
	
	/*
    Find the button with the class emerald and assert it text.
    Find and assert the colour of the first button in the third row.
	 */
	
	@Test(dependsOnMethods = "checkPageTitle", groups = {"ButtonTests"})
	public void buttonTest1() {
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
    	Assert.assertEquals(button1.getText(), "Emerald");
		
	}
	
	
	@Test(dependsOnMethods = "checkPageTitle", groups = {"ButtonTests"})
	public void buttonTest2() {
        Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
    	Assert.assertEquals(button2Color.asHex(), "#581c87");
		
		
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		driver.close();
	}
	
	

}
