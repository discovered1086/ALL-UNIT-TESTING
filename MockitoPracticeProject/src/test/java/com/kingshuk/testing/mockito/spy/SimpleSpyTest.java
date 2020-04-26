package com.kingshuk.testing.mockito.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SimpleSpyTest {

	@Mock
	ArrayList<String> nameList = new ArrayList<>(10);

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Disabled
	public void testSpyMethod() {
		nameList.add("Kingshuk");
		nameList.add("Deeksha");

		// Stubbing is a little different with spies
		doReturn(3).when(nameList).size();

		assertEquals(3, nameList.size());
	}

	@Test
	public void testSpyMethod2() {
		when(nameList.get(0)).thenCallRealMethod();
		when(nameList.add(ArgumentMatchers.anyString())).thenCallRealMethod();
		
		nameList.add("Amit");

		assertEquals("Amit", nameList.get(0));
	}
}
