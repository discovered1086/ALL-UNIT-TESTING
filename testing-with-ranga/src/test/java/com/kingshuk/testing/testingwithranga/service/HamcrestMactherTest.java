package com.kingshuk.testing.testingwithranga.service;


import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isA;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMactherTest {

	@Test
	public void test() {
		List<String> names = Arrays.asList("Kingshuk", "Deeksha");
		
		assertThat(names, hasSize(2));
		assertThat(names, hasItems("Kingshuk"));
		
		assertThat(names, everyItem(isA(String.class)));
		assertThat(names.get(0), startsWith("King"));
	}

}
