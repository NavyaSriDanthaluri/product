package com.abc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.test.entity.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {

}
