package com.application.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.dtos.CategoryDTO;
import com.application.blog.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


	@Autowired
	private CategoryService cService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){
		CategoryDTO saved=cService.createCategory(dto);
		
		return new ResponseEntity<CategoryDTO>(saved,HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO dto,@PathVariable Integer catId){
		CategoryDTO updated=cService.updateCategory(dto, catId);
		
		return new ResponseEntity<CategoryDTO>(updated,HttpStatus.OK);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer catId){
		
		cService.deleteCategory(catId);
		
		return new ResponseEntity<String>("Category deleted succesfully",HttpStatus.OK);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer catId){
		CategoryDTO cat=cService.getCategoryById(catId);
		
		return new ResponseEntity<CategoryDTO>(cat,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategories(){
		List<CategoryDTO> list=cService.getAllCategory();
		
		return new ResponseEntity<List<CategoryDTO>>(list,HttpStatus.OK);
	}
	
}
