package com.example.webo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
		List<Product> findAllByCategory_Id(int id);

		

		List<Product> findAllByBrand_Id(int id);

		List<Product> findAllBySubcategory_Id(int id);
	
	}


