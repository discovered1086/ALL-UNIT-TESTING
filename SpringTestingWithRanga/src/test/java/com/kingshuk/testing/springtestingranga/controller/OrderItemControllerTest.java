package com.kingshuk.testing.springtestingranga.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrderItemController.class)
public class OrderItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorldBasicTest() throws Exception {
		Resource resource = new ClassPathResource("jsonFiles/orderItem.json");

		String expectedResponse = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

		// Construct the request
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orderItem").accept(MediaType.APPLICATION_JSON);

		// Perform the action and match results
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(expectedResponse, true));

	}

}
