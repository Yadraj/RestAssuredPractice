package org.example.PracticeOct22nd;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JsonPath2 {
    public static void main(String[] args) {


        String s = "{\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"doe\",\n" +
                "    \"age\": 26,\n" +
                "    \"address\": {\n" +
                "        \"streetAddress\": \"naist street\",\n" +
                "        \"city\": \"Nara\",\n" +
                "        \"postalCode\": \"630-0192\"\n" +
                "    },\n" +
                "    \"phoneNumbers\": [\n" +
                "        {\n" +
                "            \"type\": \"iPhone\",\n" +
                "            \"number\": \"0123-4567-8888\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"home\",\n" +
                "            \"number\": \"0123-4567-8910\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";


        JsonPath jsonPath =  JsonPath.from(s);

        System.out.println(jsonPath.getString("firstName"));

        Assert.assertEquals(jsonPath.getString("firstName"), "John");

        assertThat(jsonPath.getString("firstName")).isNotBlank().isNotEmpty();

    }









}

