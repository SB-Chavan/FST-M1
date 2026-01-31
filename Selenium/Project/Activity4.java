package seleniumLMSProj;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4 extends BaseTest {

    @Test
    public void verifyCourseTitle() {
        String course = driver.findElement(
                By.xpath("//h3[normalize-space()='Email Marketing Strategies']")
        ).getText();

        Assert.assertEquals(course, "Email Marketing Strategies");
    }
}

