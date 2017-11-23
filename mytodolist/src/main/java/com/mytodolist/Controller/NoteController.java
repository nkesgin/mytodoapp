package com.mytodolist.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytodolist.Object.Note;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {
	private ArrayList<Note> notes;
	
	public NoteController() throws Exception{
		notes = new ArrayList<>();
		
		notes.add(new Note(1, false, "alisveris", "su, sut"));
		notes.add(new Note(2, false, "alisveris", "su, sut"));
		notes.add(new Note(3, false, "alisveris", "su, sut"));
		notes.add(new Note(4, false, "alisveris", "su, sut"));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ArrayList<Note> getAllNotes(){
		return notes;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Note> getNoteById(@PathVariable int id) {
		return notes.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
		
	}
}
