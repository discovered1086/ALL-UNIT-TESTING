package com.kingshuk.testing.springtestingranga.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
	
	private String orderId;
	
	private LocalDate orderDate;
	
	private Product product;

}
