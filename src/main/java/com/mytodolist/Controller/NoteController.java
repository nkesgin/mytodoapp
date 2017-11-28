package com.mytodolist.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytodolist.Model.Note;
import com.mytodolist.Repository.NoteRepository;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {
	private NoteRepository noteRepository;
	
	public NoteController(NoteRepository noteRepository) throws Exception{
		this.noteRepository = noteRepository;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Iterable<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Note> getNoteById(@PathVariable long id) {
		return noteRepository.findById(id);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteNoteById(@PathVariable long id) {
		try {
			noteRepository.delete(id);
		}catch(Exception e) {
			return "Cannot deleted.";
		}
		return "Successfully deleted.";
	}
}
