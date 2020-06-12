package com.kingshuk.testing.springtestingranga.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	private String productId;
	
	private String productName;
	
	private BigDecimal productPrice;
}
