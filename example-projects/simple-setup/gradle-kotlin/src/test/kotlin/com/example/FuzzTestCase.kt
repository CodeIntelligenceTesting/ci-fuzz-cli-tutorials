package com.example

import com.code_intelligence.jazzer.api.FuzzedDataProvider
import com.code_intelligence.jazzer.junit.FuzzTest

class FuzzTestCase {
    @FuzzTest
    fun myFuzzTest(data: FuzzedDataProvider) {
        val a: Int = data.consumeInt()
        val b: Int = data.consumeInt()
        val c: String = data.consumeRemainingAsString()
        val ex = ExploreMe(a)
        ex.exploreMe(b, c)
    }
}
