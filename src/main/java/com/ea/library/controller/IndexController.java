package com.ea.library.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ea.library.repository.BookRepository;

@Controller
public class IndexController {

	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	
	@Autowired
	private BookRepository bookRepository;
		
	@RequestMapping("/")
	public ModelAndView index(){
		
		ModelAndView index= new ModelAndView("index");
		return index;
		
		
	}
	
			
}
