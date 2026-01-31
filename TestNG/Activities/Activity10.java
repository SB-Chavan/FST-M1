package examples;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {

    WebDriver driver;
    WebDriverWait wait;

    // ================= Setup =================
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/simple-form");
    }

    // ================= Excel Reader =================
    public static List<List<String>> readExcel(String filePath) {

        List<List<String>> data = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    rowData.add(formatter.formatCellValue(cell));
                }
                data.add(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // ================= DataProvider =================
    @DataProvider(name = "Events")
    public static Object[][] signUpInfo() {

        String filePath = "src/test/resources/SampleData.xlsx";
        List<List<String>> excelData = readExcel(filePath);
        List<Object[]> testData = new ArrayList<>();

        // Skip header row
        for (int i = 1; i < excelData.size(); i++) {
            List<String> row = excelData.get(i);

            // Ensure all required columns exist
            if (row.size() >= 4) {
                testData.add(new Object[]{row});
            }
        }

        return testData.toArray(new Object[0][]);
    }

    // ================= Test =================
    @Test(dataProvider = "Events")
    public void registerTest(List<String> rows) {

        // Clear fields
        driver.findElement(By.id("full-name")).clear();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.name("event-date")).clear();
        driver.findElement(By.id("additional-details")).clear();

        // Fill text fields
        driver.findElement(By.id("full-name")).sendKeys(rows.get(0));
        driver.findElement(By.id("email")).sendKeys(rows.get(1));
        driver.findElement(By.id("additional-details")).sendKeys(rows.get(3));

        // ===== Date handling (HTML5 FIX) =====
        String excelDate = rows.get(2).replaceAll("\"", "");

        // Convert Excel date → HTML5 date format (yyyy-MM-dd)
        LocalDate formattedDate = LocalDate.parse(
                excelDate,
                DateTimeFormatter.ofPattern("M/d/yy")
        );

        // Use JavaScript to set date (most reliable)
        WebElement dateField = driver.findElement(By.name("event-date"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value=arguments[1];",
                dateField,
                formattedDate.toString()
        );

        // Submit form
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Wait for confirmation
        WebElement confirmation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("action-confirmation"))
        );

        // Assertion
        assertEquals(
                confirmation.getText(),
                "Your event has been scheduled!"
        );

        // Prepare for next iteration
        driver.navigate().refresh();
    }

    // ================= Tear Down =================
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
