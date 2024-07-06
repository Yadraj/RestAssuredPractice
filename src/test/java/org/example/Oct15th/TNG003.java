package org.example.Oct15th;

import org.testng.Assert;
import org.testng.asserts.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TNG003 {



    @Test
    public void TN001() {

        String name = "yadraj";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("yadra", name, "spelling mistake");
        System.out.println("helo");
        softAssert.assertAll();

        //Assert.assertEquals("yadra", name, "failed due to mismatch");
       // System.out.println("hello");




    }



}
