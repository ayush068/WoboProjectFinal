package com.example.webo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webo.model.Customer;




public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

	

	

}
