package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JUnit5Test {
	@Test
	@DisplayName("I'm a JUnit 5 test!")
	void junit5Test(TestInfo testInfo) {
		ExploreMe ex = new ExploreMe(12);
		assertEquals("Hello", ex.exploreMe(436, ""), "Function should return string 'Hello'");
		assertEquals("I'm a JUnit 5 test!", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
	}

	@Test
	@Disabled("Testing a JUnit 5 annotation")
	void ignoredTest() {
		assertFalse(true);
	}
}
