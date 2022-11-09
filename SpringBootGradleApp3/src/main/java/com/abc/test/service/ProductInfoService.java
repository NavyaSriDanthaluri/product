package com.abc.test.service;

import org.springframework.stereotype.Service;

import com.abc.test.entity.ProductInfo;

@Service
public interface ProductInfoService {
	
	public ProductInfo addProductInfo(ProductInfo productInfo);

}
