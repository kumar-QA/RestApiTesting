package day6;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers;

public class XmlSchemaValidator {
	
	@Test
	public void schema_validator_XML() {
		given()
		.when()
          .get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("schema-definition.xsd"));

	}

}
