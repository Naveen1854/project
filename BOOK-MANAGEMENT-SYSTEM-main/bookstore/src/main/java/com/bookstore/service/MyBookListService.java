package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookListService {

    private final MyBookRepository myBookRepository;

    public MyBookListService(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    public MyBookList saveMyBooks(MyBookList myBookList) {
        return myBookRepository.save(myBookList);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBookRepository.findAll();
    }

    public Optional<MyBookList> findBookById(int bookId) {
        return myBookRepository.findById(bookId);
    }

    public void deleteById(int id) {
        if (myBookRepository.existsById(id)) {
            myBookRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Book with ID " + id + " not found.");
        }
    }
}
