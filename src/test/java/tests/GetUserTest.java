package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.UserAPI;
import base.BaseTest;
import io.restassured.response.Response;

public class GetUserTest extends BaseTest {

	@Test
	public void getUserTest()
	{
		UserAPI user = new UserAPI(requestSpec);
		Response response = user.getUser(2);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);
	}
}
