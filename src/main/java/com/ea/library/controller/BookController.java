package com.ea.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ea.library.model.db.DBBook;
import com.ea.library.model.rest.RestBook;
import com.ea.library.repository.BookRepository;
import com.ea.library.util.CaptchaValidator;
import com.ea.library.util.InputValidator;
import com.ea.library.util.RestToDBConverter;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	private static final Logger logger = Logger.getLogger(BookController.class);

	@RequestMapping(value = "/book")
	@ResponseBody
	public List<DBBook> getBooks(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<DBBook> books = bookRepository.findAll();
			return books;

		} catch (Exception e) {
			response.setStatus(404);
			return null;
		}

	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	@ResponseBody
	public void insertBook(HttpServletRequest request,
			HttpServletResponse response, @RequestBody RestBook rBook) {

		try {

			if (rBook.getId() != null && !rBook.getId().isEmpty()) {

				logger.info("Updating   " + rBook.toString());
				if (InputValidator.validateInput(rBook)) {

					DBBook book = RestToDBConverter.convertBook(rBook);
					bookRepository.save(book);
				} else {
					logger.error("Invalid inputs   " + rBook.toString());
					response.setStatus(404);
				}

			} else {
				logger.info("Inserting   " + rBook.toString());

				if (InputValidator.validateInput(rBook)
						&& CaptchaValidator.validateCaptcha(rBook
								.getgResponse(),request.getRemoteAddr())) {

					DBBook book = RestToDBConverter.convertBook(rBook);
					bookRepository.save(book);
				} else {
					logger.error("Invalid inputs   " + rBook.toString());
					response.setStatus(404);
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus(404);
		}

	}

}
