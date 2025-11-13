package com.ClientSync.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ClientSync.dao.Dao;
import com.ClientSync.entity.Customer;
import com.ClientSync.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	Dao customerDao;

	public CustomerServiceImpl(Dao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public String insertCustomer(Customer customer) {

		return customerDao.insertCustomer(customer);
	}
	
	@Override
	public List<Customer> getCustomersList() {
		
		return customerDao.getCustomersList();
	}
	
	@Override
	public Customer getCustomerById(int id) {
		
		return customerDao.getCustomerById(id);
	}
	
	@Override
	public String updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}
	
	@Override
	public String deleteCustomerById(int id) {
		
		return customerDao.deleteCustomerById(id);
	}
	
	@Override
	public String insertMultipleCustomers(List<Customer> customers) {
		
		return customerDao.insertMultipleCustomers(customers);
	}
	
	@Override
	public List<Customer> getCustomersByFirstName (String firstName) {
		return customerDao.getCustomersByFirstName(firstName);
	}
	
	@Override
	public List<Customer> getCustomersByLessThanAge (String age) {
		return customerDao.getCustomersByLessThanAge(age);
	}
	
	@Override
	public List<Customer> getCustomersByGreaterThanAge (String age) {
		return customerDao.getCustomersByGreaterThanAge(age);
	}
	
	@Override
	public List<Customer> getCustomersByAge (String age) {
		return customerDao.getCustomersByAge(age);
	}
	
	@Override
	public List<Customer> getCustomersByLastName (String lastName){
		return customerDao.getCustomersByLastName(lastName);
	}
	
	@Override
	public String updateCustomerFirstName (int id, String firstName) {
		return customerDao.updateCustomerFirstName(id, firstName);
	}
	
	@Override
	public String updateCustomerLastName (int id, String lastName) {
		return customerDao.updateCustomerLastName(id, lastName);
	}
	
	@Override
	public List<Customer> getCustomerFirstNames () {
		return customerDao.getCustomerFirstNames();
	}
	
	@Override
	public List<Customer> getCustomerLastNames () {
		return customerDao.getCustomerLastNames();
	}
	
	@Override
	public List<Customer> getCustomerMobileNumbers () {
		return customerDao.getCustomerMobileNumbers();
	}
}
