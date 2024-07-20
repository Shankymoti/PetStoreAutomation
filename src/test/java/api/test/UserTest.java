package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		 faker = new Faker();
	     userPayload =  new User();
	    
	     
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		// Logs
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testPostRequest() {
		logger.info("==========Creation starts=================");
		Response response = UserEndPoints.createUSer(userPayload);
		response.then().log().all();
	    AssertJUnit.assertEquals(response.getStatusCode(),200);
	    logger.info("==============creation END======================");
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		logger.info("====GET the user details==========================");
		Response response =UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3)
	public void testUpadteUserByName() {
		
		//update 
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response =UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body().statusCode(200);
		//response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		Response updatedResponse =UserEndPoints.readUser(this.userPayload.getUsername());
        updatedResponse.then().log().all();
		AssertJUnit.assertEquals(updatedResponse.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		Response response =UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}

}
