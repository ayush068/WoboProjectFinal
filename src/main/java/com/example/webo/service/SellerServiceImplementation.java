package com.example.webo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webo.model.Seller;
import com.example.webo.repository.SellerRepository;



@Service
public class SellerServiceImplementation implements SellerService  {

	@Autowired
	SellerRepository sepo;
	@Override
	public String addSeller(Seller seller) {
		sepo.save(seller);
		return"Seller added successfully";
		
	}

	@Override
	public boolean checkphone(String phone) {
		return false;
		
	}

	@Override
	public List<Seller> findAllSeller() {
		
			List<Seller> llist = sepo.findAll();
			
			
			
	List<Seller> sellers;

	return llist ;
			
		}
}

