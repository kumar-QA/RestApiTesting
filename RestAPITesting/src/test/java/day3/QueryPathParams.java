package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryPathParams {
	
	@Test
	public void testQuerypath() {
		given()
		.pathParam("mypath", "users")
		.queryParam("page",2)
		.queryParam("id", 9)
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.statusCode(200)
		.log().all();
	}

}
