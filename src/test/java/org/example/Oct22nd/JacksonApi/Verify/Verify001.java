package org.example.Oct22nd.JacksonApi.Verify;

import org.testng.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Verify001 {

    public static void main(String[] args) {


        String name = "yadraj";
        Assert.assertEquals("yadraj",name);
        Assert.assertTrue(true);


        assertThat(name).isNotBlank();
    }

}
