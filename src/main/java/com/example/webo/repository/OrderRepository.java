package com.example.webo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webo.model.Orders;

public interface OrderRepository extends JpaRepository <Orders,Long> {

}
