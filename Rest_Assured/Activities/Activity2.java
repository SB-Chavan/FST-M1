package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity2 {
	
	
	@BeforeClass
	public void setup() {
		
	}
	
	@Test(priority = 1)
	public void addUser() throws IOException {
		
		FileInputStream inputJSON = new FileInputStream("src/test/java/activities/userInfo.json");
				
		Response res = given()
				.baseUri("https://petstore.swagger.io/v2/user")
				.header("Content-Type", "application/json")
				.body(inputJSON)
				.when().post();
	
		inputJSON.close();
		 
		// Assertion
	
		res.then().body("code", equalTo(200));
		res.then().body("message", equalTo("1188"));
		
		
	}
	
	
	@Test(priority = 2)
	public void getUserInfo() {
		
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");
		
		Response res = given()
	
			.baseUri("https://petstore.swagger.io/v2/user") 
			.header("Content-Type", "application/json") 
			.pathParam("username", "chavansagar") 
			.when().get("/{username}");
		
		String responseBody = res.getBody().asPrettyString();
		
		try {
			
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(responseBody);
			writer.close();
	
		} catch (IOException excp) {
	
			excp.printStackTrace();
	
		}
		
		// Assertion
		
		res.then().body("id", equalTo(1188));
		res.then().body("username", equalTo("chavansagar"));
		res.then().body("firstName", equalTo("Sagar"));
		res.then().body("lastName", equalTo("Chavan"));
		res.then().body("email", equalTo("chavansagar@mail.com"));
		res.then().body("password", equalTo("password123"));
		res.then().body("phone", equalTo("9561189294"));
		
		
		
	}
	
	@Test(priority = 3)
	public void deleteUser() {
		Response res = given()
				
				.baseUri("https://petstore.swagger.io/v2/user") 
				.header("Content-Type", "application/json") 
				.pathParam("username", "chavansagar") 
				.when().delete("/{username}");
		
		// Assertion
		res.then().body("code", equalTo(200));
		res.then().body("message", equalTo("chavansagar"));
		
		
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		
	}

}
