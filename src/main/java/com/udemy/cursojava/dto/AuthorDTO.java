package com.udemy.cursojava.dto;

import java.io.Serializable;

import com.udemy.cursojava.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO() {
	}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
