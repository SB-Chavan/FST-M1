package seleniumLMSProj;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2 extends BaseTest {

    @Test
    public void verifyHeading() {
        String heading = driver.findElement(By.className("uagb-ifb-title")).getText();
        Assert.assertEquals(heading, "Learn from Industry Experts");
    }
}
