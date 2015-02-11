package com.ea.library.util;

import com.ea.library.model.db.DBBook;
import com.ea.library.model.rest.RestBook;

public class RestToDBConverter {

	public static DBBook convertBook(RestBook rBook) {

		DBBook dBook = new DBBook();
		dBook.setAuthor(rBook.getAuthor());
		dBook.setBookName(rBook.getBookName());
		dBook.setId(rBook.getId());
		return dBook;

	}

}
