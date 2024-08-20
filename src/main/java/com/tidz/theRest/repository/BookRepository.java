package com.tidz.theRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidz.theRest.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
