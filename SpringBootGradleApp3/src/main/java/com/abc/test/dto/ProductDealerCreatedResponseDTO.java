package com.abc.test.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDealerCreatedResponseDTO implements MyDTO{

	
	private String productName;
	private int productId;
	private String remarks;
	private String dealerDescription;
}
