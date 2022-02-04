package com.API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.payload.payloads;

public class Training1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * RestAssured.baseURI="https://rahulshettyacademy.com";
		 * given().log().all().queryParam("key",
		 * "qaclick123").queryParam("place_id","b59e93804ccdd525b65d070e52672407").when(
		 * ).get("/maps/api/place/get/json")
		 * .then().log().all().assertThat().statusCode(200).body("accuracy",equalTo(
		 * "501"));
		 */

		// Add place API with Post

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String myresponse = given().log().all().queryParam("key", "qaclick123")
				.header("content-type", "application/json").body(payloads.addPayload()).when()
				.post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.header("Server", "Apache/2.4.18 (Ubuntu)").body("status", equalTo("OK")).extract().response()
				.asString();

		System.out.println("**********************************");
		System.out.println(myresponse);
		System.out.println("**********************************");

		// JSONPath is class
		JsonPath jp = new JsonPath(myresponse);
		String place_id = jp.getString("place_id");
		System.out.print("place id------------" + place_id);

		// Update place API with PUT

		String UpdatedResponse = given().log().all().queryParam("key", "qaclick123")
				.header("content-type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + place_id + "\",\r\n" + "\"address\":\"70 Summer walk, USA\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200).extract()
				.response().asString();

		System.out.println(UpdatedResponse);
		
		//Get API 
		
	String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123").queryParam("place_id",place_id)
		.when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js = new JsonPath(getPlaceResponse);
	String address =js.getString("address");
	System.out.println("updated address "+address);
	
	
		
		

	}

}
