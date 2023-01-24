package com.application.blog.service;

import java.util.List;

import com.application.blog.dtos.UserDTO;

	public interface UserService {

	public UserDTO createUser(UserDTO user);
	
	public UserDTO updateUser(UserDTO dto, Integer userId);
	
	public UserDTO getUserById(Integer userId);
	
	public List<UserDTO> getAllUser();
	
	public UserDTO deleteUser(Integer userId);
}
