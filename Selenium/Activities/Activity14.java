package example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		
		System.out.println("Page Title: " + driver.getTitle());
		
		//Using xpaths on the table:

		 //Find the number of rows and columns in the table and print them.
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
		System.out.println("Number of Columns: " + cols.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
		System.out.println("Number of Rows: " + rows.size());
		
		
		//Find and print the Book Name in the 5th row.
		WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		
		System.out.println("The Book name in 5th Row :" +cellValue.getText());
		
		
		//Click the header of the Price column to sort it in ascending order.
		driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr/td[5]")).click();
		
		
		//Find and print the Book Name in the 5th row again.
		WebElement cellValue1 = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		
		System.out.println("The Book name in 5th Row :" +cellValue1.getText());
		
		
		//Quite
		driver.quit();
		
		
	}

}
