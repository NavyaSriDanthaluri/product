package com.abc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.test.entity.ProductInfo;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {
	

}
