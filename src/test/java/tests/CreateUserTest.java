package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import api.UserAPI;
import base.BaseTest;

public class CreateUserTest extends BaseTest{
	 @Test
	    public void createUserTest() {

	        // Create UserAPI object using requestSpec
	        UserAPI user = new UserAPI(requestSpec);

	        // Send POST request
	        Response response =
	                user.createUser("Gandhi", "QA Engineer");

	        // Print response
	        System.out.println("Status Code: "
	                + response.getStatusCode());

	        System.out.println("Response Body: "
	                + response.asPrettyString());

	        // Validate response
	        Assert.assertEquals(response.getStatusCode(), 201);

	        Assert.assertEquals(
	                response.jsonPath().getString("name"),
	                "Gandhi");

	        Assert.assertNotNull(
	                response.jsonPath().getString("id"));
	    }
	

}
