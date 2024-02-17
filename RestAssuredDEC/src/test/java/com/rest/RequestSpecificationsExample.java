package com.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
	

public class RequestSpecificationsExample {
	RequestSpecification requestspecification;
	
	@BeforeClass
	public void before_class()
	{ /*requestspecification = given(). //given and with are same
	baseUri("https://api.postman.com").
	header("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f").log().all();*/
		
		RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();
		requestspecbuilder.setBasePath("https://api.postman.com");
		requestspecbuilder.addHeader("X-Api-Key","PMAK-6573666cf63a78099339d955-1c5ccd08efab4d7d3471450bd8fa4d797f");
		
		requestspecification = requestspecbuilder.build();
		
	}
	@Test
	public void validate_status_code()
	{
		Response response = given().spec(requestspecification).get("/workspaces").then().log().all().extract().response();
		assertThat(response.statusCode(), is(equalTo(200)));
		
	}
    @Test
   
	public void validate_responce_body()
    {Response response = given().spec(requestspecification).get("/workspaces").then().log().all().extract().response();
	assertThat(response.statusCode(), is(equalTo(200)));
	assertThat(response.path("workspaces[0].name").toString(), equalTo("My Workspace"));

		
	}
	
	    
	}

