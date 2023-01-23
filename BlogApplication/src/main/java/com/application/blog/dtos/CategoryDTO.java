package com.application.blog.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

	private Integer categoryId;
	private String categoryTitle;
	private String categoryDescription;
}
