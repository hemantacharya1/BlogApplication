package com.application.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String feildName;
	private Integer feildValue;
	public ResourceNotFoundException(String resourceName, String feildName, Integer  feildValue) {
		super(resourceName+" not found with "+feildName+" "+feildValue);
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
	

	
}
