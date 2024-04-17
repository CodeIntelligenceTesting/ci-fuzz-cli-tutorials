package com.example;

import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.mutation.annotation.NotNull;

public class FuzzTestCase {
    @FuzzTest
    void myFuzzTest(int a, int b, @NotNull String c) {
        ExploreMe ex = new ExploreMe(a);
        ex.exploreMe(b, c);
    }
}
