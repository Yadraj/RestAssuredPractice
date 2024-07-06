package org.example.Oct21st.MISC;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class HashMapDemo {

    @Test
    public void demo(){

        HashMap<String,Object> jsonbodymap= new LinkedHashMap();

        jsonbodymap.put("firstname","yadraj");
        jsonbodymap.put("lastname","shinde");
        jsonbodymap.put("totalprice",111);
        jsonbodymap.put("depositpaid",true);
        jsonbodymap.put("additionalneeds","lunch");


        HashMap<String,Object> datesMap= new LinkedHashMap();

        datesMap.put("checkin","2018-01-01");
        datesMap.put("checkout","2019-01-01");


        jsonbodymap.put("bookingdates",datesMap);
        System.out.println(jsonbodymap);


        RestAssured

                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .basePath("/booking")

                .when().body(jsonbodymap).post()

                .then().log().all().statusCode(200);







    }
}
