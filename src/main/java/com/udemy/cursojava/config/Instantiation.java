package com.udemy.cursojava.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.udemy.cursojava.domain.Post;
import com.udemy.cursojava.domain.User;
import com.udemy.cursojava.dto.AuthorDTO;
import com.udemy.cursojava.repository.PostRepository;
import com.udemy.cursojava.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository user;

	@Autowired
	private PostRepository post;

	User maria = new User(null, "Maria Brown", "maria@gmail.com");
	User alex = new User(null, "Alex Green", "alex@gmail.com");
	User bob = new User(null, "Bob Grey", "bob@gmail.com");

	private List<User> configUser() {
		List<User> list = new ArrayList<User>();
		list.add(alex);
		list.add(bob);
		list.add(maria);
		return list;
	}

	private List<Post> configPost() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		List<Post> list = new ArrayList<Post>();
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		list.add(post1);
		list.add(post2);
		return list;
	}

	@Override
	public void run(String... args) throws Exception {
		user.deleteAll();
		user.saveAll(configUser());
		post.deleteAll();
		post.saveAll(configPost());
		
		
	}

}
