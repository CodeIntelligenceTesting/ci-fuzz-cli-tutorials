package com.example

import com.code_intelligence.jazzer.junit.FuzzTest
import com.code_intelligence.jazzer.mutation.annotation.NotNull

class FuzzTestCase {
    @FuzzTest
    fun myFuzzTest(a: Int, b: Int, @NotNull c: String) {
        val ex = ExploreMe(a)
        ex.exploreMe(b, c)
    }
}
