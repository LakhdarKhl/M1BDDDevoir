package com.m1.bdd_merise_m1.repository;

import com.m1.bdd_merise_m1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}