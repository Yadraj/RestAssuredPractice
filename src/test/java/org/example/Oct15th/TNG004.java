package org.example.Oct15th;

import org.testng.annotations.Test;

public class TNG004 {


    @Test(groups = {"smoke"})
    public void TNG004() {
        System.out.println("TNG004");
    }


    @Test(groups = {"smoke"})
    public void TNG005() {
        System.out.println("TNG005");
    }

    @Test(groups = {"reg"})
    public void TNG006() {
        System.out.println("TNG006 - regression");
    }


}
