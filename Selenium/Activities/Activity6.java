package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		
		//Get the title of the page and print it to the console.
		String title = driver.getTitle();
		
		System.out.println("Page Title: " + title);
		
		
		//On the page, perform:

		//Find the checkbox input element.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		
		
	    //Check if the checkbox is selected and print the result.
		System.out.println("Is checkbox selected?:" + checkbox.isSelected());
		
	    //Click the checkbox to select it.
		checkbox.click();
		
	    //Check if the checkbox is selected again and print the result.
		System.out.println("Is checkbox selected?:" + checkbox.isSelected());
		
	//Close the browser.
		driver.quit();
		
	}

}
