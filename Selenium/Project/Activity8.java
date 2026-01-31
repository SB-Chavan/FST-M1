package seleniumLMSProj;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Activity8 extends BaseTest {

    @Test
    public void contactAdmin() {

        driver.findElement(By.linkText("Contact")).click();

        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("TEST USER");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("test@ibm.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Login Issue");
        driver.findElement(By.id("wpforms-8-field_2"))
              .sendKeys("Unable to login into LMS");

        driver.findElement(By.id("wpforms-submit-8")).click();
    }
}
