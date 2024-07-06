package org.example.Oct21st.Ser_Deser.crudUsingGson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Oct21st.Ser_Deser.BookingResponse;
import org.example.Oct21st.pojo.BookingPayload;
import org.example.Oct21st.pojo.Bookingdates;
import org.testng.annotations.Test;

public class PostRequest_gson {

    Gson gson;

    @Test
    public void demo1() {

        BookingPayload bookingPayload = new BookingPayload();

        bookingPayload.setFirstname("yadraj");
        bookingPayload.setLastname("shinde");
        bookingPayload.setTotalprice(100);
        bookingPayload.setDepositpaid(true);
        bookingPayload.setAdditionalneeds("lunch");

        org.example.Oct21st.pojo.Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        bookingPayload.setBookingdates(bookingdates);

        System.out.println(bookingPayload);

        Gson gson = new Gson();
        String gsonStringBody = gson.toJson(bookingPayload);
        System.out.println(gsonStringBody);


        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.contentType("application/json");
        r.basePath("/booking");

        Response response = r.when().body(gsonStringBody).post();

        ValidatableResponse vr = response.then().log().all().statusCode(200);

        String responseString = response.asString();


        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());

    }
}
