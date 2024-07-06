package org.example.Oct21st.CrudPut;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PutRequestDemo {

    @Test
    public void testPutRequest() {

        //create token --post

        String payloadAuth = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType("application/json");
        r.body(payloadAuth);

        Response response = r.when().post();
        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

        String token = response.then().extract().path("token");
        System.out.println(token);



        //create booking id -- post

        String payloadBooking = "{\n" +
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


        r.basePath("booking");
        r.body(payloadBooking);
        response = r.when().post();
        vr = response.then().log().all();
        vr.statusCode(200);
        Integer bookingId = response.then().extract().path("bookingid");
        System.out.println(bookingId);



        //update firstname -- put

        String payloadPut= "{\n" +
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



        r.basePath("booking/"+bookingId);
        r.cookie("token",token);
        r.body(payloadPut);

        response = r.when().put();
        vr = response.then().log().all();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("yadraj"));



    }
}
