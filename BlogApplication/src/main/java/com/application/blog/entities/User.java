package com.application.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
//	@NotEmpty
//	@Size(min = 4,message = "User name must be minimum of 4 chars")
	private String name;
	
//	@Email(message = "Email is not valid")
	private String email;

//	@Size(min = 3,max = 10, message = "password must be minimum of 3 chars and maximum of 10 chars")
	private String password;
	
//	@NotEmpty
	private String about;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Post> posts=new ArrayList<>();
}