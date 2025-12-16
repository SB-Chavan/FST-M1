package example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
	
	
	public static void main(String[] args) {
		


	    //Open a new browser to https://training-support.net/webelements/selects
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		
		//Get the title of the page and print it to the console.
		System.out.println("Page Title: " +driver.getTitle());
		
		//On the Multi Select:
		WebElement selectElement = driver.findElement(By.cssSelector("select.h-80"));
		
		Select multiSelect = new Select(selectElement);
		
		//  Select the "HTML" option using the visible text.
		
		multiSelect.selectByVisibleText("HTML");
		
		//  Select the 4th, 5th and 6th options using the index.
		for(int i=3; i<5; i++) {
			multiSelect.selectByIndex(i);
			
		}
		
		//  Select the "Node" option using the value.
		multiSelect.selectByValue("nodejs");
		// Print the selected options
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        
        System.out.println("Selected options are: ");
        
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        //Deselect the 5th option using index.
        multiSelect.deselectByIndex(4);
        
        
        // Print the selected options
        selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }
		
		
		
		//Close the browser.

		driver.quit();
		
		
	}

}
