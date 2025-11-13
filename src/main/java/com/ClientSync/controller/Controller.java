package com.ClientSync.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClientSync.entity.Customer;
import com.ClientSync.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class Controller {
	CustomerService customerService;

	public Controller(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping("/insert")
	public String insertCustomer(@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getCustomersList() {
		return customerService.getCustomersList();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@PutMapping
	public String updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		return customerService.deleteCustomerById(id);
	}
	
	@PostMapping
	public String insertMultipleCustomers(@RequestBody List<Customer> customers) {
		return customerService.insertMultipleCustomers(customers);
	}
	
	@GetMapping("/byname/{firstName}")
	public List<Customer> getCustomersByFirstName (@PathVariable String firstName) {
		return customerService.getCustomersByFirstName(firstName);
	}
	
	@GetMapping("/byLessThanAge/{age}")
	public List<Customer> getCustomersByLessThanAge (@PathVariable String age) {
		return customerService.getCustomersByLessThanAge(age);
	}
	
	@GetMapping("/byGreaterThanAge/{age}")
	public List<Customer> getCustomersByGreaterThanAge (@PathVariable String age) {
		return customerService.getCustomersByGreaterThanAge(age);
	}
	
	@GetMapping("/byage/{age}")
	public List<Customer> getCustomersByAge (@PathVariable String age) {
		return customerService.getCustomersByAge(age);
	}
	
	@GetMapping("/bylastname/{lastName}")
	public List<Customer> getCustomersByLastName (@PathVariable String lastName) {
		return customerService.getCustomersByLastName(lastName);
	}
	
	@PutMapping("/fname/{id}")
	public String updateCustomerFirstName (@PathVariable int id, @RequestBody Map<String, String> request) {
		String firstName = request.get("firstName");
		return customerService.updateCustomerFirstName(id, firstName);
	}
	
	@PutMapping("/lname/{id}")
	public String updateCustomerLastName (@PathVariable int id, @RequestBody Map<String, String> request) {
		String lastName = request.get("lastName");
		return customerService.updateCustomerLastName(id, lastName);
	}
	
	@GetMapping("/firstnames")
	public List<Customer> getCustomerFirstNames () {
		return customerService.getCustomerFirstNames();
	}
	
	@GetMapping("/lastnames")
	public List<Customer> getCustomerLastNames () {
		return customerService.getCustomerLastNames();
	}
	
	@GetMapping("/moblilenumbers")
	public List<Customer> getCustomerMobileNumbers () {
		return customerService.getCustomerMobileNumbers();
	}
}
