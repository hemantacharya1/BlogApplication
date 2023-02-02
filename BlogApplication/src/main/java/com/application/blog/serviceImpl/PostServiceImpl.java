package com.application.blog.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.application.blog.dtos.PostDTO;
import com.application.blog.dtos.PostResponse;
import com.application.blog.entities.Category;
import com.application.blog.entities.Post;
import com.application.blog.entities.User;
import com.application.blog.exception.ResourceNotFoundException;
import com.application.blog.repository.CategoryRepo;
import com.application.blog.repository.PostRepo;
import com.application.blog.repository.UserRepo;
import com.application.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo pRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private CategoryRepo cRepo;
	
	@Override
	public PostDTO updatePost(PostDTO dto,Integer postId) {
		Post post=pRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Id", postId));
		
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
		
		Post updated=pRepo.save(post);
		
		return modelMapper.map(updated, PostDTO.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=pRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Id", postId));
		pRepo.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {
		
		Sort sort=null;
		
		if(sortDir.equalsIgnoreCase("asc")) {
			sort=Sort.by(sortBy).ascending();
		}
		else if(sortDir.equalsIgnoreCase("desc")) {
			sort=Sort.by(sortBy).descending();
		}
		
		Pageable p=PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Post>pagePost=pRepo.findAll(p);
		
		List<Post>posts=pagePost.getContent();
		
		if(posts.size()==0)
			throw new ResourceNotFoundException("Post", "Id", 0);
		
		List<PostDTO> dtoList=posts.stream().map(post->modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());
		
		PostResponse postResponse=new PostResponse();
		
		postResponse.setContent(dtoList);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalPages());
		postResponse.setTotalPages(pagePost.getTotalPages());
		
		postResponse.setLastPage(pagePost.isLast());
		
		
		return postResponse;
	}

	@Override
	public PostDTO getPostById(Integer postId) {
		Post post=pRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Id", postId));
		
		return modelMapper.map(post, PostDTO.class);
	}

	@Override
	public List<PostDTO> getPostByCategory(Integer categoryId) {
		Category category=cRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Id", categoryId));
		System.out.println(category.getCategoryTitle());
		List<Post> posts=pRepo.findByCategory(category);
		posts.forEach(i->System.out.println(i.getContent()));
		
		List<PostDTO>postDtoList=posts.stream().map(post->modelMapper.
									  map(post, PostDTO.class)).collect(Collectors.toList());
		postDtoList.forEach(i->System.out.println(i.getTitle()));
		
		return postDtoList;
	}

	@Override
	public List<PostDTO> getPostByUserId(Integer userId) {
		User user=uRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		
		List<Post>posts=pRepo.findByUser(user);
		
		List<PostDTO> dtoList=posts.stream().map(post-> modelMapper.map(post, PostDTO.class))
									.collect(Collectors.toList());
		
		return dtoList;
	}

	@Override
	public PostDTO createPost(PostDTO dto, Integer userId, Integer categoryId) {
		
		User  user=uRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		
		Category category=cRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Id", categoryId));
		
		Post post=modelMapper.map(dto,Post.class);
		post.setImageName("default.png");
		post.setPostDate(LocalDateTime.now());
		post.setUser(user);
		post.setCategory(category);
		
		Post saved=pRepo.save(post);
		
		return modelMapper.map(saved, PostDTO.class);
	}

	@Override
	public List<PostDTO> searchPosts(String keyword) {
		List<Post> posts = pRepo.findByTitleContaining(keyword);
		List<PostDTO> dtoList = posts.stream().map(post->modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		return dtoList; 
	}

}
