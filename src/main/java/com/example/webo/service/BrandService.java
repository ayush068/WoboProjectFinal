package com.example.webo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webo.model.Brand;

import com.example.webo.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	
	BrandRepository brandRepository;
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}
	public void addBrand(Brand brand) {
		brandRepository.save(brand);
		
	}
	
	public void removeBrandById(int id) {
		brandRepository.deleteById(id);
	}
	
	public Optional<Brand> getBrandById(int id) {
		return brandRepository.findById(id);
	}
	
}
