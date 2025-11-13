package com.ClientSync.service;

import java.util.List;

import com.ClientSync.entity.Customer;

public interface CustomerService {
	String insertCustomer(Customer customer);
	List<Customer> getCustomersList();
	Customer getCustomerById(int id);
	String updateCustomer(Customer customer);
	String deleteCustomerById(int id);
	String insertMultipleCustomers(List<Customer> customers);
	List<Customer> getCustomersByFirstName (String firstName);
	List<Customer> getCustomersByLessThanAge (String age);
	List<Customer> getCustomersByGreaterThanAge (String age);
	List<Customer> getCustomersByAge (String age);
	List<Customer> getCustomersByLastName (String lastName);
	String updateCustomerFirstName (int id, String firstName);
	String updateCustomerLastName (int id, String lastName);
	List<Customer> getCustomerFirstNames ();
	List<Customer> getCustomerLastNames ();
	List<Customer> getCustomerMobileNumbers ();
}
