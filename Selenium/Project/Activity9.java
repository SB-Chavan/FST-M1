package seleniumLMSProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Activity9 extends BaseTest {

    @Test
    public void completeLesson() {

        driver.findElement(By.linkText("All Courses")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='See more...'])[1]")).click();
        driver.findElement(By.xpath("//div[normalize-space()='Expand All']")).click();

        WebElement lesson = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='Relationships']")
                )
        );
        lesson.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[contains(@class,'learndash_mark_complete_button')]")
                )
        ).click();
    }
}
