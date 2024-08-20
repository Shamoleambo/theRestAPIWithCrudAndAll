package com.tidz.theRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		return this.service.getBookById(id);
	}

	@PostMapping("")
	public Book saveBook(@RequestBody Book book) {
		return this.service.saveBook(book);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		return this.service.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		this.service.deleteBook(id);
	}

}
