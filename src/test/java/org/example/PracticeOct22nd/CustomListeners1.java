package org.example.PracticeOct22nd;

import org.testng.IExecutionListener;

public class CustomListeners1  implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        long startTime = System.currentTimeMillis();
        System.out.println("Execution Started " + startTime);
    }

    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Finished " + endTime);
    }
}
