package api;

import static io.restassured.RestAssured.given;

import base.BaseTest;
import config.Config;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserAPI extends BaseTest{

	private RequestSpecification requestSpec;
	
	public UserAPI(RequestSpecification requestSpec)
	{
		this.requestSpec = requestSpec;
	}
	
	//GET
	public Response getUser(int id)
	{
		return given()
				.spec(requestSpec)
				.when()
				.get("/api/users/" + id);
	}

	//POST
	public Response createUser(String name, String job)
	{
		
		String body = "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"job\": \"" + job + "\"\n" +
                "}";

        return given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(Config.USERS_ENDPOINT);
    }
	
	//PATCH
	public Response updateUser(int id, String job)
	{
		return given()
				.spec(requestSpec)
				.body("{\"job\":\"" + job + "\"}")
				.when()
				.patch("/api/users/" + id);
	}
	
	
	
	//DELETE
	
	public Response deleteUser(int id)
	{
		return given()
				.spec(requestSpec)
				.when()
				.delete("/api/users/" + id);
	}
	
}
