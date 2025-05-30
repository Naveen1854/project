package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {

//	@Autowired
//	private BookRepository bRepo;

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void save(Book b) {
		bookRepository.save(b);
	}

	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
}