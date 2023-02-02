package com.application.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.dtos.UserDTO;
import com.application.blog.entities.User;
import com.application.blog.exception.ResourceNotFoundException;
import com.application.blog.repository.UserRepo;
import com.application.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo uRepo;
	
	@Override
	public UserDTO createUser(UserDTO dto) {
		
		User user=this.userDtoToUser(dto);
		
		User savedUser=uRepo.save(user);
		
		return userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO dto, Integer userId) {
		
		User user=uRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setPassword(dto.getPassword());
		user.setAbout(dto.getAbout());
		
		User updated=uRepo.save(user);
		
		return userToDto(updated);
	}

	@Override
	public UserDTO getUserById(Integer userId){
		
		User user=uRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		
		
		return userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUser() {
		
		List<User> users=uRepo.findAll();
		
		List<UserDTO> userDtoList=users.stream().map(user-> userToDto(user)).collect(Collectors.toList());
		
		return userDtoList;
	}
	
	private User userDtoToUser(UserDTO dto) {
		
		User user=new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setAbout(dto.getAbout());
		user.setUserId(dto.getId());
		
		return user;
	}
	
	private UserDTO userToDto(User user) {
		UserDTO dto = new UserDTO();
		
		dto.setAbout(user.getAbout());
		dto.setEmail(user.getEmail());
		dto.setId(user.getUserId());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		
		return dto;
	}

	@Override
	public UserDTO deleteUser(Integer userId) {
		User user=uRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		
		uRepo.delete(user);
		
		return userToDto(user);
	}
}
