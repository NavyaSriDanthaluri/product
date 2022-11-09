package com.abc.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.test.entity.Dealer;
import com.abc.test.entity.Product;
import com.abc.test.entity.ProductInfo;
import com.abc.test.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() throws Exception {
		List<Product> allProducts =  productRepository.findAll();
		return allProducts;
	}

	@Override
	public Product getProductByProductCode(int productCode) throws Exception {
	
		 return productRepository.getProductByProductCode(productCode);
	}

	@Override
	public Product getProductByProductName(String productName) throws Exception {
	
		return productRepository.getProductByProductName(productName);
	}

	@Override
	public List<Product> getProductsByCategoryAndPriceRangeAndDealerName(String category, float price1, float price2,
			String dealerName) throws Exception {
		
		return productRepository.getProductsByCategoryAndPriceRangeAndDealerName(category, price1, price2, dealerName);
	}

	@Override
	public List<Product> getAllProductsByDealerName(String dealerName) throws Exception {
		
		return productRepository.getAllProductsByDealerName(dealerName);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPriceAndRating(String category, float price, float rating)
			throws Exception {
		
		return productRepository.getAllProductsByCategoryAndPriceAndRating(category, price, rating);
	}

	@Override
	public String insertProduct(Product p) throws Exception {
		Product savedP =  productRepository.save(p);  // Note :  save() is already implemented by Spring Data JPA
		if(savedP != null)
		{
			return "Product Saved "+savedP.getProductId()+" product name :- "+savedP.getProductName();
		}
		else return null;
	}

	@Override
	public List<Product> getProductByCategory(String category) throws Exception {
	
		return productRepository.getProductByCategory(category);
	}

	@Override
	@Transactional
	public Product linkProductInfo(ProductInfo productInfo, Product product) {
		product.setProductInfo(productInfo);
		return product;
	}

	@Override
	@Transactional
	public Product addDealer(Dealer dealer, Product product) {
		
		List<Dealer> allProductDealers = product.getAllDealers();
		
		if(allProductDealers == null)
		{
			allProductDealers = new ArrayList<>();
			allProductDealers.add(dealer);
		}
		else
		{
			allProductDealers.add(dealer);
		}
		
		product.setAllDealers(allProductDealers);
		
		
		return product;
	}

	@Override
	public Product getProductById(int searchId) throws Exception {
		 Product outputProduct = productRepository.getReferenceById(searchId);
		 return outputProduct;
	}

}
