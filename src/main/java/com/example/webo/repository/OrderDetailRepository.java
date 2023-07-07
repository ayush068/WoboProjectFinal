package com.example.webo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webo.model.OrderDetails;

public interface OrderDetailRepository  extends JpaRepository<OrderDetails,Long> {

}
