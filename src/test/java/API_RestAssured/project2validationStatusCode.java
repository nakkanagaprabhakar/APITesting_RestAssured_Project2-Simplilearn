package API_RestAssured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class project2validationStatusCode {
	
	@Test
	public void test() {
		String url ="https://reqres.in";
		String endPoint = "/api/users?page=2";
		
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.when().get(endPoint);
		Integer actualStatusCode = 200;
		assertEquals(actualStatusCode, res.statusCode(), 200);
	
	}
	@Test
	public void getRequest() {
		String url ="https://reqres.in";
		String endPoint = "/api/users?page=2";
		
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.log().all().get(endPoint);
		System.out.println(res.prettyPrint());
	
	}
	@Test
	public void postRequest() {
		String url ="https://reqres.in";
		String endPoint = "/api/users";
		
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.header("Content-Type","application/json").log().all().body("{\r\n"
				+ "    \"name\":\"sourav\",\r\n"
				+ "    \"age\":28\r\n"
				+ "}").post(endPoint);
		System.out.println(res.prettyPrint());
		
	}
	
	

}
