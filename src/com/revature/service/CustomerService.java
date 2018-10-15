package com.revature.service;

import java.util.List;

import com.revature.model.Customer;
import com.revature.repository.CustomerDao;

public class CustomerService {
	CustomerDao dao;
	
	public CustomerService(CustomerDao dao) {
		this.dao = dao;
	}

	/*public void deleteCustomer(Customer a) {
		dao.deleteCustomer(a);
	}
	
	public void createCustomer(Customer a) {
		dao.createCustomer(a);
	}*/
	
	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

}
