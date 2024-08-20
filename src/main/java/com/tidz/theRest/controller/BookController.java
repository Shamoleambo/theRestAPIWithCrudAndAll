package com.tidz.theRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tidz.theRest.model.Book;
import com.tidz.theRest.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("")
	public List<Book> getAllBooks() {
		return this.service.getAllBooks();
	}

}
