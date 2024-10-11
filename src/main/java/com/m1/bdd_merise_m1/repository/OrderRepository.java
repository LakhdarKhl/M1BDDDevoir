package com.m1.bdd_merise_m1.repository;

import com.m1.bdd_merise_m1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}