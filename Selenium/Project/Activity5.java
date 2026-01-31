package seleniumLMSProj;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity5 extends BaseTest {

    @Test
    public void navigateToMyAccount() {
        driver.findElement(By.linkText("My Account")).click();
        Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
    }
}
