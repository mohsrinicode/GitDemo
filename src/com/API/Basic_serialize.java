package com.API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojoadd.Location;
import pojoadd.place;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import com.payload.payloads;

public class Basic_serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stubs

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		place p = new place();
		
		p.setAccuracy(60);
		p.setAddress("Vellore");
		p.setLanguage("Tamil");
		p.setName("mohsrini");
		p.setWebsite("WWW.google.com");
		p.setPhone_number("9944467500");
		List<String> mylist = new ArrayList();
		mylist.add("My shop");
		mylist.add("home");
		p.setTypes(mylist);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);

		String responseString = given().log().all().queryParam("key", "qaclick123")
			.body(p).when().post("/maps/api/place/add/json").then().log()
				.all().assertThat().statusCode(200).extract().response().asString();
		JsonPath jp = new JsonPath(responseString);
		String Place_id = jp.getString("place_id");

		System.out.println("Place id ------------------------------->" + Place_id);

		/*
		 * String responseString
		 * =given().log().all().queryParam("key","qaclick123").header("Content-Type",
		 * "Application/json")
		 * .body(payloads.addPayload()).when().post("/maps/api/place/add/json").then().
		 * log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		 * .extract().response().asString();
		 * 
		 * JsonPath jp = new JsonPath(responseString); String
		 * Place_id=jp.getString("place_id");
		 * 
		 * System.out.println("Place id ------------------------------->"+Place_id);
		 */

	}

}
