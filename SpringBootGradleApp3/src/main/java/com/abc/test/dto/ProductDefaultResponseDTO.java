package com.abc.test.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDefaultResponseDTO implements MyDTO{
	
	private String productName;
	private int productId;
	private int certificateNumber;
	private String remarks;

}
