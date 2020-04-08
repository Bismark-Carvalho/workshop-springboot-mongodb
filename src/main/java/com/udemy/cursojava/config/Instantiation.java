package com.udemy.cursojava.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {
	
//	@Autowired
//	private UserRepository user;
//		
//	private List<User> configUser() {
//		List<User> list = new ArrayList<User>();
//		User maria = new User(null, "Maria Brown", "maria@gmail.com");
//		User alex = new User(null, "Alex Green", "alex@gmail.com");
//		User bob = new User(null, "Bob Grey", "bob@gmail.com");
//		list.add(alex);
//		list.add(bob);
//		list.add(maria);
//		return list;
//	}
//	
	@Override
	public void run(String... args) throws Exception {
//		user.deleteAll();		
//		user.saveAll(configUser());
		System.out.println("Iniciado");
	}

}
