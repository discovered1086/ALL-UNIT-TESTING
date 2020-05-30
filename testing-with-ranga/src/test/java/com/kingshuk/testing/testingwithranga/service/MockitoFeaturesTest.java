package com.kingshuk.testing.testingwithranga.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

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

	@Test
	public void test_captureArguments() {
		list.add("Kingshuk Mukherjee");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		verify(list).add(captor.capture());

		assertEquals("Kingshuk Mukherjee", captor.getValue());
	}

	@Test
	public void test_captureMultipleArguments() {
		list.add("Kingshuk Mukherjee");
		list.add("Deeksha Banerjee");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		verify(list, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertEquals("Kingshuk Mukherjee", allValues.get(0));
		assertEquals("Deeksha Banerjee", allValues.get(1));
	}

	@Test
	public void test_mocking_vs_spying_mocking_method() {
		@SuppressWarnings("unchecked")
		ArrayList<String> mock = mock(ArrayList.class);
		mock.add("Kingshuk Mukherjee");
		mock.add("Deeksha Banerjee");

		System.out.println(mock.get(0));
		System.out.println(mock.get(1));

		when(mock.get(1)).thenReturn("Bela Banerjee");
		assertEquals("Bela Banerjee", mock.get(1));
	}
	
	
	@Test
	public void test_mocking_vs_spying_spying_method() {
		@SuppressWarnings("unchecked")
		ArrayList<String> spy = spy(ArrayList.class);
		
		spy.add("Kingshuk Mukherjee");
		spy.add("Deeksha Banerjee");

		System.out.println(spy.get(0));
		System.out.println(spy.get(1));

		when(spy.get(anyInt())).thenReturn("Bela Banerjee");
		
		spy.add(1, "Amit Biswas");
		
		System.out.println(spy.get(0));
		System.out.println(spy.get(1));
		
		assertEquals("Bela Banerjee", spy.get(1));
	}

}
