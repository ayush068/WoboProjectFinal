package com.example.webo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webo.entity.Users;
import com.example.webo.model.Customer;
import com.example.webo.repository.CustomerRepository;




@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerRepository cepo;

	@Override
	public boolean checkphone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public String addCustomer(Customer customer) {
		cepo.save(customer);
		return "Customer added successfully";
		
	}


	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> llist = cepo.findAll();
		
		
		
List<Customer> customers;

return llist ;
		
	}

}
