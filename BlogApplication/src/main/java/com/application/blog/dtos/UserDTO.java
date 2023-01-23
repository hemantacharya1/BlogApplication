package com.application.blog.dtos;

import lombok.Data;

@Data
public class UserDTO {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private String about;
}
