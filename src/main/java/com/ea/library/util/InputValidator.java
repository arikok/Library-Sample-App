package com.ea.library.util;

import com.ea.library.model.rest.RestBook;

public class InputValidator {

	public static boolean validateInput(RestBook book) throws Exception {

		boolean isValid = false;

		if (book.getAuthor() != null && !book.getAuthor().isEmpty()) {

			if (book.getBookName() != null && !book.getBookName().isEmpty()) {

				isValid = true;

			}

		}

		return isValid;

	}

}
