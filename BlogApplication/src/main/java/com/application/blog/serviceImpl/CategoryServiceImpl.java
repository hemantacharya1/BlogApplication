package com.application.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.dtos.CategoryDTO;
import com.application.blog.entities.Category;
import com.application.blog.exception.ResourceNotFoundException;
import com.application.blog.repository.CategoryRepo;
import com.application.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo cRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDTO createCategory(CategoryDTO dto) {
		
		Category category=modelMapper.map(dto, Category.class);
		
		cRepo.save(category);
		
		return modelMapper.map(category,CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO dto,Integer categoryId) {
		
		Category cat=cRepo.findById(categoryId).
				orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		cat.setCategoryDescription(dto.getCategoryDescription());
		cat.setCategoryTitle(dto.getCategoryTitle());
		
		Category updated=cRepo.save(cat);
		
		return modelMapper.map(updated, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=cRepo.findById(categoryId).
				orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		cRepo.delete(cat);
	}

	@Override
	public CategoryDTO getCategoryById(Integer categoryId) {
		Category cat=cRepo.findById(categoryId).
				orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		
		return modelMapper.map(cat, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category>categoryList=cRepo.findAll();
		
		List<CategoryDTO> dtoList=categoryList.stream().map(cat->modelMapper
										.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return dtoList;
	}


}
