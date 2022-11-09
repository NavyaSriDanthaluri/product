package com.abc.test.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abc.test.dto.ProductDealerCreatedResponseDTO;
import com.abc.test.dto.ProductDefaultResponseDTO;
import com.abc.test.entity.Dealer;
import com.abc.test.entity.Product;

@Component
@Scope("singleton")
public class ProductDTOConvertor {
	
	public static ProductDefaultResponseDTO  getProductDefaultDTO(Product product)
	{
		ProductDefaultResponseDTO dto = new ProductDefaultResponseDTO(
				                 product.getProductName(), 
				                 product.getProductId(), 
				                 product.getProductInfo().getWeight(),
				                 "Product info Created ,  Certificate number : "+product.getProductInfo().getCertificateNumber());
		
		return dto;
	}
	
	public static ProductDealerCreatedResponseDTO getDealerCreatedDTO(Product product,Dealer dealer)
	{
		ProductDealerCreatedResponseDTO dto = new ProductDealerCreatedResponseDTO(
				 product.getProductName(), 
                 product.getProductId(), 
                 dealer.getMailId(),
                 "Dealer Added "+dealer.getDealerId()
                 );
				 
				 return dto;
	}

}
