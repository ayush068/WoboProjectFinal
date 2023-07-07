package com.example.webo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webo.model.Product;
import com.example.webo.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void removeProductById(Long id) {
	productRepository.deleteById(id);
	
}
	public Optional<Product> getProductById(long id){
		return productRepository.findById(id);	
	}
	public List<Product> getAllProductsByCategoryId(int id){
		System.out.println("Category ID: " + id); // Add logging statement to check the value
		return productRepository.findAllByCategory_Id(id);
	}
	public List<Product> getAllProductsBySubcategoryId(int id){
		return productRepository.findAllBySubcategory_Id(id);
	}
	
	public List<Product> getAllProductsByBrandId(int id){
		System.out.println("Brand ID: " + id); // Add logging statement to check the value
		return productRepository.findAllByBrand_Id(id);
	}
}
