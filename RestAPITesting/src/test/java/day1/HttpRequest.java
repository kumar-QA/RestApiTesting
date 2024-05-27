package day1;


import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HttpRequest {
	String id;
//	@Test()
//	public void getuser() {
//		id=given()
//		.when()
//		 .get("http://localhost:3000/employee/9fc0")
//		 .jsonPath().getString("id");
//		 
//		 
//	}
	int sal;
	
	@Test
	public void getusers() {
	Response res=given()
			.contentType("contentType.JSON")
		.when()
		 .get("http://localhost:3000/employee");
	System.out.println(res.getStatusCode());
       System.out.println();
       System.out.println(res.jsonPath().getString("[1].Salary"));

	
//		 .then()
//		 .statusCode(200)
//		 .log().all();
//		 .extract().path("employee[4].empSal");
//
//		 System.out.println("5 the emp sal is "+sal);
	}
	
//
//	@Test
//	public void createUser() {
//		HashMap hm=new HashMap();
//		hm.put("name", "morpheus");
//		hm.put("job","leader");
//		
//		given()
//		.contentType("application/json").body(hm)
//		.when()
//		.post("https://reqres.in/api/users")
//		.then()
//		.statusCode(201)
//		.body("name",equalToIgnoringCase("morpheus"))
//		.log().all();
//	}
//	
//	//Api chaniing
//	
//	@Test
//	public void creatNewUser() {
//		HashMap data=new HashMap();
//		data.put("empName","prasanna");
//		data.put("empSal", 40000);
//		data.put("empdes", "Api Tester");
//		id=given()
//		.contentType("application/json").body(data)
//		.when()
//		.post("http://localhost:3000/employee")
//		.jsonPath().getString("id");
//	}
//	
//	@Test(dependsOnMethods = "getusers")
//	public void updateUser() {
//		HashMap data=new HashMap();
//		data.put("empName","pramodkumar");
//		given()
//		.contentType("application/json")
//		.body(data)
//		.when()
//		.patch("http://localhost:3000/employee/"+id)
//		.then()
//		.statusCode(200).log().all();
//	}
	
}
