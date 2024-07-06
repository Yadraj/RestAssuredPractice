package org.example.Oct21st.Ser_Deser;

import com.google.gson.Gson;

import java.sql.SQLOutput;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeSerializationDemo {


    public static void main(String args[]){


        String bookingResponse = "{\n" +
                "    \"bookingid\": 1,\n" +
                "    \"booking\": {\n" +
                "        \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }\n" +
                "}";


        Gson gson = new Gson();
        BookingResponse bookingResponse1= gson.fromJson(bookingResponse,BookingResponse.class);
        System.out.println(bookingResponse1.getBookingid());
        System.out.println(bookingResponse1.getBooking().getFirstname());

        assertThat(bookingResponse1.getBooking().getFirstname()).isNotBlank();







    }


}
