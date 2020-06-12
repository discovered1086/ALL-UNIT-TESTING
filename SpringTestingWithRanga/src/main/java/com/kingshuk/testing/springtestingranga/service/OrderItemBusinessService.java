package com.kingshuk.testing.springtestingranga.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.testing.springtestingranga.data.dao.OrderItemRepository;
import com.kingshuk.testing.springtestingranga.data.model.OrderItemEntity;
import com.kingshuk.testing.springtestingranga.data.model.ProductEntity;
import com.kingshuk.testing.springtestingranga.model.OrderItem;
import com.kingshuk.testing.springtestingranga.model.Product;

@Service
public class OrderItemBusinessService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private Mapper mapper;

	public OrderItem getOrderItem() {
		return OrderItem.builder().orderItemId("1").orderDate(LocalDate.now()).product(Product.builder()
				.productId("8878").productName("Nike Shoe").productPrice(BigDecimal.valueOf(50.65)).build()).build();
	}

	public OrderItem getOrderItemById() {
		OrderItemEntity itemEntity = orderItemRepository.findById(1l)
				.orElse(OrderItemEntity.builder().orderItemId(1l).orderDate(LocalDate.now())
						.product(ProductEntity.builder().productId(8878l).productName("Nike Shoe")
								.productPrice(BigDecimal.valueOf(50.65)).build())
						.build());

		return mapper.map(itemEntity, OrderItem.class);
	}

	public List<OrderItem> getAllOrderItem() {
		List<OrderItemEntity> itemEntity = orderItemRepository.findAll();

		List<OrderItem> orderItems = new ArrayList<>();

		itemEntity.forEach(item -> {
			OrderItem orderItem = mapper.map(item, OrderItem.class);
			orderItems.add(orderItem);
		});

		return orderItems;
	}

}
