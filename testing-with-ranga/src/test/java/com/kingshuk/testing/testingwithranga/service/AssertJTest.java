package com.kingshuk.testing.testingwithranga.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void test() {
		List<String> names = Arrays.asList("Kingshuk", "Deeksha");
		
////		assertThat(names, hasSize(2));
//	    assertThat(names).hasSize(2);
////		assertThat(names, hasItems("Kingshuk"));
//	    assertThat(names).contains("Kingshuk");
////		
////		assertThat(names, everyItem(isA(String.class)));
//	    assertThat(names).allMatch(e -> e.getClass().equals(String.class));
////		assertThat(names.get(0), startsWith("King"));
//	    assertThat(names.get(0)).startsWith("Kings");
		
		assertThat(names).hasSize(2)
						.contains("Kingshuk")
						.allMatch(e -> e.getClass().equals(String.class));
		
		assertThat(names.get(0)).startsWith("King");
	}

}
