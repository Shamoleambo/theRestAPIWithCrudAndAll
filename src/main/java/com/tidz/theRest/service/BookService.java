package com.tidz.theRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidz.theRest.errors.BookNotFoundException;
import com.tidz.theRest.model.Book;
import com.tidz.theRest.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	public List<Book> getAllBooks() {
		return this.repo.findAll();
	}

	public Book getBookById(Long id) {
		return this.repo.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found - " + id));
	}

}
