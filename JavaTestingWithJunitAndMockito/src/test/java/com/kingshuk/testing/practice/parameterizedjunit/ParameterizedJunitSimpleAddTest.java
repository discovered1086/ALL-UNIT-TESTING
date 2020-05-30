package com.kingshuk.testing.practice.parameterizedjunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.kingshuk.testing.practice.simpleclassesfortest.SimpleAddClass;

@RunWith(Parameterized.class)
public class ParameterizedJunitSimpleAddTest {

	private int number1;

	private int number2;

	private int expectedResult;

	public ParameterizedJunitSimpleAddTest(int number1, int number2, int expectedResult) {
		this.number1 = number1;
		this.number2 = number2;
		this.expectedResult = expectedResult;
	}

	@Parameters
	public static Collection<Integer[]> generateDataSet() {
		return Arrays.asList(new Integer[][] { { 500, 300, 800 }, { 45, 55, 100 }, { 78, 122, 200 } });

	}

	@Test
	public void checkAddMethodFunctionality() {
		SimpleAddClass addClass = new SimpleAddClass();

		int result = addClass.addtwoValues(number1, number2);

		assertEquals(expectedResult, result);
	}

}
