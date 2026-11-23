package base;
import org.testng.annotations.BeforeClass;

import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	protected RequestSpecification requestSpec;

	@BeforeClass
	public void setup()
	{
		if(Config.API_KEY == null || Config.API_KEY.isBlank())
		{
			throw new IllegalStateException("ReqRes API Key is missing");
			
		}
		requestSpec = new RequestSpecBuilder()
				.setBaseUri(Config.BASE_URI)
				.addHeader("x-api-key", Config.API_KEY)
				.addHeader("Content-Type", "application/json")
				.addHeader("Accept", "application/json")
				.build();
			
	}
}
