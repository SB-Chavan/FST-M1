package seleniumLMSProj;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3 extends BaseTest {

    @Test
    public void verifyInfoBoxTitle() {
        String title = driver.findElement(
                By.xpath("//h3[normalize-space()='Actionable Training']")
        ).getText();

        Assert.assertEquals(title, "Actionable Training");
    }
}
