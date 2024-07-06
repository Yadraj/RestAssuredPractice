package org.example.Oct21st.Ser_Deser;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.example.Oct21st.pojo.BookingPayload;
import org.example.Oct21st.pojo.Bookingdates;
import org.testng.annotations.Test;

public class SerializationDemo {

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

        Gson gson = new Gson();
        String gsonStringBody =  gson.toJson(bookingPayload);
        System.out.println(gsonStringBody);



        RestAssured

                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .basePath("/booking")

                .when().body(gsonStringBody).post()

                .then().log().all().statusCode(200);



    }


}
