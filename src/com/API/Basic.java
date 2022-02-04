package com.API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.payload.payloads;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stubs

		RestAssured.baseURI="https://rahulshettyacademy.com";

	
		String responseString =given().log().all().queryParam("key","qaclick123").header("Content-Type", "Application/json")
		.body(payloads.addPayload()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.extract().response().asString();
		
		JsonPath jp = new JsonPath(responseString);
		String Place_id=jp.getString("place_id");
		
		System.out.println("Place id ------------------------------->"+Place_id);
		
	}

}
