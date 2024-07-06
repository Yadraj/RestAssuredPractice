package org.example.Oct21st.pojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RA_pojo_booking {

    @Test
    public void demo(){

        BookingPayload bookingPayload = new BookingPayload();

        bookingPayload.setFirstname("yadraj");
        bookingPayload.setLastname("shinde");
        bookingPayload.setTotalprice(100);
        bookingPayload.setDepositpaid(true);
        bookingPayload.setAdditionalneeds("lunch");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        bookingPayload.setBookingdates(bookingdates);

        System.out.println(bookingPayload);




        RestAssured

                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .basePath("/booking")

                .when().body(bookingPayload).post()

                .then().log().all().statusCode(200);



    }
}
