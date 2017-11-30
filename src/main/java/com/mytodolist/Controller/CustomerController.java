package com.mytodolist.Controller;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
	private String userId;
	
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
	
	@RequestMapping(value ="/getId", method = RequestMethod.GET)
	public String getCustomerId(Model model) {
		return userId;
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ResponseEntity signIn(@RequestBody Customer customer, Model model){
		try {
			Iterator<Customer> i = customerRepository.findAll().iterator();
			while(i.hasNext()) {
				Customer c = i.next();
				if (c.getUsername().equals(customer.getUsername())) {
					if(c.getPassword().equals(customer.getPassword())) {
						model.addAttribute("userId", c.getId());
						userId = c.getId()+"";
						return new ResponseEntity(HttpStatus.OK);
					}else {
						return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
					}
				}
			}
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.POST)
	public ResponseEntity signUp(@RequestBody Customer customer, Model model) {
		try {
			Customer c = customerRepository.save(customer);
			model.addAttribute("userId", c.getId());
			userId = c.getId()+"";
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
