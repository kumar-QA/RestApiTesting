package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

public class ParsingXMLResponse {

	@Test
	public void testXMLResponse_Approach1() {
		given().when().get("https://thetestrequest.com/authors.xml").then().statusCode(200)
				.header("Content-Type", "application/xml; charset=utf-8")
				.body("objects.object[0].name", equalTo("Karl Zboncak"));

	}

	@Test
	public void testXMLResponse_Store_In_varaible() {
		Response res = given().when().get("https://thetestrequest.com/authors.xml");
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		String result = res.xmlPath().get("objects.object[0].name").toString();
		System.out.println(result);
		Assert.assertEquals(result, "Karl Zboncak");

	}

	boolean status = false;
	@Test
	public void testXMLResponse_order_changed_index_changed() {
		Response res = given().when().get("https://thetestrequest.com/authors.xml");
		XmlPath xmlobj = new XmlPath(res.asString());
		List<Object> individualvalues = xmlobj.getList("objects.object.name");
		// verify total number of objects
		Assert.assertEquals(individualvalues.size(), 5);
		// find particular name exist or not
		for (int i = 0; i < individualvalues.size(); i++) {
			String name = individualvalues.get(i).toString();
			System.out.println(name);
			if (name.equalsIgnoreCase("Gracia Keeling")) {
				status = true;
				System.out.println(name + "  is exist in the list");
				break;
			}
		}
		Assert.assertEquals(true, status);
	}

	
}
