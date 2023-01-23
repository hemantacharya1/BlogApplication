package com.application.blog.dtos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {

	private List<PostDTO> content;
	private Integer pageNumber;
	private Integer totalElements;
	private Integer pageSize;
	private Integer totalPages;
	
	private Boolean lastPage;
}
