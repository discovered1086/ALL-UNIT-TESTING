package com.kingshuk.testing.springtestingranga.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.testing.springtestingranga.data.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
