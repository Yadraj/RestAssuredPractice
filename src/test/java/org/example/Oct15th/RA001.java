package org.example.Oct15th;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RA001 {


    @Test(priority = 1)
    public void positivegetRequest() {

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().assertThat().statusCode(201);
    }


    @Test(priority = 2)
    public void negativeGetRequest() {

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().assertThat().statusCode(200);
    }
}
