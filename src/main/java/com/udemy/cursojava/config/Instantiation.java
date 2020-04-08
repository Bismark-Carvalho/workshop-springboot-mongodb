package com.udemy.cursojava.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.udemy.cursojava.domain.User;
import com.udemy.cursojava.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository user;
	private List<User> userList = new ArrayList<User>();
	
	@Override
	public void run(String... args) throws Exception {
		user.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userList.add(alex);
		userList.add(bob);
		userList.add(maria);
		user.saveAll(userList);
	}

}
