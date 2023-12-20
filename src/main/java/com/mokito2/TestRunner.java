package com.mokito2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        final Result result = JUnitCore.runClasses(RunApp.class);

        for (Failure failure: result.getFailures()) {
            System.err.println(failure.toString());
        }

        System.err.println(result.wasSuccessful());
    }
}
