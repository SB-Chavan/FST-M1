package appiumProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	AndroidDriver driver;
	WebDriverWait wait;
	
	
	@BeforeTest
	public void setup() throws MalformedURLException, URISyntaxException {
		
		File appFile = new File("src/resources/ts-todo-list-v1.apk");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setApp("path/to/ts-todo-list-v1.apk");
		//options.setApp("appFile.getAbsolutePath()");
		options.setAppPackage("com.app.todolist");   // ✅ required
	    options.setAppActivity("com.app.todolist.view.SplashActivity");
		options.noReset();
		options.getPlatformVersion();
		
		
		//Appium server URL
		URL serverURL = new URI("http://localhost:4723").toURL();	
		
		
		//Intialize android driver
		
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
	}
	
	@Test
	public void test() {
		
		//Click the button to add a new task.
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("fab_new_task")));
		
		driver.findElement(AppiumBy.id("fab_new_task")).click();
		
		//Add the following tasks: //After each task is added, the Save button should be clicked.
		//-Complete Activity 1 with priority high
		
		
		String[] tasks = { "Test1", "Test2", "Test3"};
	    String[] priorities = { "High", "Medium", "Low"};

	    for (int i = 0; i < tasks.length; i++) {

		
		
		
		
		
		
		// WAIT TILL TEXT FIELD TO BE VISIBLE
		//wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name")));
		
		wait.until(
			    ExpectedConditions.elementToBeClickable(
			        AppiumBy.androidUIAutomator(
			            "new UiSelector().resourceIdMatches(\".*new_task.*\")"
			        )
			    )
			).click();
		
		
		
		//ENTER TASK NAME
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        AppiumBy.id("com.app.todolist:id/et_new_task_name")))
		    .sendKeys(tasks[i]);
		//driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_name")).sendKeys(tasks[i]);
		
		
		//WAIT UNTIL PRIORITY BUTTON VISIBLE
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.app.todolist:id/tv_new_task_priority"))).click();
		
		//CLICK AND SELECT HIGH PRIORITY
		//wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"High\")"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"" + priorities[i] + "\")")))
                .click();
		
		driver.findElement(
		        AppiumBy.id("com.app.todolist:id/bt_new_task_ok")
		).click();
		
		
		String l1text= driver.findElement(
		        AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.app.todolist:id/tv_exlv_task_name'])[1]")
		).getText();
		
		System.out.println("Text :" +l1text );
		
		
		
	    }
		//-Complete Activity 2 with priority medium
		//-Complete Activity 3 with priority low
		
		
		
		
		
		//Write an assertion to ensure all three tasks have been added to the list.
		Set<String> actualTexts = new HashSet<>();

		for (String expected : List.of("Test1", "Test2", "Test3")) {

		    WebElement element = driver.findElement(
		            AppiumBy.androidUIAutomator(
		                "new UiScrollable(new UiSelector().scrollable(true))" +
		                ".scrollIntoView(new UiSelector().text(\"" + expected + "\"))")
		    );

		    actualTexts.add(element.getText());
		}

		Assert.assertEquals(actualTexts.size(), 3);
		
		
		
	}
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}
	

	
	

}
