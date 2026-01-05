package example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		
		System.out.println("Page TItle:\n" + driver.getTitle());
		
		WebElement btnSimple = driver.findElement(By.id("simple"));
		btnSimple.click();
		
		Alert simpleAlert = driver.switchTo().alert();
		
		String alertText = simpleAlert.getText();
		
		System.out.println("The Simple Alert Text:\n" + alertText);
		
		
		//Close the alert
		simpleAlert.accept();
		
		
		//Print the message of the page after clicking on ok button
		
		System.out.println("The Result Message on Page:\n" + driver.findElement(By.id("result")).getText());
		
		
		//Close 
		driver.quit();
		
	}

}
