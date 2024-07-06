package org.example.Oct22nd.Listeners;

import org.testng.Assert;
import org.testng.IExecutionListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(CustomeListeners.class)
@Listeners(CustomeListeners2.class)
public class List001   {



    @Test
    public void list001() {
        System.out.println("I am List001");
        Assert.assertTrue(false);
    }

    @Test
    public void list002() {
        System.out.println("I am List002");
    }

}
