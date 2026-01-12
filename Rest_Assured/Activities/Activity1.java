package activities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity1 {
	
	
	
	@BeforeClass
	public void setup() {
		
	}
	
	@Test(priority = 1)
	public void addNewPet() {
		
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("id", 77334);
		requestBody.put("name", "Cat");
		requestBody.put("status", "alive");
		
		
		Response res = given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json")
				.body(requestBody)
				.when().post();
		
		// Assertion
		res.then().body("id", equalTo(77334));
		res.then().body("name", equalTo("Cat"));
		res.then().body("status", equalTo("alive"));
		
		
	}
	
	@Test(priority = 2)
	public void getPetInfo() {
		Response res = given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json")
				.when().pathParam("petId", 77334)
				.get("/{petId}");
		
		res.then().body("id", equalTo(77334));
		res.then().body("name", equalTo("Cat"));
		res.then().body("status", equalTo("alive"));
		
		
	}
	
	@Test(priority = 3)
	public void deletePet() {
		Response res = given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json")
				.when().pathParam("petId", 77334)
				.delete("/{petId}");
		
		//Assertion
		res.then().body("code", equalTo(200));
		res.then().body("message", equalTo("77334"));
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
		
	}
	

}
