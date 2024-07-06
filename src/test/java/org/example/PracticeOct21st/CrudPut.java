package org.example.PracticeOct21st;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CrudPut {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void Post() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload);

        response = requestSpecification.when().post();
        System.out.println(response.asString());

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        String token = response.then().extract().path("token");
        System.out.println(token);


        String postPayload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification.basePath("/booking");
        requestSpecification.contentType("application/json");
        requestSpecification.body(postPayload);
        response = requestSpecification.when().post();
        System.out.println(response.asString());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        Integer bookingId = response.then().extract().path("bookingid");
        System.out.println(bookingId);


        String putPayload = "{\n" +
                "    \"firstname\" : \"yadraj\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.cookie("token",token);
        requestSpecification.contentType("application/json");
        requestSpecification.body(putPayload);

        response = requestSpecification.when().put();
        System.out.println(response.asString());
        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        String firstname = response.then().extract().path("firstname");
        System.out.println(firstname);
        validatableResponse.body("firstname", Matchers.equalTo("yadraj"));


        requestSpecification.cookie("token",token);
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType("application/json");
        response= requestSpecification.when().delete();
        validatableResponse = response.then();
        validatableResponse.statusCode(201);

//        requestSpecification.basePath("/booking/"+bookingId);
//        requestSpecification.contentType("application/json");
//        response= requestSpecification.when().get();
//        validatableResponse = response.then();
//        validatableResponse.statusCode(200);




    }
}
