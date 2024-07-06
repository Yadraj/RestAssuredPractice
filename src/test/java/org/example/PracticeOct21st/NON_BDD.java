package org.example.PracticeOct21st;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NON_BDD {


    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    @BeforeTest
    public void prePost() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
    }

    @Test
    public void Post() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.contentType("application/json");
        requestSpecification.body(payload);

        response = requestSpecification.post();
        System.out.println(response.asString());

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }


}
