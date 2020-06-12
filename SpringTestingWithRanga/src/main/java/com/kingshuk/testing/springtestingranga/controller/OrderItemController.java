package com.kingshuk.testing.springtestingranga.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingshuk.testing.springtestingranga.model.OrderItem;
import com.kingshuk.testing.springtestingranga.model.Product;
import com.kingshuk.testing.springtestingranga.service.OrderItemBusinessService;

@RestController
public class OrderItemController {

	@Autowired
	private OrderItemBusinessService businessService;

	@GetMapping(path = "/orderItem", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderItem> getOrderItem() {
		OrderItem orderItem = OrderItem.builder().orderItemId("1").orderDate(LocalDate.now())
				.product(Product.builder().productId("8878").productName("Nike Shoe").productPrice(BigDecimal.valueOf(50.65)).build()).build();

		return ResponseEntity.ok(orderItem);
	}

	@GetMapping(path = "/orderItem-from-service", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderItem> getOrderItemFroomServiceLayer() {
		OrderItem orderItem = businessService.getOrderItem();
		return ResponseEntity.ok(orderItem);
	}
	
	@GetMapping(path = "/all-items-from-database", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderItem>> getAllOrderItemsFroomServiceLayer() {
		return ResponseEntity.ok(businessService.getAllOrderItem());
	}

}
