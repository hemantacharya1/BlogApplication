package com.application.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.blog.entities.Category;
import com.application.blog.entities.Post;
import com.application.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{


	public List<Post> findByUser(User user);
	
	public List<Post> findByCategory(Category category);
	
	public List<Post> findByTitleContaining(String title);
}
