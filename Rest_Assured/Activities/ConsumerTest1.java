package activities;

package activities;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.core.model.RequestResponsePact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest1 {

    // Contract JSON body
    PactDslJsonBody reqResBody = new PactDslJsonBody()
            .numberType("id", 123)
            .stringType("firstName", "Sagar")
            .stringType("lastName", "Chavan")
            .stringType("email", "sagar.chavan87483@gmail.com");

    // Create the contract(Pact)
    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {

        return builder
                .given("POSTRequest")
                .uponReceiving("A request to add data")
                .method("POST")
                .path("/api/path")
                .body(reqResBody)
                .willRespondWith()
                .status(200)
                .body(reqResBody)
                .toPact();
    }

    // Consumer test with mock provider
    @Test
    @PactTestFor(providerName = "UserProvider", port = "9000")
    public void postRequestTest() {

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 123);
        reqBody.put("firstName", "Sagar");
        reqBody.put("lastName", "Chavan");
        reqBody.put("email", "sagar.chavan87483@gmail.com");

        given()
                .baseUri("http://localhost:9000")
                .basePath("/api/path")
                .body(reqBody)
                .log().all()
        .when()
                .post()
        .then()
                .statusCode(200)
                .body("lastName", equalTo("Chavan"))
                .log().all();
    }
}