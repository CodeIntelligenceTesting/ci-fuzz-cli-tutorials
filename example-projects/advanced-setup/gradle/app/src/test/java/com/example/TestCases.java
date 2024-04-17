package com.example;

import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.mutation.annotation.NotNull;

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
    void remoteCodeFuzzTest(int a, @NotNull String b) {
        // Fuzz test that finds RCE
        RemoteCodeExecution remoteCode = new RemoteCodeExecution(a);
        remoteCode.trigger(b);
    }
}
