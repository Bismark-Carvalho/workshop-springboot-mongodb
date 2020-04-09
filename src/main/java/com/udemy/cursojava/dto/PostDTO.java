package com.udemy.cursojava.dto;

import java.io.Serializable;

import com.udemy.cursojava.domain.Post;
import com.udemy.cursojava.domain.User;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String body;
	private User author;

	public PostDTO() {
	}
	
	public PostDTO(Post obj) {
		id = obj.getId();
		title = obj.getTitle();
		body = obj.getBody();
		author = obj.getAuthor();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setEmail(String body) {
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
}