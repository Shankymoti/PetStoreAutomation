package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
@Test(priority=1, dataProvider="data", dataProviderClass=DataProviders.class)
public void testPostuser(String id, String username, String firstname, String lastname, String email, String pwd, String phone)	{
	
	User userPayload = new User();
	
	
	userPayload.setId(Integer.parseInt(id));
	userPayload.setUsername(username);
	userPayload.setFirstName(firstname);
	userPayload.setLastName(lastname);
	userPayload.setEmail(email);
	userPayload.setPassword(pwd);
	userPayload.setPhone(phone);
	
	
	Response response = UserEndPoints.createUSer(userPayload);
	response.then().log().all();
	AssertJUnit.assertEquals(response.getStatusCode(), 200);
}


@Test(priority=2, dataProvider="username", dataProviderClass=DataProviders.class)
public void testDeleteUser(String username) {
	Response response =  UserEndPoints.deleteUser(username);
	
	AssertJUnit.assertEquals(response.getStatusCode(), 200);
}


}
