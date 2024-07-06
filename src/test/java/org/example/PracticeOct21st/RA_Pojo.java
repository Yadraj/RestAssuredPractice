package org.example.PracticeOct21st;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.PracticeOct22nd.Bookingdates;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RA_Pojo  {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

        @Test
        public void post() {

     Booking booking = new Booking();

     booking.setFirstname("yadraj");
     booking.setLastname("shinde");
     booking.setAdditionalneeds("lunch");
     booking.setDepositpaid(true);
     booking.setTotalprice(100);

     Bookingdates bookingdates = new Bookingdates();
     bookingdates.setCheckin("2018-01-01");
     bookingdates.setCheckout("2019-01-01");

     booking.setBookingdates(bookingdates);
     System.out.println(booking.getFirstname());



            requestSpecification= RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType("application/json");
            requestSpecification.body(booking);     //Serializaition
            response = requestSpecification.when().post();
            String bookingString = response.asString();
             System.out.println(response.asString());
            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);


            Gson gson = new Gson();         //De-serializaion
            BookingResponse br = gson.fromJson(bookingString, BookingResponse.class);
            System.out.println(br.getBookingid());
            System.out.println(br.getBooking().getFirstname());

            Assert.assertEquals(br.getBooking().getFirstname(), "yadraj");
            Assert.assertEquals(br.getBooking().getLastname(), "shinde");


}



}
