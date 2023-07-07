package com.example.webo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webo.model.Brand;



public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
