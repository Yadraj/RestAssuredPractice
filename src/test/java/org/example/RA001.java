package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RA001 {

    @Test
    public void getRequest() {

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().assertThat().statusCode(201);
    }
}