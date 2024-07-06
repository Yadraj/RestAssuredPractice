package org.example.Oct21st.CrudPost;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NON_BDD_POST {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    @BeforeTest
    public void prePost(){
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
    }


    @Test
    public void postRequest() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.contentType("application/json");
        requestSpecification.body(payload);
        response =  requestSpecification.post();

       String responseBody = response.asString();

         System.out.println(responseBody);



        validatableResponse =  response.then();
        validatableResponse.statusCode(200);



    }

   // @Test
    public void negativePostRequest() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.contentType("application/json");
        requestSpecification.body(payload);
        response =  requestSpecification.post();

        String responseBody = response.asString();
        System.out.println(responseBody);

         validatableResponse =  response.then();
        validatableResponse.statusCode(201);



    }





}
