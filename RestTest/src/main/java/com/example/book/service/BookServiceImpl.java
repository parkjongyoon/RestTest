package com.example.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.domain.Book;
import com.example.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> findAll() {
		List<Book> list = new ArrayList();
		bookRepository.findAll().forEach(e->list.add(e));
		return list;
	}

	@Override
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book update(Long id, Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}

}
