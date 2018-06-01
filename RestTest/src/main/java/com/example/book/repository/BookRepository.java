package com.example.book.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.book.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
}
