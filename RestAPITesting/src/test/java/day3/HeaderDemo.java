package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class HeaderDemo {

	@Test
	public void getHeaderDetails() {
		given()
		
		.when()
		 .get("https://www.google.com/")
		.then()
		 .header("Content-Type", "text/html; charset=ISO-8859-1")
		 .and()
		 .header("Content-Encoding", "gzip")
		 .and()
		 .header("Server", "gws");
	}
	
	@Test
	public void getallHeaderData() {
		Response res=given()
		.when()
		 .get("https://www.google.com/");
	
		System.out.println(res.getHeader("Content-Type"));
		
	Headers	headerslist=res.getHeaders();
	for (Header h : headerslist) {
		System.out.println(h.getName()+"  "+h.getValue() );
		
	}
	
		
		
		
	}
}
