package com.example.webo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webo.model.SubCategory;
import com.example.webo.repository.SubCategoryRepository;



	@Service
	
public class SubCategoryService {
		 private final SubCategoryRepository subCategoryRepository;

		    @Autowired
		    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
		        this.subCategoryRepository = subCategoryRepository;
		    }

    public List<SubCategory> getAllSubCategory() {
        return subCategoryRepository.findAll();
    }

    public void addSubCategory(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
    }

    public void removeSubCategoryById(int id) {
        subCategoryRepository.deleteById(id);
    }

    public Optional<SubCategory> getSubCategoryById(int id) {
        return subCategoryRepository.findById(id);
    }

	

	
}
