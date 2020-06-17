package com.kingshuk.testing.springtestingranga.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.kingshuk.testing.springtestingranga.data.dao.OrderItemRepository;
import com.kingshuk.testing.springtestingranga.data.model.OrderItemEntity;
import com.kingshuk.testing.springtestingranga.data.model.ProductEntity;
import com.kingshuk.testing.springtestingranga.model.OrderItem;
import com.kingshuk.testing.springtestingranga.model.Product;
import com.kingshuk.testing.springtestingranga.service.OrderItemBusinessService;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemBusinessServiceWithMockitoTest {

	@Mock
	private OrderItemRepository orderItemRepository;

	@InjectMocks
	private OrderItemBusinessService businessService;

	@Spy
	private DozerBeanMapper mapper;

	@Before
	public void setUp() {
		mapper = new DozerBeanMapper();
		List<String> mappingFiles = new ArrayList<>();
		mappingFiles.add("dozerJdk8Converters.xml");
		mapper.setMappingFiles(mappingFiles);
		
		ReflectionTestUtils.setField(businessService, "mapper", mapper);
	}

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
