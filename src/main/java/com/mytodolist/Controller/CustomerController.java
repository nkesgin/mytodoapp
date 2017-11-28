package com.mytodolist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytodolist.Model.Customer;
import com.mytodolist.Repository.CustomerRepository;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@RequestMapping(value ="/allCustomers", method = RequestMethod.GET)
	public Iterable<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public Iterable<Customer> getCustomerById(@PathVariable long id){
		return customerRepository.findById(id);
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.POST)
	public String login(@RequestBody Customer customer) {
		try {
			customerRepository.save(customer);
		}catch(Exception e) {
			return "Customer cannot be created";
		}
		return "Customer successfully created.";
	}
	
}
