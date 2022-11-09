package com.abc.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productinfo")
public class ProductInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int certificateNumber;
	@NotNull(message = "Country cannot be Null")
	@Size(min = 2,message = "country is not valid, should have more than 2 characters")
	private String countryOfOrigin;
	private String manufacturingDate;
	private int weight;
	private String color;
	
	public ProductInfo(String countryOfOrigin, String manufacturingDate, int weight, String color) {
		super();
		this.countryOfOrigin = countryOfOrigin;
		this.manufacturingDate = manufacturingDate;
		this.weight = weight;
		this.color = color;
	}
	
	
}
