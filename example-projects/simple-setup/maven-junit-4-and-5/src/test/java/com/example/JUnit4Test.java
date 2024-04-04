package com.example;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JUnit4Test {
	@Test
	public void junit4Test() {
		ExploreMe ex = new ExploreMe(12);
		assertEquals("Function should return string 'Hello'", "Hello", ex.exploreMe(436, ""));
	}

	@Test
	@Ignore("Testing a JUnit 4 annotation")
	public void ignoredTest() {
		assertFalse(true);
	}
}
