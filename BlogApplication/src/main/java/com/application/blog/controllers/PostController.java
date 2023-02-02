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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.blog.dtos.PostDTO;
import com.application.blog.dtos.PostResponse;
import com.application.blog.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService pService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDTO> createPost(@PathVariable Integer userId,
											  @PathVariable Integer categoryId,
											  @RequestBody PostDTO dto){
		
		PostDTO saved=pService.createPost(dto, userId, categoryId);
		
		return new ResponseEntity<PostDTO>(saved,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDTO>> getPostsByUserId(@PathVariable Integer userId){

		List<PostDTO> dtoList=pService.getPostByUserId(userId);

		return new ResponseEntity<List<PostDTO>>(dtoList,HttpStatus.OK);
	}
	
	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<List<PostDTO>> getPostsByCategoryId(@PathVariable Integer catId){

		List<PostDTO> dtoList=pService.getPostByCategory(catId);

		return new ResponseEntity<List<PostDTO>>(dtoList,HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDTO> getPostsById(@PathVariable Integer postId){

		PostDTO post=pService.getPostById(postId);

		return new ResponseEntity<PostDTO>(post,HttpStatus.OK);
	}
	

	@GetMapping("/posts/")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber",defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false)Integer pageSize,
			@RequestParam(value ="sortBy", defaultValue = "postId", required = false)String sortBy,
			@RequestParam(value="sortDir", defaultValue = "asc", required = false)String sortDir
			){

		PostResponse allPost = pService.getAllPost(pageNumber, pageSize, sortBy, sortDir);

		return new ResponseEntity<PostResponse>(allPost,HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<String> deletePostById(@PathVariable Integer postId){

		pService.deletePost(postId);

		return new ResponseEntity<String>("Post deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDTO> updatePost(@PathVariable Integer postId,@RequestBody PostDTO dto){

		PostDTO post=pService.updatePost(dto, postId);

		return new ResponseEntity<PostDTO>(post,HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keyWords}")
	public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable String keyWords){
		List<PostDTO> searchPosts = pService.searchPosts(keyWords);
		
		return new ResponseEntity<List<PostDTO>>(searchPosts, HttpStatus.OK);
	}
}
