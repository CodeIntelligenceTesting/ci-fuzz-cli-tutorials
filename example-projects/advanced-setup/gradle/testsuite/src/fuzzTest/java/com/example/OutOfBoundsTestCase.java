package com.example;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import org.junit.jupiter.api.Test;

public class OutOfBoundsTestCase {
    @FuzzTest
    void fuzzTest(FuzzedDataProvider data) {
        // Triggers array out of bounds exception
        int a = data.consumeInt();

        OutOfBounds outOfBounds = new OutOfBounds();
        outOfBounds.trigger(a);
    }

    @Test
    public void test() {
        // Example unit test
        OutOfBounds outOfBounds = new OutOfBounds();
        outOfBounds.trigger(0);
    }
}
