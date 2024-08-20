package com.tidz.theRest.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title", nullable = false, length = 90)
	private String title;
	@Column(name = "author", nullable = false, length = 60)
	private String author;
	@Column(name = "best_seller", nullable = false)
	private boolean bestSeller;
	@Enumerated(EnumType.STRING)
	@Column(name = "genres")
	private List<BookGenres> genres;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(boolean bestSeller) {
		this.bestSeller = bestSeller;
	}

	public List<BookGenres> getGenres() {
		return genres;
	}

	public void setGenres(List<BookGenres> genres) {
		this.genres = genres;
	}

}
