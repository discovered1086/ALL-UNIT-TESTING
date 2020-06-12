package com.kingshuk.testing.springtestingranga.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kingshuk.testing.springtestingranga.model.OrderItem;
import com.kingshuk.testing.springtestingranga.model.Product;
import com.kingshuk.testing.springtestingranga.service.OrderItemBusinessService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrderItemController.class)
public class OrderItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();

	@MockBean
	private OrderItemBusinessService businessService;

	@Test
	public void simpleOrderItemTest() throws Exception {
		// Construct the request
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orderItem").accept(MediaType.APPLICATION_JSON);

		// Perform the action and match results
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().json(updatedExpectedResponse("orderItem.json"), true));

	}

	@Test
	public void orderItemTestWithBusiinessLayer() throws Exception {
		OrderItem orderItem = OrderItem.builder().orderItemId("1").orderDate(LocalDate.now()).product(Product.builder()
				.productId("8878").productName("Nike Shoe").productPrice(BigDecimal.valueOf(50.65)).build()).build();

		when(businessService.getOrderItem()).thenReturn(orderItem);

		// Construct the request
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orderItem-from-service")
				.accept(MediaType.APPLICATION_JSON);

		// Perform the action and match results
		mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(content().json(updatedExpectedResponse("orderItem.json"), true));

	}

	private String updatedExpectedResponse(String fileName) throws IOException {
		Resource resource = new ClassPathResource("jsonFiles/" + fileName);

		JsonNode rootNode = objectMapper.readTree(resource.getInputStream());
		((ObjectNode) rootNode).set("orderDate", JsonNodeFactory.instance.textNode(LocalDate.now().toString()));

		return objectMapper.writeValueAsString(rootNode);
	}

}
