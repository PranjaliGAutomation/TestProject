package com.rest;
import static org.testng.AssertJUnit.assertThat;
import static org.testng.AssertJUnit.assertThat;

import java.io.ObjectInputFilter.Config;
import java.lang.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matcher;
import org.testng.Assert;

import groovy.util.ConfigObject;
import io.restassured.config.LogConfig;
import io.restassured.config.LogConfig.*;
import io.restassured.internal.http.AuthConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
	

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import org.testng.annotations.Test;
//import static io.restassured.matcher.RestAssuredMatchers.*;


public class AutomateGet {
  private Object config;

/*@org.testng.annotations.Test
	public void validate_get_status_code(){   
		given().
		baseUri("https://api.postman.com").
		header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
			
		when().
		get("/workspaces").
		
		then().
		log().all().
		assertThat().
		statusCode(200);
		
	}
@org.testng.annotations.Test
public void validate_responce_body() {
	given().
	baseUri("https://api.postman.com").
	header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
		
	when().
	get("/workspaces").
	
	then().
	log().all().
	assertThat().
	statusCode(200).
	body("workspaces.name",hasItems("My Workspace","MyWorkspace"),
			"workspaces.type",hasItems("personal","personal"),
	         "workspaces.name[0]",equalTo("My Workspace"),
	         "workspaces.name[0]",is(equalTo("My Workspace")),
	         "workspaces.size()",equalTo(2));
	
	         
}
@org.testng.annotations.Test
public void extract_responce()

{
	Response res = given().
	baseUri("https://api.postman.com").
	header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
		
	when().
	get("/workspaces").
	
	then().
	assertThat().
	statusCode(200).
	extract().
	response();
	System.out.println("Responce=" + res.asString());
	
}
@org.testng.annotations.Test
public void extract_simple_responce()

{
	String name = given().
	baseUri("https://api.postman.com").
	header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
		
	when().
	get("/workspaces").
	
	then().
	assertThat().
	statusCode(200).
	extract().
	response().path("workspaces[1].name");
	
	System.out.println("workspaces name = " + name);

	//System.out.println("workspaces name = " + JsonPath.from(res).getString("workspaces[1].name"));
	
	//JsonPath jsonpath= new JsonPath(res.asString());
	//System.out.println("workspaces name = " + jsonpath.getString("workspaces[1].name"));
	
	//System.out.println("workspaces name = " + res.path("workspaces[0].name"));
	
}

@org.testng.annotations.Test
public void assert_on_extracted_responce()

{
	String name = given().
	baseUri("https://api.postman.com").
	header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
		
	when().
	get("/workspaces").
	
	then().
	assertThat().
	statusCode(200).
	extract().
	response().path("workspaces[1].name");//WE are extracting workspace name and cllecting in the string name
	
	
	System.out.println("workspaces name = " + name);
	//assertThat(name,equalTo("MyWorkspace"));   //Using hamcrest
	Assert.assertEquals(name, "MyWorkspace" );    // using testng

}

@org.testng.annotations.Test
public void validate_response_body_hamcrest_responce() //video 61

{
    given().
	baseUri("https://api.postman.com").
	header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
		
	when().
	get("/workspaces").
	
	then().
	log().all().
	assertThat().
	statusCode(200).
	//body("workspaces.name",contains("MyWorkspace", "My Workspace"));
	
	//body("workspaces.name",containsInAnyOrder("My Workspace","MyWorkspace"),
	//"workspaces.name",is(not(empty()))); // It is for collection so it is generic check
    
    body("workspaces.name",containsInAnyOrder("My Workspace","MyWorkspace"),
    		"workspaces.name",is(not(emptyArray())),
    		"workspaces.name",hasSize(2),
    		"workspaces.name", everyItem(startsWith("My")),
//    		MAP
    		
    		"workspaces[0]",hasKey("id"),
    		"workspaces[0]",hasValue("My Workspace"),
    		"workspaces[0]",not(equalTo(Collections.EMPTY_MAP)),
    		
    		//String
    		
    		"workspaces[0].name", allOff(startsWith("My"),containsString("workspace"))
    		
    		);
   
    
 
}

}


	@org.testng.annotations.Test
	public void request_responce_logging() //video 61

	{
	    given().
		baseUri("https://api.postman.com").
		header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
		log().headers().	
		
		when().
		get("/workspaces").
		
		then().log().cookies(). //to print logs ,use log mtd
		log().all().
		assertThat().
		statusCode(200);

	} */
   
@org.testng.annotations.Test
public void only_if_there_is_error()
   {  Set<String> headers = new HashSet<String>();
      headers.add("X-Api-Key");
   
		given().
		baseUri("https://api.postman.com").
		header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").
		//log().ifValidationFails().
		
		config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers))).
		
		//config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
		//when dont want to put if validatinFails on request and responce method then this one mtd shown.
		
		
		//config(config.logConfig(LogConfig.logConfig().blacklistHeader("X-Api-Key"))).//when dont want to show a header then use this method.
		log().all().
		
		when().
		get("/workspaces").
		
		then().
		//log().ifValidationFails().
		assertThat().
		statusCode(200);
		
		
		
   }
   }


