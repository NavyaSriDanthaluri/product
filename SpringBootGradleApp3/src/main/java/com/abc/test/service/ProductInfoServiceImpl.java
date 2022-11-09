package com.abc.test.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.test.entity.ProductInfo;
import com.abc.test.repository.ProductInfoRepository;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	ProductInfoRepository productInfoRepository;
	
	@Override
	@Transactional
	public ProductInfo addProductInfo(ProductInfo info) {
		
		ProductInfo savedInfo = productInfoRepository.save(info);
		
		return savedInfo;
	}

}
