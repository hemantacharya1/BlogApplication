package com.application.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.blog.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
