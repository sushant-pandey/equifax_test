Feature: Testing the Rest APIs with Rest Assured

  #GET CALL
  Scenario: Verification of the GET request to API.
    Given the endpoint endpoint "http://dummy.restapiexample.com/api/v1/employees" exists
    When I create a GET request
    Then The response has status code "200"
    And The status line shows "HTTP/1.1 200 OK"
    And The response body has following details
      | status                  | success                                     |
      | data[0].id              |                                           1 |
      | data[0].employee_name   | Tiger Nixon                                 |
      | data[0].employee_salary |                                      320800 |
      | data[0].employee_age    |                                          61 |
      | data[1].id              |                                           2 |
      | data[1].employee_name   | Garrett Winters                             |
      | data[1].employee_salary |                                      170750 |
      | data[1].employee_age    |                                          63 |
      | message                 | Successfully! All records has been fetched. |

  #POST CALL
  Scenario: Verification of the POST request to API.
    Given the endpoint endpoint "http://dummy.restapiexample.com/api/v1/create" exists
    When I create a POST request to create employee with details
      | name   | test |
      | salary |  123 |
      | age    |   23 |
    Then The response has status code "200"
    And The status line shows "HTTP/1.1 200 OK"
    And The response body has following details
      | status  | success                              |
      | message | Successfully! Record has been added. |

  #DELETE CALL
  Scenario: Verification of the DELETE request to API.
    Given the endpoint endpoint "http://dummy.restapiexample.com/api/v1/delete" exists
    When I create a DELETE request to delete employee with id "2"
    Then The response has status code "200"
    And The status line shows "HTTP/1.1 200 OK"
    And The response body has following details
      | status  | success                               |
      | message | Successfully! Record has been deleted |