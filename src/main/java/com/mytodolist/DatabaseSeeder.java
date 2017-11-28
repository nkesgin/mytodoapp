package com.mytodolist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mytodolist.Model.Note;
import com.mytodolist.Model.Customer;
import com.mytodolist.Repository.NoteRepository;
import com.mytodolist.Repository.CustomerRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner{

	private CustomerRepository customerRepository;
	private NoteRepository noteRepository;
	
	@Autowired
	public DatabaseSeeder(CustomerRepository customerRepository, NoteRepository noteRepository) {
		this.customerRepository = customerRepository;
		this.noteRepository = noteRepository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
//		List<Customer> customers = new ArrayList<>();
//		List<Note> notes = new ArrayList<>();
//		customers.add(new Customer("nurhan", "kesgin"));
//		customerRepository.save(customers);
//		Iterator<Customer> hede = customerRepository.findAll().iterator();
//		while(hede.hasNext()) {
//			Customer u = hede.next();
//			notes.add(new Note("nurhan", "text",u.getId()));
//		}
//		noteRepository.save(notes);
	}

}
