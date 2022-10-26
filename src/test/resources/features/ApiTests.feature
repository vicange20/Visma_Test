Feature: Api tests

  @ApiTest
  Scenario: This test prints all employee data and asserts that the 11th employee data is present in the response
    Given I send a request to get all employee data
    Then I get complete list of data for all the employees

  @ApiTest
  Scenario: This test gets an employee data by employee ID
    Given I send a request to get one employee data
    Then I get complete data for one specific employees

  @ApiTest
  Scenario: This test adds a new employee and verifies that he is added successfully
    Given I send request to create new employee
    Then The new employee is successfully created

  @ApiTest
  Scenario: This test updates an employee data, by its id, and the new data is successfully updated
    Given I update one employee data by its id
    Then The employee data will be updated

  @ApiTest
  Scenario: This test deletes an employee by its id, and it's data is removed successfully
    Given I delete one employee by its id
    Then The employee data will no longer be present in the list