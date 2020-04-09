package com.udemy.cursojava.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.udemy.cursojava.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
		
}
