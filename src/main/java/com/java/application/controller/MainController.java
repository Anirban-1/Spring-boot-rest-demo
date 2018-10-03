package com.java.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.application.DemoApplication;
import com.java.application.model.*;

@RestController
@RequestMapping("/test")
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/add")
	public Customer addCustomer(@RequestParam(value="name", defaultValue="John")String firstName) {
		log.info("Customer name: "+firstName);
		
		Customer c=new Customer(firstName, "Default");
		customerRepository.save(c);
		return c;
	}
}
