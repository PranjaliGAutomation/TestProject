package day1;
import java.util.HashMap;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HTTPRequest {

	//int id;
	//@Test
	void getUsers()
	{
		given()
		
		.when()
		     .get("https://reqres.in/api/users?page=2")

		.then()
		     .statusCode(200)
		     .body("page",equalTo(2))
		     .log()
		     .all();
			
	}
	
	
	@Test
	
	void createUser()
	{
		
		HashMap data = new HashMap();
		data.put("Name","Pavan");
		data.put("Job","Trainee");
		
		
	     given()
		 .contentType("application/json")
		 .body(data)
		 
	    .when()
		 .get("https://reqres.in/api/users")
		 //.jsonPath().getInt("id");
		 .then()
		 .statusCode(201)
		 .log().all();	
		
	}
	
	/*void updateUser()
	{
		HashMap data = new HashMap();
		data.put("Name","John");
		data.put("Job","Teacher");
		
		
		id=given()
		 .contentType("application/json")
		 .body(data)
		 
	    .when()
		 .put("https://reqres.in/api/users"+id)
		 .jsonPath().getInt("id");
		 .then()
		 .statusCode(201)
		 .log().all();	
		
	}*/
	} 
	

