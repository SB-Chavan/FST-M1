package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/mouse-events");
		
		Actions builder = new Actions(driver);
		
		System.out.println("Page Title: " + driver.getTitle());
		

	    //Left click on the Cargo.lock button, move the cursor to the Cargo.toml button and then click it.
		WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));
		
		builder.click(cargoLock).pause(1000).moveToElement(cargoToml).pause(5000).click(cargoToml).build().perform();
		
		//Print the confirmation text at the end of the sequence.
		String actionMessage = driver.findElement(By.id("result")).getText();
        System.out.println(actionMessage);
		
		//Double click on the src button. Then right click on the target button and select open. 
        builder.doubleClick(srcButton).pause(3000).pause(5000).contextClick(targetButton).pause(3000).build().perform();
        
        
        builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(5000).build().perform();
        
      //Print the confirmation text at the end of the sequence.
        actionMessage = driver.findElement(By.id("result")).getText();
        System.out.println(actionMessage);

	//Close the browser.
		
		driver.quit();
	}

}
