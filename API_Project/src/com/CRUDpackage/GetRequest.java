package com.CRUDpackage;

import org.apache.log4j.Logger;
//import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.response.ValidatableResponse;


public class GetRequest {

 
	private static final Logger log = Logger.getLogger(GetRequest.class.getName());
	    private static final String BASE_URL = "https://reqres.in/api";

	   @Test (priority = 1)
	   public static void getRegresListUsers(){

	       RestAssured.baseURI = BASE_URL;

	        Response response = null;
	        try{
	          response = RestAssured.given().when().get("/users?page=2");
	          response.then().log().all();
	          log.debug(String.valueOf(response.getStatusCode()));
	        } catch (Exception e){
	            log.error(e.toString());
	            
	        }

	        try{
	            Assert.assertEquals(200, response.getStatusCode());
	            log.debug(String.valueOf(response.getStatusCode()));
	        } catch (Exception e) {
	            log.error(e.toString());
	        	//System.out.println(e);
	        }
	    } 

	    @Test (priority = 2)
	    public static void postRegressRegisterSuccessful(){
	        String requestBody = "\"name\": \"ayush\",\r\n"
	        		+ "    \"job\": \"producer\"";

	       Response response = null;
				

	        try{
	            response = RestAssured.given()
	            		.baseUri(BASE_URL)
	                    .body(requestBody)
	                    .post("/users");
	            System.out.println("The response data" +response.asPrettyString());
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        System.out.println(response);
	        
	        try{
	            Assert.assertEquals(201, response.getStatusCode());
	            log.info(String.valueOf(response.getStatusCode()));
	        } catch (Exception e) {
	            //log.error(e.toString());
	        	System.out.println(e);
	        }
	    }

	 
	}

