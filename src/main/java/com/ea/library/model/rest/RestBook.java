package com.ea.library.model.rest;

public class RestBook {

	
	private String id;

	private String bookName;
	private String author;
	
	private String gResponse;

	
	public RestBook(){
		
	}
	
	
	
	public RestBook(String id, String bookName, String author, String gResponse) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.gResponse = gResponse;
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

	public String getgResponse() {
		return gResponse;
	}

	public void setgResponse(String gResponse) {
		this.gResponse = gResponse;
	}

	@Override
	public String toString() {
		if (id == null) {
			return (author + "-" + bookName  + "-"+gResponse);

		} else {
			return (id + "-" + author + "-" + bookName);
		}

	}
	

}
