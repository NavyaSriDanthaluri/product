package com.abc.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.test.entity.Product;
import com.abc.test.entity.ProductInfo;
import com.abc.test.service.ProductInfoService;
import com.abc.test.service.ProductService;

@RestController
@RequestMapping("productinfo")
@Validated
public class ProductInfoWebController {
	
	
	@Autowired
	ProductInfoService productInfoService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/add")  // ....../products/info/add?productName={productName}
	public Product doProductThings(@RequestBody @Valid ProductInfo productInfo,@RequestParam String productName)
	{
		Product alreadySavedProduct = null;
		try
		{
			ProductInfo savedProductInfo = productInfoService.addProductInfo(productInfo);
			if(savedProductInfo.getCertificateNumber() != 0)
			{
				alreadySavedProduct = productService.getProductByProductName(productName);
				if(alreadySavedProduct != null)
				{
					Product productInfoAdd = productService.linkProductInfo(savedProductInfo, alreadySavedProduct);
					
					return productInfoAdd;
				}
				else
				{
					throw new Exception("product not found ,  "+alreadySavedProduct+" for "+productName);
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return alreadySavedProduct;
		}
		
		return alreadySavedProduct;
		
		// code to add the product info
	}
	
}
