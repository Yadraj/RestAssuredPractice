package org.example.PracticeOct22nd;

import org.testng.Assert;

public class TestngAssertions {


    public static void main(String[] args) {


        String s = "yadraj";

        Assert.assertEquals(s,"yadraj");
        Assert.assertTrue(s.contains("yadraj"));
    }
}