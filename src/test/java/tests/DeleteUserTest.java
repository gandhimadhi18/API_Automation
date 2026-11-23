package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.UserAPI;
import base.BaseTest;
import io.restassured.response.Response;

public class DeleteUserTest extends BaseTest{

	@Test
	public void deleteUserTest()
	{
		UserAPI user = new UserAPI(requestSpec);
		Response response = user.deleteUser(2);
		System.out.println("Status:" + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 204);
	}
}
