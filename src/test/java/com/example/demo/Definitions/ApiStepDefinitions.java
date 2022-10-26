package com.example.demo.Definitions;

import com.example.demo.Utils.ApiUtils;
import com.example.demo.Utils.Context;
import com.example.demo.Utils.ScenarioContext;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;
import org.testng.Assert;


public class ApiStepDefinitions {

    private ScenarioContext context = new ScenarioContext();
    public ApiUtils apiUtils = new ApiUtils();

    //This test prints all employee data and asserts that the 11th employee data is present in the response
    @Given("I send a request to get all employee data")
    public void iRequestAllEmployeesData() {
        Response response = apiUtils.getAllEmployees();
        context.setContext(Context.RESPONSE, response);
}

    @Then("I get complete list of data for all the employees")
    public void iGetAllEmployeesDetails() {
        Response response = (Response) context.getContext(Context.RESPONSE);
        System.out.println("List of employees: " + response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("\"id\":11,\"employee_name\":\"Jena Gaines\",\"employee_salary\":90560,\"employee_age\":30,\"profile_image\":\"\""));
    }

    //This test gets an employee data by employee ID
    @Given("I send a request to get one employee data")
    public void iRequestOneEmployeeData() {
        Response response = apiUtils.getEmployeeById("1");
        context.setContext(Context.RESPONSE, response);
    }

    @Then("I get complete data for one specific employees")
    public void iGetOneEmployeeData() {
        Response response = (Response) context.getContext(Context.RESPONSE);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("\"id\":1,\"employee_name\":\"Tiger Nixon\",\"employee_salary\":320800,\"employee_age\":61,\"profile_image\":\"\""));
    }

    //This test adds a new employee and verifies that he is added successfully
    @Given("I send request to create new employee")
    public void iSendAPostWithNewUserDetails() {
        JsonObject requestParams = new JsonObject();
        requestParams.add("name", "test tests");
        requestParams.add("salary", "12345");
        requestParams.add("age", "29");

        Response response = apiUtils
                .createNewUserWithDetails(requestParams);
        context.setContext(Context.RESPONSE, response);
    }

    @Then("The new employee is successfully created")
    public void iGetAllPostDetails() {
        Response response = (Response) context.getContext(Context.RESPONSE);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("Successfully! Record has been added."));
    }

    //This test updates an employee data, by its id, and the new data is successfully updated
    @Given("I update one employee data by its id")
    public void iUpdateOneEmployeeData() {
        JsonObject requestParams = new JsonObject();
        //requestParams.add("id", "3");
        requestParams.add("employee_name", "victor");
        requestParams.add("employee_salary", "50000");
        requestParams.add("employee_age", "40");
        //requestParams.add("profile_image", "");

        Response response = apiUtils
                .updateEmployeeById(requestParams, "3");
        context.setContext(Context.RESPONSE, response);
    }

    @Then("The employee data will be updated")
    public void iSuccessfullyUpdatedOneEmployeeData() {
        Response response = (Response) context.getContext(Context.RESPONSE);
        System.out.println("List of employees: " + response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertFalse(response.getBody().asString().contains("\"id\":3,\"employee_name\":\"victor\",\"employee_salary\":50000,\"employee_age\":40,\"profile_image\":\"\""));
    }

   //This test deletes an employee by its id, and it's data is removed successfully
   @Given("I delete one employee by its id")
   public void iDeleteOneEmployeeData() {
       Response response = apiUtils.deleteEmployeeById("2");
       context.setContext(Context.RESPONSE, response);
   }

    @Then("The employee data will no longer be present in the list")
    public void iSuccessfullyDeletedOneEmployeeData() {
        Response response = (Response) context.getContext(Context.RESPONSE);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertFalse(response.getBody().asString().contains("id\":2,\"employee_name\":\"Garrett Winters\",\"employee_salary\":170750,\"employee_age\":63,\"profile_image\":\"\""));
    }
}
