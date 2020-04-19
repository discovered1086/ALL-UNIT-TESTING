package com.kingshuk.testing.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kingshuk.testing.practice.test.PlayingWithString;
import com.kingshuk.testing.practice.test.StringTest;

public class TestingStringTest {

	@Test
	public void testStringTest() {
		StringTest test = new StringTest();
		Assertions.assertEquals("ABCD", test.checkEmptydata("ABCD"));
	}

	@Test
	public void testPlayingWithString() throws Exception {
		Assertions.assertEquals("8664115613", new PlayingWithString().returnFaxNumber("FAX (866) 411-5613"));
	}
}
