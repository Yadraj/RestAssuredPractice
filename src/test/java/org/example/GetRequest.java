package org.example;

import io.restassured.RestAssured;

public class GetRequest {

    public static void main(String[] args) {

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().assertThat().statusCode(201);

    }

}