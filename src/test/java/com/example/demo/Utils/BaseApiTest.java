package com.example.demo.Utils;

import io.cucumber.java.Before;
import io.restassured.RestAssured;


public class BaseApiTest {
    @Before("@ApiTest")
    public static void setup() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
    }
}
