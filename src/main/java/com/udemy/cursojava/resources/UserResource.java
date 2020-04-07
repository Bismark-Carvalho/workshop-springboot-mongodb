package com.udemy.cursojava.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursojava.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User u1 = new User(1L, "Maria", "maria@gmail.com");
		List<User> list = new ArrayList<User>();
		list.add(u1);
		return ResponseEntity.ok().body(list);
	}
	
}
