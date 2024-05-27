package day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class ParsingjsonResponseData {
	  
	
	@Test
	public void validateResponceBody_Type1_using_body() {
		given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/employee")
		.then()
		.statusCode(200)
		.body("[1].Salary",equalTo(2))
		.log().body();
	}
	
	@Test
	public void validateResponceBody_Type2_using_Response() {
	Response	res=given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/Employee_Details/");
	Assert.assertEquals(res.getStatusCode(),200);
	Assert.assertEquals(res.jsonPath().getInt("[1].Salary"), 20000);
	
		
	}
	
	//if record index changed difficult to find  so get all same properties of different objects
	//and loop for that we need to jsonobjecgetInt("[1].Salary"), 20000)
	
	@Test()
	public void validateResponsebody__To_print_allobject_single_properties() {
		
	Response res=given()
		.when()
		.get("http://localhost:3000/employee");
	
	 JSONArray ja=new JSONArray(res.asString());
		for (int i = 0; i <ja.length(); i++) {
			  System.out.println(ja.getJSONObject(i).get("name").toString());
		}
	}
	
	@Test
	public void validateResponceBody_using_JsonArray_jSONObject_objectIndexchanges() {
	Response	res=given()
		.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/employee");
	
	//***Aproach 1**************
	
		//	JsonPath jsonPath=res.jsonPath();
		//	List<String> values = jsonPath.getList("name");
		//	for (int i = 0; i < values.size(); i++) {
		//		System.out.println(values.get(i));
		//	}
	
	//***************Approach 2*************
	
	boolean status=false;
	JSONArray ja = new JSONArray(res.asString());
	 for (int i = 0; i < ja.length(); i++) {
		JSONObject  jo=ja.getJSONObject(i);
		String name = jo.get("name").toString();
		System.out.println("Name: " + name);
		if(name.equals("hemu")) {
			System.out.println(name+"is exist");
			status=true;
			break;
		}
	}
	Assert.assertEquals(true, status);
	}

//****Get the sum of all salary from all object
	
	long total_salaray;
	@Test
	public void validateResponceBody_sumAllobject_singlePropertie() {
	  Response res=given()
	    .when()
	    .get("http://localhost:3000/employee");
          JSONArray ja=new JSONArray(res.asString());
  
          for (int j = 0; j < ja.length(); j++) {
		  int eachvalue=ja.getJSONObject(j).getInt("Salary");
		   total_salaray=total_salaray+eachvalue;
		}
         System.out.println("Total sal of all employess: "+total_salaray);
         Assert.assertEquals(total_salaray,91);
	}
}
