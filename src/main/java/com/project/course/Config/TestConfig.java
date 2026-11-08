package com.project.course.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.course.entities.User;
import com.project.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1=new User(null, "Rogerio Pinto", "RogerioPinto@gmail.com", "99921312312", "123456");
		User u2= new User(null, "Maria Eduarda", "Eduarda@outlook.com", "99999999999", "654321");
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
}
