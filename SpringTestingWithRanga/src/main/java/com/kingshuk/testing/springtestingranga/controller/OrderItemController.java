package com.kingshuk.testing.springtestingranga.controller;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.testing.springtestingranga.model.OrderItem;
import com.kingshuk.testing.springtestingranga.model.Product;

@RestController
public class OrderItemController {

	@GetMapping(path = "/orderItem", produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderItem> getOrderItem() {
		OrderItem orderItem = OrderItem.builder().orderId("1").orderDate(LocalDate.now())
				.product(Product.builder().productId("8878").productName("Nike Shoe").build()).build();

		return ResponseEntity.ok(orderItem);
	}

}
