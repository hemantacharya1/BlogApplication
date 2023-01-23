package com.application.blog.service;

import java.util.List;

import com.application.blog.dtos.CategoryDTO;

public interface CategoryService {

	CategoryDTO createCategory(CategoryDTO dto);
	 
	void deleteCategory(Integer categoryId);
	 
	CategoryDTO getCategoryById(Integer CategoryId);
	 
	List<CategoryDTO> getAllCategory();

	CategoryDTO updateCategory(CategoryDTO dto, Integer categoryId);
}
