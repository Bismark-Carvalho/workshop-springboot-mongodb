package com.udemy.cursojava.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

	@Override
	public void run(String... args) throws Exception {
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		List<User> listUser = new ArrayList<User>();
		listUser.add(alex);
		listUser.add(bob);
		listUser.add(maria);
		user.deleteAll();
		user.saveAll(listUser);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		List<Post> listPost = new ArrayList<Post>();
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		listPost.add(post1);
		listPost.add(post2);
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		post.deleteAll();
		post.saveAll(listPost);
		user.save(maria);

	}

}
