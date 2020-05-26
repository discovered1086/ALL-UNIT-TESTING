package com.kingshuk.testing.testingwithranga.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MockitoFeaturesTest {

	@SuppressWarnings("unchecked")
	List<String> list = mock(List.class);

	
	@Test
	public void test() {
		when(list.size()).thenReturn(5).thenReturn(2);

		assertEquals(5, list.size());
		assertEquals(2, list.size());
	}

	
	@Test
	public void test_withParameters() {
		when(list.get(0)).thenReturn("Kingshuk Mukherjee");

		assertEquals("Kingshuk Mukherjee", list.get(0));
		assertEquals(null, list.get(1));
	}
	
	@Test
	public void test_withAnyParameters() {
		when(list.get(anyInt())).thenReturn("Kingshuk Mukherjee");

		assertEquals("Kingshuk Mukherjee", list.get(0));
		assertEquals("Kingshuk Mukherjee", list.get(1));
		
		verify(list, times(2)).get(anyInt());
		verify(list, never()).get(2);
	}
}
