package com.abc.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.test.dto.MyDTO;
import com.abc.test.dto.ProductDefaultResponseDTO;
import com.abc.test.entity.Product;
import com.abc.test.service.ProductService;
import com.abc.test.util.ProductDTOConvertor;

@RestController
@RequestMapping("/product")
public class MyWebController {
	
	@Autowired
	ProductService productService;

	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}

	@PostMapping("/addProduct")
	public String addUser(@RequestBody Product pro) {

		try {
			return productService.insertProduct(pro);
		} catch (Exception e) {
			return "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
		}
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {

		try {
			List<Product> allExtractedProducts = productService.getAllProducts();

			return allExtractedProducts;

		} catch (Exception e) {
			System.out.println(e);

		}

		return null;
	}

	@GetMapping("/productname/{searchProductName}")
	public Product pro1(@PathVariable String searchProductName) throws Exception {
		return productService.getProductByProductName(searchProductName);
	}

	@GetMapping("/productcode/{searchProductCode}")
	public Product pro2(@PathVariable int searchProductCode) throws Exception {
		return productService.getProductByProductCode(searchProductCode);
	}

	@GetMapping("/productdealer/{dealer}")
	public List<Product> pro3(@PathVariable String dealer) throws Exception {
		System.out.println(" --->> 1 Inside controller " + dealer);
		return productService.getAllProductsByDealerName(dealer);
	}

	@GetMapping("/productcategory/{category}")
	public List<Product> pro4(@PathVariable String category) throws Exception {

		return productService.getProductByCategory(category);
	}

	@GetMapping("/productbycategoryandpriceanddealer")
	public List<Product> productsByCategoryAndPriceRangeAndDealerName(@RequestParam String cat, @RequestParam float p1,
			@RequestParam float p2, @RequestParam String dlr) throws Exception {

		return productService.getProductsByCategoryAndPriceRangeAndDealerName(cat, p1, p2, dlr);
	}
	
	@GetMapping("/productbycatgoryandpriceandrating")
	public List<Product> productsByCategoryAndPriceAndRating(@RequestParam String cat, @RequestParam float prc, @RequestParam float rate) throws Exception
	{
		return productService.getAllProductsByCategoryAndPriceAndRating(cat, prc, rate);
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<MyDTO> getProductByProductId(@PathVariable int id)throws Exception
	{
		
			Product product = productService.getProductById(id);
			
			ProductDefaultResponseDTO dtoResp = ProductDTOConvertor.getProductDefaultDTO(product);
			
			return new ResponseEntity<MyDTO>(dtoResp, HttpStatus.OK);
		
	}
}
