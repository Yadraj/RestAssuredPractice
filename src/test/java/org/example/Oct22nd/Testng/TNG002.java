package org.example.Oct22nd.Testng;

import org.testng.annotations.Test;

public class TNG002 {

    @Test(groups = {"init"})
    public void server() {
        System.out.println(" I will run this test");
    }

    @Test(groups = {"init"})
    public void method1() {
        System.out.println(" I will run second test");
    }

    @Test(dependsOnGroups = {"init"})
    public void method() {
        System.out.println(" I will run third test");
    }
}
