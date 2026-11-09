package com.project.course.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.course.entities.Order;
import com.project.course.entities.User;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1=new User(null, "Rogerio Pinto", "RogerioPinto@gmail.com", "99921312312", "123456");
		User u2= new User(null, "Maria Eduarda", "Eduarda@outlook.com", "99999999999", "654321");
		
		Order o1 = new Order(null, Instant.parse("2026-11-08T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2026-11-08T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2026-11-08T15:21:22Z"), u1);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
}
