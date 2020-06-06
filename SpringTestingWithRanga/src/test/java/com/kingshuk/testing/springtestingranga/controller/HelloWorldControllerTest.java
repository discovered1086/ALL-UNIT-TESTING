package com.kingshuk.testing.springtestingranga.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorldBasicTest() throws Exception {
		//Construct the request
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		
		//Perform the action and match results
		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().string("Enjoy spring boot testing"));
		
	}

}
