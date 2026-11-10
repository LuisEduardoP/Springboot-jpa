package com.project.course.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.course.entities.Category;
import com.project.course.entities.Order;
import com.project.course.entities.OrderItem;
import com.project.course.entities.Product;
import com.project.course.entities.User;
import com.project.course.entities.enums.OrderStatus;
import com.project.course.repositories.CategoryRepository;
import com.project.course.repositories.OrderItemRepository;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.ProductRepository;
import com.project.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private final OrderItemRepository orderItemRepository;
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	public TestConfig(UserRepository userRepository, OrderRepository orderRepository,
			CategoryRepository categoryRepository, ProductRepository productRepository, OrderItemRepository ordeItemRepository, OrderItemRepository orderItemRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Rogerio Pinto", "RogerioPinto@gmail.com", "99921312312", "123456");
		User u2 = new User(null, "Maria Eduarda", "Eduarda@outlook.com", "99999999999", "654321");

		Order o1 = new Order(null, Instant.parse("2026-11-08T19:53:07Z"), OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.parse("2026-11-08T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2026-11-08T15:21:22Z"), OrderStatus.PAID, u1);

		Category cat1 = new Category(null, "books");
		Category cat2 = new Category(null, "Computers");
		Category cat3=new Category(null,"Electronics");

		Product p1 = new Product(null, "Clean Code", "Guia prático para escrever código limpo e legível.", 79.9, "");
		Product p2 = new Product(null, "iPhone 15", "Smartphone com tela OLED e câmera de 48 MP.", 5499.0, "");
		Product p3 = new Product(null, "Notebook Dell Inspiron", "Notebook com 16 GB de RAM e SSD de 512 GB.", 3299.0, "");
		Product p4 = new Product(null, "Teclado Mecânico", "Teclado com switches blue e iluminação RGB.", 249.9, "");
		Product p5 = new Product(null, "Fone Bluetooth", "Fone sem fio com cancelamento de ruído.", 399.0, "");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		p1.getCategories().add(cat1); 
		p2.getCategories().add(cat3); 
		p3.getCategories().add(cat2); 
		p3.getCategories().add(cat3); 
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
	}

}
