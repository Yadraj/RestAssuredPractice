package org.example.Oct22nd.JacksonApi;
import org.example.Oct22nd.JacksonApi.Bookingdates;
import org.example.Oct22nd.JacksonApi.Booking;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SerDemoJackson {


    public static void main(String[] args) throws JsonProcessingException {


        Booking booking = new Booking();

        booking.setFirstname("yadraj");
        booking.setLastname("shinde");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("lunch");

        Bookingdates bookingdates = new Bookingdates();

        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        booking.setBookingdates(bookingdates);


        ObjectMapper mapper = new ObjectMapper();
        String jsonString=  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonString);




    }
}
