package org.example.PracticeOct22nd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.PracticeOct21st.Booking;
import org.testng.annotations.Test;

public class JacksonSerialization {



    @Test
    public void post() throws JsonProcessingException {

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


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(json);

    }


}

