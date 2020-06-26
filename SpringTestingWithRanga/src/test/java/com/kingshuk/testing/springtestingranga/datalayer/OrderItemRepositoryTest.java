package com.kingshuk.testing.springtestingranga.datalayer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kingshuk.testing.springtestingranga.data.dao.OrderItemRepository;
import com.kingshuk.testing.springtestingranga.data.model.OrderItemEntity;

@DataJpaTest
public class OrderItemRepositoryTest {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Test
	public void test() {
		List<OrderItemEntity> orderItems = orderItemRepository.findAll();

		assertThat(orderItems.size()).isEqualTo(4);
	}

}
