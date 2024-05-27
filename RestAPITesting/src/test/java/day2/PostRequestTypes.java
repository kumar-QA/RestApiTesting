package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
public class PostRequestTypes {
	
	
	//*****************postMethod using Hashmap***********************
//	@Test()
//	public void postUsingHashmap() {
//		HashMap data=new HashMap();
//		data.put("st_name", "ram");
//		data.put("st_fee", 500);
//		data.put("st_phoneNo", 987654321);
//		String courses[]= {"manualTesting","Api Manual"};
//		data.put("st_courses", courses);
//		given()
//		.contentType("application/json")
//		.body(data)
//		.when()
//		.post("http://localhost:3000/student")
//		.then().statusCode(201)
//		.body("st_name",equalTo("ram"))
//		.body("st_courses[1]", equalTo("Api Manual"))
//		.header("Content-Type","application/json")
//		.log().all();
//
//	}
	

	//*****************postMethod using org.json library **********************
	
//	@Test(priority = 1)
//	public void postmethodusingOrg_Json(){
//		JSONObject  data=new JSONObject();
//	data.put("st_name","sham");
//	data.put("st_fee", 500);
//	data.put("st_phoneNo", 987654321);
//	String courses[]= {"manualTesting","Api Manual"};
//	data.put("st_courses", courses);
//		given()
//		.contentType("application/json")
//		.body(data.toString())
//		.when()
//		.post("http://localhost:3000/student")
//		.then().statusCode(201)
//		.body("st_name",equalTo("sham"))
//		.body("st_courses[1]", equalTo("Api Manual"))
//		.header("Content-Type","application/json")
//		.log().all();
//	}
	
	

	//*****************postMethod using pojo**********************
//	@Test
//	public void post_Pojo() {
//		pojo_postRequest data=new pojo_postRequest();
//		data.setSt_name("murali");
//		data.setSt_fee(12000);
//		data.setSt_phoneNo(123498765);
//		String courses[]= {"manual","automation","api","performanceTesting"};
//		data.setSt_courses(courses);
//		
//		given()
//		.contentType("application/json")
//		.body(data)
//		.when()
//		.post("http://localhost:3000/student")
//		.then()
//		.statusCode(201)
//		.body("st_name",equalTo("murali"))
//		.log().all();
//				
//		
//	}
	

	//*****************postMethod using External file library **********************
	
	@Test
	public void PostDataExternalFile() throws FileNotFoundException {
		File f=new File(".\\body.json");
		
		FileReader fr=new FileReader(f);
		JSONTokener j=new JSONTokener(fr);
		JSONObject data=new JSONObject(j);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/student")
		.then()
		.statusCode(201)
		.body("st_name",equalTo("nisar"))
		.log().all();
		
	}
	
	@Test(priority = 2)
	public void deleteUser() {
		given()
		
		.when()
		  .delete("http://localhost:3000/student/e730")
		.then().statusCode(200).log().all();
		
	}
	

}
