package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/target-practice");
		
		System.out.println("Title of the page : " + driver.getTitle());
		
		
		 //Using xpath:

			//Find the 3rd header on the page and print it's text to the console.
			
			String text = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
			System.out.println(text);
			System.out.println("The 3rd Header is " + driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText());
		
			//Find the 5th header on the page and print it's color.
			
			System.out.println("The color of fifth header: " + driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
			
		//Using any other locator:

			//Find the purple button and print all it's classes.
			String purpleBtnClasses = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
	        System.out.println(purpleBtnClasses);
			
			//Find the slate button and print it's text.
	        String slateBtnText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
	        System.out.println(slateBtnText);
	        
			

			//Close the browser.
		driver.quit();
		
		
		
		
		
	}

}
