package com.API;

import com.payload.payloads;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath jp = new JsonPath(payloads.CoursePrice());
		
		//1. Print No of courses returned by API
		
		int NumOfCourse =jp.getInt("courses.size()");
		System.out.println("Number of course ----->"+NumOfCourse);
		
		//2.Print Purchase Amount
		
		int purchase_amount =jp.getInt("dashboard.purchaseAmount");
		System.out.println("Number of Total Amount ----->"+purchase_amount);
		
		//3. Print Title of the first course
		
		String course_title =jp.getString("courses[0].title");
		System.out.println("First course title------------>"+course_title);
		
		//Print All course titles and their respective Prices
		
		for(int i=0;i<NumOfCourse;i++)
		{
			System.out.println("Course title"+jp.getString("courses["+i+"].title")+"-------->"+"Course pricer-------->"+jp.getString("courses["+i+"].price"));
		}
		
		
		// Print no of copies sold by RPA Course
		
		int numOfCopies=jp.getInt("courses[2].copies");
		System.out.println("Number of copies by RPA---------->"+numOfCopies);
		
		for(int i=0;i<NumOfCourse;i++)
		{
			String CourseTile="Course title"+jp.getString("courses["+i+"].title");
			if(CourseTile.equals("RPA"))
			{
				int price=jp.getInt("\"courses["+i+"].price");
				System.out.println("Price for RPA---------->"+price);
				break;
			}
			
		}
		
		 int totalprice=0;

      // Verify if Sum of all Course prices matches with Purchase Amount
		for(int i=0;i<NumOfCourse;i++)
		{
			int copies=jp.getInt("courses["+i+"].copies");
		    int pricer=jp.getInt("courses["+i+"].price");
		    int temp=copies*pricer;
		    totalprice=totalprice+temp;
		}
		
		System.out.println("total price of all the copies------"+totalprice);
		
		
		

	}

}
