package com.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void save(Book book) {
		bookRepository.save(book);
	}

	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Book with ID " + id + " not found."));
	}

	public void deleteById(int id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
		} else {
			throw new IllegalArgumentException("Book with ID " + id + " not found.");
		}
	}
}
