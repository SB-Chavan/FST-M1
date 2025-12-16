package example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {
	
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
			
			//Find and print all the cell values in the third row of the table.
			List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]/td"));
	        System.out.println("Third row cell values: ");
	        for(WebElement cell : thirdRow) {
	            System.out.println(cell.getText());
	        }
			
			
			//Find and print the cell value at the second row second column.
	        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"));
	        System.out.println("Second row, second cell value: " + cellValue.getText());
			
			
			//Close the browser.
			driver.quit();
		}

}
