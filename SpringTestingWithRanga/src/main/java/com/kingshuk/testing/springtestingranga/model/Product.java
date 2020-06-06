package com.kingshuk.testing.springtestingranga.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private String productId;
	
	private String productName;
}
