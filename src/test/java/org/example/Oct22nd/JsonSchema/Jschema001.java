package org.example.Oct22nd.JsonSchema;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Jschema001 {



    @Test
    public void jschema001() {


        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .contentType("application/json")
                .when().get()
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/org/example/Oct22nd/JsonSchema/schema.json")));

    }
}
