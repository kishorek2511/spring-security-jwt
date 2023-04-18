package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
