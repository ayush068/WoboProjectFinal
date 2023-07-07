package com.example.webo.service;

import java.util.List;

import com.example.webo.model.Customer;

public interface CustomerService {
	public String addCustomer(Customer customer);

	public boolean checkphone(String phone);

	public List<Customer> findAllCustomer();

}
