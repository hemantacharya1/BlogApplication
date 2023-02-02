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

import com.application.blog.dtos.UserDTO;
import com.application.blog.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService uService;
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto){
		UserDTO saved=uService.createUser(dto);
		
		return new ResponseEntity<UserDTO>(saved,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer userId){
		UserDTO deleted=uService.deleteUser(userId);
		
		return new ResponseEntity<UserDTO>(deleted, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO dto,@PathVariable Integer userId){
		UserDTO updated=uService.updateUser(dto, userId);
		
		return new ResponseEntity<UserDTO>(updated, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId){
		UserDTO user=uService.getUserById(userId);
		
		return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUser(){
		List<UserDTO>userList=uService.getAllUser();
		
		return new ResponseEntity<List<UserDTO>>(userList,HttpStatus.OK);
	}
}
