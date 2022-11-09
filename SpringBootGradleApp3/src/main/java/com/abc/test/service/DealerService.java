package com.abc.test.service;

import org.springframework.stereotype.Service;

import com.abc.test.entity.Dealer;

@Service
public interface DealerService {
	
	public Dealer addDealer(Dealer dealer);

}
