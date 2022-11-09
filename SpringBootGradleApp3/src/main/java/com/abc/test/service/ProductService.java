package com.abc.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.test.entity.Dealer;
import com.abc.test.entity.Product;
import com.abc.test.entity.ProductInfo;

@Service
public interface ProductService {
	
	public List<Product> getAllProducts() throws Exception;
	public Product getProductByProductCode(int productCode) throws Exception;
	public Product getProductByProductName(String productName) throws Exception;
	public List<Product> getProductByCategory(String category) throws Exception;
	public List<Product> getProductsByCategoryAndPriceRangeAndDealerName(String category , float price1, float price2 , String dealerName) throws Exception;
	public List<Product> getAllProductsByDealerName(String dealerName) throws Exception;
	public List<Product> getAllProductsByCategoryAndPriceAndRating(String category, float price, float rating) throws Exception;
	
	
	public Product addDealer(Dealer dealer,Product product);
	
	
	public String insertProduct(Product p)throws Exception;
	public Product linkProductInfo(ProductInfo productInfo, Product product);
	public Product getProductById(int id) throws Exception;
	
}