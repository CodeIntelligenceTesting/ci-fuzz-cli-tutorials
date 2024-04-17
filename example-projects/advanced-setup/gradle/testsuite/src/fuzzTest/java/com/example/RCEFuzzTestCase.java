package com.example;

import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.mutation.annotation.NotNull;

public class RCEFuzzTestCase {
    @FuzzTest
    void fuzzTestTrigger(int a, @NotNull String b) {
        RemoteCodeExecution rce = new RemoteCodeExecution(a);
        rce.trigger(b);
    }

    @FuzzTest
    void fuzzTestDontTrigger(@NotNull String b) {
        // Don't trigger remote code execution
        // by using the overloaded constructor
        RemoteCodeExecution rce = new RemoteCodeExecution();
        rce.trigger(b);
    }
}

