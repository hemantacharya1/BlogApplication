package com.application.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.blog.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
