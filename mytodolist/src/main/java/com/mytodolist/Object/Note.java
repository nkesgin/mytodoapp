package com.mytodolist.Object;

public class Note {
	int id;
	boolean checked;
	String title;
	String text;

	public Note(int id, boolean checked, String title, String text) throws Exception {
		if(!isIdUniq(id)) {
			throw new Exception("id duplication!");
		}
		this.id = id;
		this.checked = checked;
		this.title = title;
		this.text = text;
	}
	
	private boolean isIdUniq(int id2) {
		return true;
	}

	@Override
	public String toString() {
		return "id=" + id + ", checked=" + checked + ", title=" + title + ", text=" + text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
