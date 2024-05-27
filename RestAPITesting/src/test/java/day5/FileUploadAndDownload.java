package day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.json.JSONArray;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FileUploadAndDownload {

	
	@Test(enabled = false)
	public void SingleFile_upload() {
		  File f=new File("D:\\Prasanna\\JSONFiles\\Myintro.txt");
		given()
         .multiPart("file",f)
         .contentType("multipart/form-data")
		.when()
		   .post("http://localhost:8080/uploadFile")
		.then()
		.statusCode(200)
		.body("fileName",equalTo("Myintro.txt"))
		.log().all();
		
		
	}
	@Test(enabled = false)
	public void MultipleFile_upload_validateNames() {
		 File f1=new File("D:\\Prasanna\\JSONFiles\\dev.json");
		 File f2=new File("D:\\Prasanna\\JSONFiles\\books.json");
	      given()
         .multiPart("files",f1)
         .multiPart("files",f2)
         .contentType("multipart/form-data")
		.when()
		   .post("http://localhost:8080/uploadMultipleFiles")
		   .then()
		   .statusCode(200)
		   .body("[0].fileName",equalTo("dev.json"))
		   .body("[1].fileName",equalTo("books.json"))
		   .log().body();
		
	
		   
		
	}
	
	
	@Test(enabled = false)
	public void MultipleFile_upload_printTheNames() {
		 File f1=new File("D:\\Prasanna\\JSONFiles\\dev.json");
		 File f2=new File("D:\\Prasanna\\JSONFiles\\books.json");
	Response	 res=given()
         .multiPart("files",f1)
         .multiPart("files",f2)
         .contentType("multipart/form-data")
		.when()
		   .post("http://localhost:8080/uploadMultipleFiles");
		
	//**********To print the names of multiple uploaded Files**********************
		JSONArray ja=new JSONArray(res.asString());
		for (int i = 0; i < ja.length(); i++) {
			String keys=ja.getJSONObject(i).getString("fileName").toString();
			System.out.println(keys);		
		}
	}
	
	@Test(enabled = false)
	public void DownloadFile() {
		given()
		.when()
		 .get("http://localhost:8080/downloadFile/Myintro.txt")
		.then()
		.statusCode(200)
		.log().body();
		
	}
	
	//**********THROUGH API Chaning******************
	
	
	String downloadUrl="";
	@Test(priority = 1)
	public void fileUploadfor_ApiChaining_step1() {
		  File f=new File("D:\\Prasanna\\JSONFiles\\Myintro.txt");
		downloadUrl=given()
	         .multiPart("file",f)
	         .contentType("multipart/form-data")
			.when()
			   .post("http://localhost:8080/uploadFile")
		       .jsonPath().getString("fileDownloadUri");
		System.out.println(downloadUrl);
	}
	

	@Test(priority = 2)
	public void DownloadFile_passurl_Through_Api_chanining_step2() {
		given()
		.when()
		 .get(downloadUrl)
		.then()
		.statusCode(200)
		.log().body();
		
	}
}

