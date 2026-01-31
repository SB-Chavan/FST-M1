package seleniumLMSProj;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1 extends BaseTest {

    @Test
    public void verifyPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Alchemy LMS – An LMS Application");
    }
}
