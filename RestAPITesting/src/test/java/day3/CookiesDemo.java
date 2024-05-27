package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	@Test
	public void  testCookies() {
		given()
		
		.when()
		     .get("https://www.google.com/")
		.then()
		.cookie("AEC","AQTF6Hxs1xJQbrjFQwEup3Rt_r-r4reHne18OxMWk_-YRlnelMDmtxqXHdU")
		.log().all();
		
	}
	
	@Test
	public void getCookiesInfo() {
		
		Response res=given()
		
		.when()
		 .get("https://www.google.com/");
		 //get single cookie value
		
		String	cookieVar= res.getCookie("AEC");
	    System.out.println(cookieVar);
	 
		 //get all cookie information
	    
	Map<String,String>  data=res.getCookies();
		
	 System.out.println(data.keySet());
	 
	 for(String s:data.keySet()) {
		 System.out.println(s+"--> "+res.getCookie(s));
	 }
	 
		}
}
