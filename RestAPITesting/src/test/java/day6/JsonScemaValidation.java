package day6;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonScemaValidation {

	
	@Test
	public void  schemaValidation_for_JSON() {
		
		given()
		.when()
          .get("http://localhost:3000/employee")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("employeeschema.json"));
	}
	

}
