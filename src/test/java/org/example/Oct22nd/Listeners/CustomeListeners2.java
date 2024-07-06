package org.example.Oct22nd.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomeListeners2 implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("starting test " );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(" test success " );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test fail " );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
