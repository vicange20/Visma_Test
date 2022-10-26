package com.example.demo.Utils;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public Response getAllEmployees(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("/employees")
                .then()
                .extract().response();
    }

    public Response getEmployeeById(String Id){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("/employee/" + Id)
                .then()
                .extract().response();
    }

    public Response createNewUserWithDetails (JsonObject object){
        return given()
                .contentType(ContentType.JSON)
                .request().body(object)
                .when()
                .post("/create")
                .then()
                .extract().response();
    }

    public Response updateEmployeeById(JsonObject object, String Id){
        return given()
                .contentType(ContentType.JSON)
                .request().body(object)
                .when()
                .put("/update/" + Id)
                .then()
                .extract().response();
    }

    public Response deleteEmployeeById(String Id){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/delete/" + Id)
                .then()
                .extract().response();
    }
}
