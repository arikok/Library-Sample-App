package com.ea.library.model.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="book")
public class DBBook {

	@Id
	private String id;

	private String bookName;
	private String author;

	public DBBook() {

	}

	public DBBook(String id, String bookName, String author) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		if (id == null) {
			return (author + "-" + bookName);

		} else {
			return (id + "-" + author + "-" + bookName);
		}

	}

}
