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

	public Book saveBook(Book book) {
		return this.repo.save(book);
	}

	public Book updateBook(Long id, Book updatedBook) {
		return this.repo.findById(id).map(book -> {
			book.setTitle(updatedBook.getTitle());
			book.setAuthor(updatedBook.getAuthor());
			book.setBestSeller(updatedBook.isBestSeller());
			book.setGenres(updatedBook.getGenres());
			return this.repo.save(book);
		}).orElseThrow(() -> new BookNotFoundException("Book not found - " + id));
	}

	public void deleteBook(Long id) {
		this.repo.findById(id).map(book -> book).orElseThrow(() -> new BookNotFoundException("Book not found - " + id));
		this.repo.deleteById(id);
	}

}
