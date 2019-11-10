package com.babbyunplugged.couchbase.demo;

//https://blog.couchbase.com/couchbase-spring-boot-spring-data/
//https://stackoverflow.com/questions/53177777/couchbase-6-0-springboot-invalidpasswordexception
//http://127.0.0.1:8080/customer

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babbyunplugged.couchbase.demo.model.Customer;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private CustomerRepo customerRepo;
	
	@PostConstruct
	public void initCustomer() {
		customerRepo.saveAll(Stream.of(new Customer(231,"Prashant","H103 kings park"),
				new Customer(111,"Amit","H104 kings park")).collect(Collectors.toList()));
	}
	
	@GetMapping("/customer")
	public Iterable<Customer> getCustomer(){
		return customerRepo.findAll();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
