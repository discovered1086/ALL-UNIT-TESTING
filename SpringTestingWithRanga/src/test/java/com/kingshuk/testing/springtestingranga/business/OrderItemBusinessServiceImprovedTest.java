package com.kingshuk.testing.springtestingranga.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.kingshuk.testing.springtestingranga.configuration.ApplicationConfiguration;
import com.kingshuk.testing.springtestingranga.configuration.ApplicationTestConfiguration;
import com.kingshuk.testing.springtestingranga.data.dao.OrderItemRepository;
import com.kingshuk.testing.springtestingranga.data.model.OrderItemEntity;
import com.kingshuk.testing.springtestingranga.data.model.ProductEntity;
import com.kingshuk.testing.springtestingranga.model.OrderItem;
import com.kingshuk.testing.springtestingranga.model.Product;
import com.kingshuk.testing.springtestingranga.service.OrderItemBusinessService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = {ApplicationConfiguration.class, ApplicationTestConfiguration.class})
public class OrderItemBusinessServiceImprovedTest {

	@MockBean
	private OrderItemRepository orderItemRepository;

	@Autowired
	private OrderItemBusinessService businessService;

	@SpyBean
	private Mapper mapper;

	@Test
	public void testGetAllItemsBusinessService() {

		OrderItemEntity itemEntity1 = OrderItemEntity.builder().orderItemId(1l).orderDate(LocalDate.now())
				.product(ProductEntity.builder().productId(8878l).productName("Nike Shoe")
						.productPrice(BigDecimal.valueOf(50.65)).build())
				.build();

		OrderItemEntity itemEntity2 = OrderItemEntity.builder().orderItemId(2l).orderDate(LocalDate.now())
				.product(ProductEntity.builder().productId(8879l).productName("Adidaas Shoe")
						.productPrice(BigDecimal.valueOf(54.65)).build())
				.build();

		List<OrderItemEntity> orderItemEntities = Arrays.asList(itemEntity1, itemEntity2);

		OrderItem orderItem1 = OrderItem.builder().orderItemId("1").orderDate(LocalDate.now()).product(Product.builder()
				.productId("8878").productName("Nike Shoe").productPrice(BigDecimal.valueOf(50.65)).build()).build();

		OrderItem orderItem2 = OrderItem.builder().orderItemId("2").orderDate(LocalDate.now()).product(Product.builder()
				.productId("8879").productName("Adidaas Shoe").productPrice(BigDecimal.valueOf(54.65)).build()).build();

		when(orderItemRepository.findAll()).thenReturn(orderItemEntities);

		List<OrderItem> allOrderItem = businessService.getAllOrderItem();

		assertThat(allOrderItem).isNotEmpty();
		assertThat(allOrderItem).asList().containsExactlyInAnyOrder(orderItem1, orderItem2);

	}

}
