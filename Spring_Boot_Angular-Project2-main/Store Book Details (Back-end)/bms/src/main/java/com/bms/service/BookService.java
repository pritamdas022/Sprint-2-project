package com.bms.service;

import java.util.List;

import com.bms.dto.BookDTO;
import com.bms.entity.Book;

public interface BookService {

	BookDTO createBook(Book book);
	BookDTO updateBook(int id,Book book);
	List<BookDTO> getAllBook();
	String deleteBookById(int id);
}
