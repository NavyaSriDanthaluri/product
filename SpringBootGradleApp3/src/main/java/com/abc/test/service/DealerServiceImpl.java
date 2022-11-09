package com.abc.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.test.entity.Dealer;
import com.abc.test.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService{
	
	@Autowired
	DealerRepository dealerRepository;

	@Override
	public Dealer addDealer(Dealer dealer) {
		Dealer savedDealer = dealerRepository.save(dealer);
		return savedDealer;
	}

}
