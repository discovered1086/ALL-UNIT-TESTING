package com.kingshuk.testing.testingwithranga.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void testSingleElementJson() {
		String response = "{\n" + "	\"orderItemId\": \"1\",\n" + "	\"orderDate\": \"2020-06-05\",\n"
				+ "	\"product\": {\n" + "		\"productId\": \"8878\",\n" + "		\"productName\": \"Nike Shoe\",\n"
				+ "		\"productPrice\": 50.65\n" + "	}\n" + "}";

		DocumentContext documentContext = JsonPath.parse(response);

		assertThat(documentContext.read("$.orderItemId", String.class)).isEqualTo("1");
		assertThat(documentContext.read("$.product.productName", String.class)).contains("Nike");
	}

	@Test
	public void testMultipleElementJson() {
		String response = "[\n" + "	{\n" + "		\"orderItemId\": \"1\",\n"
				+ "		\"orderDate\": \"2020-06-05\",\n" + "		\"product\": {\n"
				+ "			\"productId\": \"8878\",\n" + "			\"productName\": \"Nike Shoe\",\n"
				+ "			\"productPrice\": 50.65\n" + "		}\n" + "	},\n" + "	{\n"
				+ "		\"orderItemId\": \"2\",\n" + "		\"orderDate\": \"2020-06-05\",\n"
				+ "		\"product\": {\n" + "			\"productId\": \"8879\",\n"
				+ "			\"productName\": \"Adidaas Shoe\",\n" + "			\"productPrice\": 54.65\n" + "		}\n"
				+ "	}\n" + "]";

		DocumentContext documentContext = JsonPath.parse(response);

		assertThat(documentContext.read("$.[0].orderItemId", String.class)).isEqualTo("1");
		assertThat(documentContext.read("$.[1].product.productName", String.class)).contains("Adidaas");
		
		assertThat(documentContext.read("$.[?(@.orderItemId == '1')].product.productName").toString())
				.isEqualTo("Nike Shoe");
	}

}
