package com.amit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
