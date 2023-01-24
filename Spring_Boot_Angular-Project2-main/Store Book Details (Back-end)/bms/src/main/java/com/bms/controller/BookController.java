package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.dto.BookDTO;
import com.bms.entity.Book;
import com.bms.service.BookService;
import com.bms.util.Converter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private Converter converter;
	
	@Autowired
	private BookService bookService;

	@PostMapping("/createBook")
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO)
	{
		final Book book = converter.convertToBookEntity(bookDTO);
		return new ResponseEntity<BookDTO>(bookService.createBook(book),
				HttpStatus.CREATED);
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable("id") int id,
			@RequestBody BookDTO bookDTO)
	{
		final Book book = converter.convertToBookEntity(bookDTO);
		return new ResponseEntity<BookDTO>(bookService.updateBook(id, book),
				HttpStatus.OK);
	} 
	
	
	@GetMapping("/getAllBook")
	public List<BookDTO> getAllBook()
	{
		return bookService.getAllBook();
	}
	
	@DeleteMapping("/deleteBookById/{id}")
	
	public String deleteBookById(@PathVariable int id) {
		return bookService.deleteBookById(id);
	}
}

