package com.udemy.cursojava.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursojava.domain.Post;
import com.udemy.cursojava.exceptions.ObjectNotFoundException;
import com.udemy.cursojava.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Post insert(Post user) {
		return repo.save(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	
	public Post update(Post obj) {
		Post newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate ) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000 );
		return repo.fullSearch(text, minDate, maxDate);
	}

	private void updateData(Post newObj, Post obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setBody(obj.getBody());
	}
	
	
	
}
