package com.kingshuk.testing.springtestingranga.jsonassert;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertPracticeTest {

	private String actualResponse = "{\"orderId\":\"1\",\"orderDateTime\":\"2020-06-05\",\"product\":{\"productId\":\"8878\",\"productName\":\"Nike Shoe\"}}";
	private String expectedResponse = "{\"orderId\":\"1\",\"orderDateTime\":\"2020-06-05\",\"product\":{\"productId\":\"8878\",\"productName\":\"Nike Shoe\"}}";

	@Test
	public void jsonAssertTest_StricTrue() throws JSONException {
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}

	@Test
	public void jsonAssertTest_StricFalse() throws JSONException {
		String expectedResponse = "{\"orderId\":\"1\",\"orderDateTime\":\"2020-06-05\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

	@Test
	public void jsonAssertTest_StricFalse_WihtoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{orderId:1,orderDateTime:2020-06-05}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
