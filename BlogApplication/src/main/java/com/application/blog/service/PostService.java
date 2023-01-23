package com.application.blog.service;

import java.util.List;

import com.application.blog.dtos.PostDTO;
import com.application.blog.dtos.PostResponse;

public interface PostService {

	public PostDTO createPost(PostDTO dto,Integer userId, Integer categoryId);
	
	public PostDTO updatePost(PostDTO dto,Integer postId);
	
	public void deletePost(Integer postId);
	
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir);
	
	public PostDTO getPostById(Integer postId);
	
	public List<PostDTO> getPostByCategory(Integer categoryId);
	
	public List<PostDTO> getPostByUserId(Integer userId);
	
	public List<PostDTO> searchPosts(String keyword);
}
