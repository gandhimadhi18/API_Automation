package tests;
import java.net.URL;
import java.net.HttpURLConnection;
import org.testng.annotations.Test;

public class JavaConnectionTest {

	 @Test
	    public void connectionTest() throws Exception 
	 	{

	        URL url = new URL("https://reqres.in/api/users");

	        HttpURLConnection connection =
	                (HttpURLConnection) url.openConnection();

	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(10000);
	        connection.setReadTimeout(10000);

	        System.out.println("Response Code: "
	                + connection.getResponseCode());

	        connection.disconnect();
	    }
}
