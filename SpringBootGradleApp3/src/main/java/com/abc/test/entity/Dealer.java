package com.abc.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dealers")
public class Dealer {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int dealerId;
	private long contactNumber;
	private String mailId;
	private String description;
	
	public Dealer(long contactNumber, String mailId, String description) {
		super();
		this.contactNumber = contactNumber;
		this.mailId = mailId;
		this.description = description;
	}
	

}
