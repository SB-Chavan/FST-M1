package GitHub;

import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubSSHKeyTest {
	
	RequestSpecification requestSpec;
	//Uncomment String-sshKey
	
	// 2 Variable 1 String and 1 int /
	//String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGbTXDqfUU+bZYgzs+3ypWuC6G+9p58bcYr58/fo/jl2";
	int keyId;
	
	@BeforeClass
	public void setup() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://api.github.com")
				.setContentType("application/json")
				.addHeader("Authorization", "token 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")
				.build();
		
		RestAssured.requestSpecification =requestSpec;
		
	}
	
	
	//===========POST REQUEST========================
	@Test(priority = 1)
	public void addSSHKey() {
		
		String requestBody = "{\n"+
				"  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}"; 
		
		
		
		Response response = given()
				.body(requestBody)
				.when()
				.post("/user/keys")
				.then()
				.extract().response();
		
		
		//Report printing 
		
		Reporter.log("POST Response: " + response.asString(), true);

		
		// Extract key ID from respons
        keyId = response.jsonPath().getInt("id");
        
        // Assertions status code --> 201
        Assert.assertEquals(response.getStatusCode(), 201);
		
	}
	
	
	
	
	@Test(priority = 2)
	public void getSSHKey() {
		
		Response response =given()
                        .pathParam("keyId", keyId)
                        .when()
                        .get("/user/keys/{keyId}")
                        .then()
                        .extract().response();

        Reporter.log("GET Response: " + response.asString(), true);

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), keyId);
		
	}
	
	
	@Test(priority = 3)
	public void deleteSSHKey() {
		
		Response response =given()
                        .pathParam("keyId", keyId)
                        .when()
                        .delete("/user/keys/{keyId}")
                        .then()
                        .extract().response();

        Reporter.log("DELETE Response Status: " + response.getStatusCode(), true);

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 204);
		
	}
	
	
	

}
