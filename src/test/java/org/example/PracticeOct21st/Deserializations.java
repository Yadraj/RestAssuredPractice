package org.example.PracticeOct21st;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;

public class Deserializations {

    public static void main(String[] args) {

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
        BookingResponse br = gson.fromJson(bookingResponse, BookingResponse.class);
        System.out.println(br.getBookingid());
        System.out.println(br.getBooking().getFirstname());

    }


}
