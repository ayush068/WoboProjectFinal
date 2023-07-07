package com.example.webo.service;

import java.util.List;

import com.example.webo.model.Seller;



public interface SellerService {
	public String addSeller(Seller seller);

	public boolean checkphone(String phone);

	public List<Seller> findAllSeller();
}
