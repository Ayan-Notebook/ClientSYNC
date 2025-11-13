package com.ClientSync.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ClientSync.entity.Customer;

@Repository
public class Dao {
	@Autowired
	SessionFactory sf;

	public Dao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public String insertCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(customer);
		tr.commit();
		session.close();
		return "Customer inserted successfully";
	}

	public List<Customer> getCustomersList() {
		Session session = sf.openSession();
		return session.createQuery("from Customer").list();
	}

	public Customer getCustomerById(int id) {
		Session session = sf.openSession();
		return session.get(Customer.class, id);
	}

	public String updateCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(customer);
		tr.commit();
		session.close();
		return "Customer updated successfully";
	}

	public String deleteCustomerById(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tr.commit();
		session.close();
		return "Customer deleted successfully";
	}

	public String insertMultipleCustomers(List<Customer> customers) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for (Customer customer: customers) {
			session.save(customer);
		}
		tr.commit();
		session.close();
		return "Customers are inserted successfully";
	}
	
	public List<Customer> getCustomersByFirstName (String firstName) {
		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.firstName=:firstName", Customer.class);
		customers.setParameter("firstName", firstName);
		List<Customer> list = customers.list();
		return list;
	}
	
	public List<Customer> getCustomersByLessThanAge (String age) {
		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.age<:age", Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		return list;
	}
	
	public List<Customer> getCustomersByGreaterThanAge (String age) {
		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.age>:age", Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		return list;
	}
	
	public List<Customer> getCustomersByAge (String age) {
		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.age=:age", Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		return list;
	}
	
	public List<Customer> getCustomersByLastName (String lastName) {
		Session session = sf.openSession();
		Query<Customer> customers = session.createQuery("from Customer c where c.lastName=:lastName", Customer.class);
		customers.setParameter("lastName", lastName);
		List<Customer> list = customers.list();
		return list;
	}
	
	public String updateCustomerFirstName (int id, String firstName) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setFirstName(firstName);
		tr.commit();
		session.close();
		return "Customer first name updated successfully";
	}
	
	public String updateCustomerLastName (int id, String lastName) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setLastName(lastName);
		tr.commit();
		session.close();
		return "Customer last name updated successfully";
	}
	
	public List<Customer> getCustomerFirstNames () {
		Session session = sf.openSession();
		return session.createQuery("select c.firstName from Customer c").list();
	}
	
	public List<Customer> getCustomerLastNames () {
		Session session = sf.openSession();
		return session.createQuery("select c.lastName from Customer c").list();
	}
	
	public List<Customer> getCustomerMobileNumbers () {
		Session session = sf.openSession();
		return session.createQuery("select c.mobileNumber from Customer c").list();
	}
}
