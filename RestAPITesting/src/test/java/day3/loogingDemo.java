package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class loogingDemo {
	
    @Test
    public void testLog() {
    	given()
    	.when()
    	.get("https://reqres.in/api/users?page=2&id=9")
    	.then()
//    	.log().body();
//    	.log().cookies();
//    	.log().headers();
    	.log().all();
    }
}
