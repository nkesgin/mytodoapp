package com.mytodolist.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "checked")
	private boolean checked;
	@Column(name = "title")
	private String title;
	@Column(name = "text")
	private String text;
	@Column(name = "userId")
	private long userId;

	public Note() {
		
	}
	
	public Note(String title, String text, long userId){
		this.title = title;
		this.text = text;
		this.userId = userId;
		checked = false;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", checked=" + checked + ", title=" + title + ", text=" + text;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
