package com.kingshuk.testing.springtestingranga.controller.integrationtest;

import java.io.IOException;
import java.time.LocalDate;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test.properties"})
public class OrderItemControllerIT {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void test() throws IOException, JSONException {
		ResponseEntity<String> response = restTemplate.getForEntity("/all-items-from-database", String.class);
		
		String expectedResponse = updatedExpectedResponse("multipleOrderItems.json");
		
		JSONAssert.assertEquals(expectedResponse, response.getBody(), false);
	}
	
	private String updatedExpectedResponse(String fileName) throws IOException {
		Resource resource = new ClassPathResource("jsonFiles/integrationTest/" + fileName);

		JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
		if (rootNode.isArray()) {
			for (JsonNode elementNode : rootNode) {
				((ObjectNode) elementNode).set("orderDate",
						JsonNodeFactory.instance.textNode(LocalDate.now().toString()));
			}
		} else {
			((ObjectNode) rootNode).set("orderDate", JsonNodeFactory.instance.textNode(LocalDate.now().toString()));
		}

		return objectMapper.writeValueAsString(rootNode);
	}

}
