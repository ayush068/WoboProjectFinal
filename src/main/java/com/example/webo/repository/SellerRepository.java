package com.example.webo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webo.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
