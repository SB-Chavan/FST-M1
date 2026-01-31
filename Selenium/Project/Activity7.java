package seleniumLMSProj;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Activity7 extends BaseTest {

    @Test
    public void countCourses() {

        driver.findElement(By.linkText("All Courses")).click();

        List<WebElement> courses = driver.findElements(
                By.cssSelector("div[id^='ld-course-list-content'] .ld_course_grid")
        );

        System.out.println("Total Courses: " + courses.size());
    }
}
