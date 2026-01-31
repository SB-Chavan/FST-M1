package seleniumLMSProj;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 extends BaseTest {

    @Test
    @Parameters({"username","password"})
    public void login(String username, String password) {

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
    }
}
