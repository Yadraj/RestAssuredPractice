package org.example.Oct21st.pojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RA_Pojo_GetRequest {


    @Test
    public void postRequest() {

        Auth_payload auth = new Auth_payload();
        auth.setUsername("admin");
        auth.setPassword("password123");

        RestAssured

                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .basePath("/auth")

                .when().body(auth).post()

                .then().log().all().statusCode(200);


    }
}