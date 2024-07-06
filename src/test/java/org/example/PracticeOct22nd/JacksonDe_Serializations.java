package org.example.PracticeOct22nd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDe_Serializations {
    public static void main(String[] args) throws JsonProcessingException {


        String s = "{\n" +
                "  \"firstname\" : \"yadraj\",\n" +
                "  \"lastname\" : \"shinde\",\n" +
                "  \"totalprice\" : 100,\n" +
                "  \"depositpaid\" : true,\n" +
                "  \"bookingdates\" : null,\n" +
                "  \"additionalneeds\" : \"lunch\"\n" +
                "}";



        ObjectMapper mapper = new ObjectMapper();
        Booking booking = mapper.readValue(s, Booking.class);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());

    }

}
