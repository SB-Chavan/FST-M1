package example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	
	
	public static void main(String[] args) {
		
		


	    //Open a new browser to https://training-support.net/webelements/
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
	    	
	    //Get the title of the page and print it to the console.
		System.out.println("Page Title: " + driver.getTitle());
		
	    //On the Single Select:
		WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
		
		Select singleSelect = new Select(dropdown);
		
		//  Select the second option using the visible text.
		singleSelect.selectByVisibleText("Two");
		System.out.println("The 2nd dropdown menu:  " +singleSelect.getFirstSelectedOption().getText());
		
		
	    // Select the third option using the index.
		singleSelect.selectByIndex(3);
		
		System.out.println("The 3rd dropdown menu: " +singleSelect.getFirstSelectedOption().getText());
	     
		
		//Select the fourth option using the value.
		singleSelect.selectByVisibleText("Four");
		System.out.println("The 4th dropdown menu:  " +singleSelect.getFirstSelectedOption().getText());
	    
		//Get all the options and print them to the console.
		 List<WebElement> allOptions = singleSelect.getOptions();
		 
		 for(WebElement option: allOptions) {
			 System.out.println(option.getText());
			 
			 
		 }
		 
	    
		//Close the browser.
				driver.quit();
		
		
		
	}
	

}
