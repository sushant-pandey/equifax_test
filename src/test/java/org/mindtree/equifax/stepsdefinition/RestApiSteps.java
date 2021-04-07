package org.mindtree.equifax.stepsdefinition;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class RestApiSteps {

	private RequestSpecification request;
	private Response response;

	@Given("the endpoint endpoint {string} exists")
	public void the_endpoint_endpoint_exists(String apiUrl) {
		RestAssured.baseURI = apiUrl;
		request = RestAssured.given();
	}

	@When("I create a GET request")
	public void i_create_a_get_request() {
		response = request.get();
	}
	
	@When("I create a DELETE request to delete employee with id {string}")
	public void i_create_a_delete_request_to_delete_employee_with_id(String string) {
	    response = request.delete("/v1/delete/719");
	}
	
	@When("I create a POST request to create employee with details")
	public void i_create_a_post_request_to_create_employee_with_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class, Object.class);
		System.out.println(map);
		JSONObject requestParams = new JSONObject();
		
		for(java.util.Map.Entry<String, String> entry : map.entrySet()) {
			requestParams.put(entry.getKey(), entry.getValue());
		}
		
		response = request.body(requestParams.toString()).post();
	}

	@Then("The response has status code {string}")
	public void the_response_has_status_code(String expectedStatusCode) {
		int responseStatusCode = response.getStatusCode();
		org.junit.Assert.assertEquals(expectedStatusCode, ""+responseStatusCode);
	}

	@Then("The status line shows {string}")
	public void the_status_line_shows(String expectedStatusLine) {
		String actualStatusLine = response.getStatusLine();
		org.junit.Assert.assertEquals(expectedStatusLine, actualStatusLine);
	}
	

	@Then("The response body has following details")
	public void the_response_body_has_following_details(io.cucumber.datatable.DataTable dataTable) {
//		System.out.println(response.asPrettyString());
		JsonPath jsonPath = response.jsonPath();
		Map<String, String> map = dataTable.asMap(String.class, Object.class);
		for(java.util.Map.Entry<String, String> entry : map.entrySet()) {
			String expected_value = entry.getValue();
			String actual_value = jsonPath.getString(entry.getKey().trim());
			org.junit.Assert.assertEquals(expected_value, actual_value);
		}

	}
}
