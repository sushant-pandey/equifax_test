package org.mindtree.equifax.stepsdefinition;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.mindtree.equifax.amazon.data.employee.Employee;
import org.mindtree.equifax.config.ConfigFileReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiSteps {

	private RequestSpecification request;
	private Response response;
	
	/**
	 * This data table element reads the employee details from the objects
	 * passed from feature files.
	 * This can further be used in step definitions to use the employee details.
	 * @param entry
	 * @return
	 */
	@DataTableType
	public Employee defineEmployees(Map<String, String> entry) {
		Employee employee = new Employee();
		if (entry.get("id") != null) {
			employee.setId(Integer.parseInt(entry.get("id")));
		}
		
		employee.setEmployee_name(entry.get("name"));
		
		if (entry.get("salary") != null) {
			employee.setEmployee_salary(Integer.parseInt(entry.get("salary")));
		}
		if (entry.get("age") != null) {
			employee.setEmployee_age(Integer.parseInt(entry.get("age")));
		}
		return employee;
	}
	
	/**
	 * This method sets the complete API URI and also generates 
	 * the Request Specification instance.
	 * @param apiEndPoint
	 */
	@Given("The endpoint {string} exists")
	public void the_endpoint_exists(String apiEndPoint) {
		RestAssured.baseURI = new ConfigFileReader().getBaseApiUrl() + apiEndPoint;
		request = RestAssured.given();
	}

	/**
	 * This step method creates a GET request
	 */
	@When("I create a GET request")
	public void i_create_a_get_request() {
		response = request.get();
	}
	
	/**
	 * This step method creates a delete request.
	 * This uses the employee id as path parameter
	 * @param employeeId
	 */
	@When("I create a DELETE request to delete employee with id {string}")
	public void i_create_a_delete_request_to_delete_employee_with_id(String employeeId) {
	    response = request.delete("/" + employeeId);
	}

	/**
	 * This method creates the POST request.
	 * The json body is created based on the employee details
	 * @param employee
	 */
	@When("I create a POST request to create employee with details")
	public void i_create_a_post_request_to_create_employee_with_details(Employee employee) {
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", employee.getEmployee_name());
		requestParams.put("salary", employee.getEmployee_salary());
		requestParams.put("age", employee.getEmployee_age());
		
		response = request.body(requestParams.toString()).post();
	}
	
	/**
	 * This step verifies the status code
	 * @param expectedStatusCode
	 */
	@Then("The response has status code {string}")
	public void the_response_has_status_code(String expectedStatusCode) {
		int responseStatusCode = response.getStatusCode();
		Assert.assertEquals(expectedStatusCode, ""+responseStatusCode);
	}

	/**
	 * This step method verifies the status line from the response
	 * @param expectedStatusLine
	 */
	@Then("The status line shows {string}")
	public void the_status_line_shows(String expectedStatusLine) {
		String actualStatusLine = response.getStatusLine();
		Assert.assertEquals(expectedStatusLine, actualStatusLine);
	}
	

	/**
	 * This generic method verifies the parameters in response.
	 * The expected values are passed as map parameters in the feature file
	 * @param dataTable
	 */
	@Then("The response body has following details")
	public void the_response_body_has_following_details(DataTable dataTable) {
		JsonPath jsonPath = response.jsonPath();
		Map<String, String> map = dataTable.asMap(String.class, Object.class);
		for(java.util.Map.Entry<String, String> entry : map.entrySet()) {
			String expected_value = entry.getValue();
			String actual_value = jsonPath.getString(entry.getKey().trim());
			Assert.assertEquals(expected_value, actual_value);
		}
	}
	
	
	
	/**
	 * This method verifies the presence of expected employee data in the response body.
	 * @param expectedEmployees
	 */
	@Then("The response body has following employee details")
	public void the_response_body_has_following_employee_details(List<Employee> expectedEmployees) {
		//Deserializing the employee data from the api response
		List<Employee> listOfEmployeesInResponse = response.body().jsonPath().getList("data", Employee.class);
		for(Employee employee : expectedEmployees) {
			long count = listOfEmployeesInResponse.stream()
				.filter(emp -> {
					return emp.getId() == employee.getId()
							&& emp.getEmployee_age() == employee.getEmployee_age()
							&& emp.getEmployee_name().equalsIgnoreCase(employee.getEmployee_name())
							&& emp.getEmployee_salary() == employee.getEmployee_salary();})
				.count();
			
			//Assert that atleast one employee is found with the given details
			Assert.assertTrue(count >= 1);
		}
	}
	
	/**
	 * This step method verifies the response body.
	 * The parameters passed from the feature files are List of List of values.
	 * @param expectedValuesTable
	 */
	@Then("The response body has following execution status details")
	public void the_response_body_has_following_execution_status_details(DataTable expectedValuesTable) {
		List<List<String>> expValueList = expectedValuesTable.asLists();
		JsonPath jsonPath = response.jsonPath();
		for(int i = 1; i < expValueList.size(); i++) {
			for(int j = 0; j < expValueList.get(i).size(); j++) {
				Assert.assertEquals(
						expValueList.get(i).get(j), 
						jsonPath.getString(expValueList.get(0).get(j)));
			}
		}
	}
}
