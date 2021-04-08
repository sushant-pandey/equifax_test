Feature: Testing the Rest APIs with Rest Assured
				We will perform API Requests of GET, POST and DELETE on our endpoints.
				The response will be validated for Status Code, Status Line, Respose Execution Details
				and expected employee data.

  #GET CALL
  Scenario: Verification of the HTTP GET request to API.
  					Invoking the GET request.
  					Expected response contains the employee details as mentioned in data table.
  					
    Given The endpoint "/v1/employees" exists
    When I create a GET request
    Then The response has status code "200"
    And The status line shows "HTTP/1.1 200 OK"
    And The response body has following employee details
      | id | name            | salary | age |
      |  1 | Tiger Nixon     | 320800 |  61 |
      |  2 | Garrett Winters | 170750 |  63 |

  #DELETE CALL
  Scenario: Verification of the DELETE request to API.
  					Expected response contains the success message to confirm
  					successful deletion.
  
    Given The endpoint "/v1/delete" exists
    When I create a DELETE request to delete employee with id "2"
    Then The response has status code "200"
    And The status line shows "HTTP/1.1 200 OK"
    And The response body has following execution status details
      | status  | message                               |
      | success | Successfully! Record has been deleted |

  #POST CALL
  Scenario: Verification of the POST request to API.
  					Expected response contains the success message to confirm
  					successful new Employee creation.
  
    Given The endpoint "/v1/create" exists
    When I create a POST request to create employee with details
      | name | salary | age |
      | test |    123 |  23 |
    Then The response has status code "200"
    And The status line shows "HTTP/1.1 200 OK"
    And The response body has following execution status details
      | status  | message                              |
      | success | Successfully! Record has been added. |
