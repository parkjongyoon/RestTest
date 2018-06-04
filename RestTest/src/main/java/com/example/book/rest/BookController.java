package com.example.book.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.domain.Book;
import com.example.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> findAll(){
		return bookService.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book findById(@PathVariable("id") Long id) {
		Book book = bookService.findById(id).get();
		return book;
	}
	
	@PostMapping("/books")
	public Book save(@RequestBody Book book) {
		Book savedBook = bookService.save(book);
		return savedBook;
	}
	
	@PutMapping("/books/{id}")
	public Book update(@RequestBody Book book, @PathVariable("id") Long id) {
		Book updatedBook = null;
		
		Optional<Book> optionalBook = bookService.findById(id);
		if(optionalBook.isPresent()) {
			Book currentBook = optionalBook.get();
			currentBook.setName(book.getName());
			currentBook.setPrice(book.getPrice());
			updatedBook = bookService.update(id, currentBook);
		}

		return updatedBook;
	}
	
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.delete(id);
	}
}
