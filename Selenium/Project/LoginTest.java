package seleniumLMSProj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver = new FirefoxDriver();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@BeforeClass(alwaysRun = true)
	public void beforeLogin() {
		
		driver.get("https://alchemy.hguy.co/lms");
		
	}
	
	
	@Test(priority = 0)
	public void verifyPageTitle() {
		
		//Get the Page Title 
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		//Check pageTitle matches with  “Alchemy LMS – An LMS Application '' exactly
		//Assert.assertEquals(pageTitle, "Alchemy LMS – An LMS Application");
		Assert.assertEquals(pageTitle, "Alchemy LMS – An LMS Application");		
	}
	
	@Test(priority = 1)
	public void verifyPageHeading() {
		//Get the heading of the webpage
		
		WebElement pageHeading = driver.findElement(By.className("uagb-ifb-title"));
		System.out.println(pageHeading.getText());
		
		Assert.assertEquals(pageHeading.getText(), "Learn from Industry Experts");
		
		
	}
	
	@Test(priority = 2)
	public void verifyTitlefirstInfoBox() {
		
		WebElement titleInfoBox = driver.findElement(By.xpath("//h3[normalize-space()='Actionable Training']"));
		Assert.assertEquals(titleInfoBox.getText(), "Actionable Training");
		
	}
	
	
	@Test(priority = 3)
	public void VerifyTitleMostPop2Course() {
		
		WebElement courseTitle = driver.findElement(By.xpath("//h3[normalize-space()='Email Marketing Strategies']"));
		
		Assert.assertEquals(courseTitle.getText(), "Email Marketing Strategies");
		
	}
	
	@Test (priority = 4)
	public void navigateToMyAccout() {
		
		WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount.click();
		
		//Print and verify that Page Title after clicking on the My Account button.
		System.out.println("Page Title:" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
	
	}
	
	
	@Test(priority = 5, dependsOnMethods = {"navigateToMyAccout"})
	@Parameters({"username","password"})
	public void loginToSite(String username, String password) {
		
		WebElement loginBtn = driver.findElement(By.linkText("Login"));
		loginBtn.click();
		
		WebElement usernameField = driver.findElement(By.id("user_login"));
		WebElement passwordField = driver.findElement(By.id("user_pass"));
		WebElement userloginBtn = driver.findElement(By.id("wp-submit"));
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		
		userloginBtn.click();		
		
	}
	
	
	@Test(priority = 6, dependsOnMethods = {"loginToSite"} )
	
	public void countTotalCourses() {
		
		WebElement linkAllCourse = driver.findElement(By.xpath("//a[text()='All Courses']"));
		linkAllCourse.click();
		
		
		//int count = driver.findElements(By.xpath("//div[contains(@class, 'ld-course-list-content')]//div[conatins(@class, 'ld_course_grid')]")).size();
		
		
		//WebElement countTotCourse = driver.findElement(By.className("p"));
		//System.out.println("Total courses available on LMS: " + count);
		
		List<WebElement> courses = driver.findElements(
			    By.cssSelector("div[id^='ld-course-list-content'] .ld_course_grid")
			);

			System.out.println("Total courses: " + courses.size());

		
	}
	
	
	@Test(priority = 7, dependsOnMethods = {"verifyPageHeading"})
	public void contactToAdmin() {
		
		WebElement contact = driver.findElement(By.xpath("//a[text()='Contact']"));
		contact.click();
		
		WebElement fullName = driver.findElement(By.id("wpforms-8-field_0"));
		WebElement email = driver.findElement(By.id("wpforms-8-field_1"));
		
		WebElement subject = driver.findElement(By.id("wpforms-8-field_3"));
		
		WebElement commentBox = driver.findElement(By.id("wpforms-8-field_2"));
		
		WebElement submitBtn = driver.findElement(By.id("wpforms-submit-8"));
		
		fullName.sendKeys("TEST");
		email.sendKeys("test@ibm.com");
		subject.sendKeys("Login Test");
		
		commentBox.sendKeys("Unable to login into LMS");
		
		submitBtn.click();
		
		
		WebElement displayMsg = driver.findElement(By.className("uagb-column__overlay"));
		String message =displayMsg.getText();
		
		System.out.println("Disaply Message = " + message);
		
		
	}
	
	
	@Test (priority =8, groups = {"Test"} , dependsOnMethods = {"loginToSite"})
	public void markComplete() {
		
		
		WebElement linkAllCourse = driver.findElement(By.xpath("//a[text()='All Courses']"));
		linkAllCourse.click();
		
		WebElement seeMoreBtn = driver.findElement(By.xpath("(//p[contains(@class,'ld_course_grid_button')]//a[normalize-space()='See more...'])[1]"));
		seeMoreBtn.click();
		
		
		driver.findElement(By.xpath("//div[normalize-space()='Expand All']")).click();
		
		//driver.findElement(By.xpath("//a[contains(@class,'ld-topic-row')]//span[normalize-space()='Relationships']\r\n"+ "").click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement relationships = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//a[contains(@class,'learndash-incomplete')]//span[normalize-space()='Relationships']")
		    )
		);

		relationships.click();
		
		
		

		WebElement submitBtn = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//input[@type='submit' and contains(@class,'learndash_mark_complete_button')]")
		    )
		);

		submitBtn.click();

		
		
		
		
		
		
		
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	

}
