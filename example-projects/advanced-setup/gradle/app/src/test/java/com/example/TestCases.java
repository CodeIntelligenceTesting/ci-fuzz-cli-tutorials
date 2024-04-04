package com.example;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Test;

public class TestCases {
    @Test
    public void outOfBoundsTest() {
        // Example unit test
        OutOfBounds outOfBounds = new OutOfBounds();
        outOfBounds.trigger(0);
    }

    @Test
    public void remoteCodeTest() {
        // Example unit test
        RemoteCodeExecution remoteCode = new RemoteCodeExecution(100);
        remoteCode.trigger("Test");
    }

    @FuzzTest
    void remoteCodeFuzzTest(FuzzedDataProvider data) {
        // Fuzz test that finds RCE
        int a = data.consumeInt();
        String b = data.consumeRemainingAsString();

        RemoteCodeExecution remoteCode = new RemoteCodeExecution(a);
        remoteCode.trigger(b);
    }
}
