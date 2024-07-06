package org.example.Oct22nd.Listeners;

import org.testng.IExecutionListener;

public class CustomeListeners  implements IExecutionListener {

    @Override
    public void onExecutionStart() {
       long startTime = System.currentTimeMillis();
       System.out.println("Execution Started"+ startTime);
    }

    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Finished"+ endTime);
    }
}
