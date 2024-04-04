package com.example;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import com.example.RemoteCodeExecution;

public class RCEFuzzTestCase {
    @FuzzTest
    void fuzzTestTrigger(FuzzedDataProvider data) {
        // Trigger remote code execution
        int a = data.consumeInt();
        String b = data.consumeRemainingAsString();

        RemoteCodeExecution rce = new RemoteCodeExecution(a);
        rce.trigger(b);
    }

    @FuzzTest
    void fuzzTestDontTrigger(FuzzedDataProvider data) {
        // Don't trigger remote code execution
        // by using the overloaded constructor
        String b = data.consumeRemainingAsString();

        RemoteCodeExecution rce = new RemoteCodeExecution();
        rce.trigger(b);
    }
}

