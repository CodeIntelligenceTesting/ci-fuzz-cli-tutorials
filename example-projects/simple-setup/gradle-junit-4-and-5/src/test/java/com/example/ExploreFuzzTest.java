package com.example;

import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.mutation.annotation.NotNull;

class ExploreFuzzTest {
	@FuzzTest
	void myFuzzTest(int a, int b, @NotNull String c) {
		ExploreMe ex = new ExploreMe(a);
		ex.exploreMe(b, c);
	}
}
