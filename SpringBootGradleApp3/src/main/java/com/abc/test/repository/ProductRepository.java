package com.abc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.test.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> , IProductCustomRepository
{
 // no code at all
}