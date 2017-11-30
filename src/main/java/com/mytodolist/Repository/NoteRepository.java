package com.mytodolist.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytodolist.Model.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
	List<Note> findById(long id);
	List<Note> findByUserId(long user_id);
}
