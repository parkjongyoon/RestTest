package com.example.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.book.domain.Book;

public interface BookService {

	List<Book> findAll();
	
	Optional<Book> findById(Long id);
	
	Book save(Book book);
	
	Book update(Long id, Book book);
	
	void delete(Long id);
}
