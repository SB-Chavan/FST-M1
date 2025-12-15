package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		
		
		driver.get("https://training-support.net/webelements/drag-drop");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		

	    //Find the ball and simulate a click and drag to move it into "Dropzone 1".
		WebElement football = driver.findElement(By.id("ball"));
		
		WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
		
		builder.clickAndHold(football).moveToElement(dropzone1).pause(5000).release().build().perform();
		
	    //Verify that the ball has entered Dropzone 1.
		if(dropzone1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in Dropzone 1");
        }
		
		
	    //Once verified, move the ball into "Dropzone 2".
		builder.clickAndHold(football).moveToElement(dropzone2).pause(5000).release().build().perform();
		
	    //Verify that the ball has entered Dropzone 2.
		if(dropzone2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball was dropped in Dropzone 2");
        }
		
	//Close the browser.
		
		driver.quit();
		
		
	}

}
