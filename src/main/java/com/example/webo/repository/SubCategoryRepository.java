package com.example.webo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webo.model.SubCategory;


@Repository
public interface SubCategoryRepository  extends JpaRepository<SubCategory, Integer>{

	
	

	
}
