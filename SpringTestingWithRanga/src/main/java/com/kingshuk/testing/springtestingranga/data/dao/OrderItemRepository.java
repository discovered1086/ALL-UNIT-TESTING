package com.kingshuk.testing.springtestingranga.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.testing.springtestingranga.data.model.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

}
