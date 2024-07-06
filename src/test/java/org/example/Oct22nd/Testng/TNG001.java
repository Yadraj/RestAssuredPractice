package org.example.Oct22nd.Testng;

import org.testng.annotations.Test;

public class TNG001 {

    @Test
    public void server() {
        System.out.println(" I will run this test");
    }

    @Test(dependsOnMethods = {"server"})
    public void method() {
        System.out.println(" I will run second test");
    }
}
