package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.UserAPI;
import base.BaseTest;
import io.restassured.response.Response;

public class UpdateUserTest extends BaseTest{

	@Test
	public void updateUserTest()
	{
	UserAPI user = new UserAPI(requestSpec);
	Response response = user.updateUser(2, "Senior QA");
	System.out.println(response.asPrettyString());
	Assert.assertEquals(response.getStatusCode(), 200);
	Assert.assertEquals(response.jsonPath().getString("job"), "Senior QA");
}
}
