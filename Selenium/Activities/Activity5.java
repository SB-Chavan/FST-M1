package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		
		//Get the title of the page and print it to the console.
		String title = driver.getTitle();
		
		System.out.println("Page Title: " + title);
		
		
		//On the page, perform:

		//Find the checkbox input element.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		
		
		//Check if it is visible on the page.
		System.out.println("Checkbox visible on page:" + checkbox.isDisplayed());
		
		//Click the "Remove Checkbox" button.
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
		
		//Check if it is visible again and print the result.
		System.out.println("Re-Check that Checkbox is visible on page:" + checkbox.isDisplayed());
		
		
		
		//Close the browser.
		
		driver.quit();
	}

}
