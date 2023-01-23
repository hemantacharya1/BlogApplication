package com.application.blog.service;

import java.util.List;

import com.application.blog.dtos.UserDTO;

	public interface UserService {

	public UserDTO createUser(UserDTO user)throws UserException;
	
	public UserDTO updateUser(UserDTO dto, Integer userId) throws UserException;
	
	public UserDTO getUserById(Integer userId) throws UserException;
	
	public List<UserDTO> getAllUser() throws UserException;
	
	public UserDTO deleteUser(Integer userId) throws UserException;
}
