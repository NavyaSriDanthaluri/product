package com.abc.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.test.dto.ErrorDTO;
import com.abc.test.dto.MyDTO;
import com.abc.test.dto.ProductDealerCreatedResponseDTO;
import com.abc.test.entity.Dealer;
import com.abc.test.entity.Product;
import com.abc.test.service.DealerService;
import com.abc.test.service.ProductService;
import com.abc.test.util.ProductDTOConvertor;

@RestController
@RequestMapping("/product/dealer")
public class DealerRestController {

	
	@Autowired
	DealerService dealerService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/product/{productname}/dealer/{description}")
	public ResponseEntity<MyDTO> addDealerByProduct(@PathVariable String productName,@PathVariable String description)
	{
		
		Product savedProduct = null; 
		try {
		    savedProduct = productService.getProductByProductName(productName);
			if(savedProduct != null)
			{
				Dealer dealer = new Dealer(8795743456l, "dealer@gmail.com",description);
				Dealer savedDealer = dealerService.addDealer(dealer);
				
				if(savedDealer.getDealerId() != 0)
				{
					// code to link post with user
					Product updatedProductWithDealer = productService.addDealer(savedDealer, savedProduct);
					
					ProductDealerCreatedResponseDTO dto = ProductDTOConvertor.getDealerCreatedDTO(updatedProductWithDealer,dealer);
					
					return new ResponseEntity<MyDTO>(dto, HttpStatus.OK);
				}
				
			}
			else
			{
				throw new Exception("Product not found "+savedProduct+" for "+productName);
			}
			
		} catch (Exception e) {
			System.out.println(savedProduct+" is not");
			
			ErrorDTO errorDto = new ErrorDTO(e.getMessage());
			return new ResponseEntity<MyDTO>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		
		return null;
		
	}
}
