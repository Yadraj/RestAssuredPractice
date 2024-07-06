package org.example.PracticeOct22nd;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(CustomListeners1.class)
@Listeners(CustomListeners2.class)

public class ListenersPracttice {

    @Test
    public void testListenersPracttice() {
        System.out.println("hello");
    }

    @Test
    public void testListenersPracttice2() {
        System.out.println("hello2");
    }
}
