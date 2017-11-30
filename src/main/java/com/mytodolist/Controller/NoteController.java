package com.mytodolist.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytodolist.Model.Note;
import com.mytodolist.Repository.NoteRepository;

@RestController
@RequestMapping(value = "/note")
public class NoteController {
	private NoteRepository noteRepository;
	
	public NoteController(NoteRepository noteRepository) throws Exception{
		this.noteRepository = noteRepository;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Iterable<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	
	@RequestMapping(value = "/id={id}", method = RequestMethod.GET)
	public List<Note> getNoteById(@PathVariable long id) {
		return noteRepository.findById(id);
	}
	
	@RequestMapping(value = "/userId={userId}", method = RequestMethod.GET)
	public List<Note> getNoteByUserId(@PathVariable long userId){
		return noteRepository.findByUserId(userId);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ResponseEntity updateNoteById(@PathVariable long id) {
		try {
			Note n = noteRepository.findOne(id);
			n.setChecked(!n.isChecked());
			noteRepository.save(n);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity deleteNoteById(@PathVariable long id) {
		try {
			noteRepository.delete(id);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity createNoteById(@RequestBody Note note) {
		try {
			System.out.println(note.getUserId());
			noteRepository.save(note);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
