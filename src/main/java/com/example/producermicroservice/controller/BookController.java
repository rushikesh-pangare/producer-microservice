package com.example.producermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.producermicroservice.entities.Book;
import com.example.producermicroservice.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/bookservice/getbookcost/{bookname}")
	public Book getBookCost(@PathVariable String bookname) {
		
		String port = env.getProperty("local.server.port");

		
		Book book = bookRepository.getByBookName(bookname); 
		book.setEnvironment(port);
		
		return book;
	}
}
