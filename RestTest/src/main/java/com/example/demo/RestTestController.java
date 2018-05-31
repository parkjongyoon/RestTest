package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.repository.RestTestRepository;

@RestController
public class RestTestController {

	@Autowired
	RestTestRepository restTestRepository;
	
	@GetMapping("/book")
	public List<Book> list(){
		return restTestRepository.findAll();
	}
}
