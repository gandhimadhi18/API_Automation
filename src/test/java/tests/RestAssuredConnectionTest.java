package tests;

import org.testng.annotations.Test;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredConnectionTest {
//	@Test
//    public void restAssuredConnectionTest() {
//
//        Response response = RestAssured
//                .given()
//                .get("https://reqres.in/api/users");
//
//        System.out.println("Status Code: " +
//                response.getStatusCode());
//
//        System.out.println("Response Body: " +
//                response.asPrettyString());
//    }
	
	@Test
	public void postConnectionTest() {

	    String body = "{\n" +
	            "  \"name\": \"Gandhi\",\n" +
	            "  \"job\": \"QA Engineer\"\n" +
	            "}";

	    Response response = RestAssured
	            .given()
	            .baseUri("https://reqres.in")
	            .header("Content-Type", "application/json")
	            .header("x-api-key", Config.API_KEY)
	            .body(body)
	            .when()
	            .post("/api/users");

	    System.out.println("POST Status Code: "
	            + response.getStatusCode());

	    System.out.println(response.asPrettyString());
	    System.out.println("API key available:" + (Config.API_KEY != null && !Config.API_KEY.isEmpty()));
	}

}
