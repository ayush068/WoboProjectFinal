package com.example.webo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.webo.dto.ProductDTO;
import com.example.webo.model.Brand;
import com.example.webo.model.Category;
import com.example.webo.model.Product;
import com.example.webo.model.SubCategory;
import com.example.webo.repository.SubCategoryRepository;
import com.example.webo.service.BrandService;
import com.example.webo.service.CategoryService;
import com.example.webo.service.ProductService;
import com.example.webo.service.SubCategoryService;

@Controller
public class AdminController {
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

	 private final CategoryService categoryService;

	    public AdminController(CategoryService categoryService) {
	        this.categoryService = categoryService;
	    }
	    
	    @Autowired
	    ProductService productService;
	    
	    
	    
	    @Autowired
	    SubCategoryService subcategoryService;
	    
	    
	    @Autowired
	    BrandService brandService;


@GetMapping("/admin")
public String AdminHome() {
	return "AdminHome";
}
//Statatics Section
@GetMapping("/statitics")
public String Statitics() {
	return "Statitics";
}

//Brand Section

@GetMapping("/admin/brands")
public String getBat(Model model) {
	model.addAttribute("brands", brandService.getAllBrand());
	return "brands";
}

@GetMapping("/admin/brands/add")
public String getBatAdd(Model model) {
	model.addAttribute("brand", new Brand());
	return "brandsAdd";
}

@PostMapping("/admin/brands/add")
public String postBatAdd(@ModelAttribute("brand")Brand brand) {
	brandService.addBrand(brand);
	return "redirect:/admin/brands";
} 

@GetMapping("/admin/brands/delete/{id}")
public String deleteBat(@PathVariable int id) {
	brandService.removeBrandById(id);
	return "redirect:/admin/brands";
	
}

@GetMapping("/admin/brands/update/{id}")
public String updateBat(@PathVariable int id,Model model) {
Optional<Brand>brand = brandService.getBrandById(id);
if (brand.isPresent()) {
	model.addAttribute("brand", brand.get());
	return "brandsAdd";
}
else {
	return "404";

}
}


//SubCategory Section

@GetMapping("/admin/subcategories")
public String getSubCat(Model model) {
	model.addAttribute("subcategories", subcategoryService.getAllSubCategory());
	return "subcategories";
}

@GetMapping("/admin/subcategories/add")
public String getSubCatAdd(Model model) {
	model.addAttribute("subcategory", new Category());
	return "subcategoriesAdd";
}

@PostMapping("/admin/subcategories/add")
public String postSubCatAdd(@ModelAttribute("subcategory")SubCategory subcategory) {
	subcategoryService.addSubCategory(subcategory);
	return "redirect:/admin/subcategories";
} 

@GetMapping("/admin/subcategories/delete/{id}")
public String deleteSubCat(@PathVariable int id) {
	subcategoryService.removeSubCategoryById(id);
	return "redirect:/admin/subcategories";
	
}

@GetMapping("/admin/subcategories/update/{id}")
public String updateSubCat(@PathVariable int id,Model model) {
Optional<SubCategory>subcategory = subcategoryService.getSubCategoryById(id);
if (subcategory.isPresent()) {
	model.addAttribute("subcategory", subcategory.get());
	return "subcategoriesAdd";
}
else {
	return "404";

}
}


//Category Section

@GetMapping("/admin/categories")
public String getCat(Model model) {
	model.addAttribute("categories", categoryService.getAllCategory());
	return "categories";
}

@GetMapping("/admin/categories/add")
public String getCatAdd(Model model) {
	model.addAttribute("category", new Category());
	return "categoriesAdd";
}

@PostMapping("/admin/categories/add")
public String postCatAdd(@ModelAttribute("category")Category category) {
	categoryService.addCategory(category);
	return "redirect:/admin/categories";
} 

@GetMapping("/admin/categories/delete/{id}")
public String deleteCat(@PathVariable int id) {
	categoryService.removeCategoryById(id);
	return "redirect:/admin/categories";
	
}

@GetMapping("/admin/categories/update/{id}")
public String updateCat(@PathVariable int id,Model model) {
Optional<Category>category = categoryService.getCategoryById(id);
if (category.isPresent()) {
	model.addAttribute("category", category.get());
	return "categoriesAdd";
}
else {
	return "404";

}
}


//Product Section
@GetMapping("/admin/products")
public String products(Model model) {
	model.addAttribute("products",productService.getAllProduct());
	return "products";

}

@GetMapping("/admin/products/add")
public String productAddGet(Model model) {
	model.addAttribute("productDTO",new ProductDTO());
	model.addAttribute("categories", categoryService.getAllCategory());
	model.addAttribute("subcategories", subcategoryService.getAllSubCategory());
	model.addAttribute("brands", brandService.getAllBrand());
	return "productsAdd";

}

@PostMapping("/admin/products/add")
public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO,
		@RequestParam("productImage")MultipartFile file,
		@RequestParam("imgName")String imgName) throws IOException{
	
	Product product = new Product();
	product.setId(productDTO.getId());
	product.setName(productDTO.getName());
	product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
	product.setSubcategory(subcategoryService.getSubCategoryById(productDTO.getSubcategoryId()).get());
	product.setBrand(brandService.getBrandById(productDTO.getBrandId()).get());
	
	product.setPrice(productDTO.getPrice());
	product.setWeight(productDTO.getWeight());
	product.setDescription(productDTO.getDescription());
	 product.setQuantity(productDTO.getQuantity()); // Set the quantity field
	String imageUUID;
	if (!file.isEmpty()) {
		imageUUID = file.getOriginalFilename();
		 
		 Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
		 Files.write(fileNameAndPath, file.getBytes());
		
		
		
	}
	else {
		imageUUID = imgName;
	}
	product.setImageName(imageUUID);
	  productService.addProduct(product);
	

		
	return "redirect:/admin/products";
}

@GetMapping("/admin/product/delete/{id}")
public String deleteProduct(@PathVariable long id) {
	productService.removeProductById(id);
	return "redirect:/admin/products";
	
}
@GetMapping("/admin/product/update/{id}")
public String updateProductGet(@PathVariable long id,Model model) {
	
	Product product = productService.getProductById(id).get();
	ProductDTO productDTO = new ProductDTO();
	productDTO.setId(product.getId());
	productDTO.setName(product.getName());
	productDTO.setCategoryId(product.getCategory().getId());
	productDTO.setSubCategoryId(product.getSubcategory().getId());
	productDTO.setBrandId(product.getBrand().getId());
	productDTO.setWeight(product.getWeight());
	productDTO.setDescription(product.getDescription());
	productDTO.setQuantity(product.getQuantity());
	productDTO.setPrice(product.getPrice());
	productDTO.setImageName(product.getImageName());
	
	model.addAttribute("categories", categoryService.getAllCategory());
	model.addAttribute("subcategories", subcategoryService.getAllSubCategory());
	model.addAttribute("brands", brandService.getAllBrand());
	model.addAttribute("productDTO", productDTO);
	
	
	return "productsAdd";
}

}

