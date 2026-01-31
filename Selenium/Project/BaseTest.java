package seleniumLMSProj;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/lms");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
