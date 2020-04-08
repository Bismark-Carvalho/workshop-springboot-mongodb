package com.udemy.cursojava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.cursojava.domain.User;
import com.udemy.cursojava.dto.UserDTO;
import com.udemy.cursojava.exceptions.ObjectNotFoundException;
import com.udemy.cursojava.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return repo.save(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO dto) {
		return (new User(dto.getId(), dto.getName(), dto.getEmail()));
	}
	
}
