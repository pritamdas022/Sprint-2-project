package com.bms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dto.BookDTO;
import com.bms.entity.Book;
import com.bms.repository.BookRepository;
import com.bms.service.BookService;
import com.bms.util.Converter;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private Converter converter;

	@Override
	public BookDTO createBook(Book book) {
		bookRepository.save(book);
		return converter.convertToBookDTO(book);
	}

	@Override
	public BookDTO updateBook(int id,Book book){
		Book bmpPresent =bookRepository.findById(id).get();
		
		bmpPresent.setBookName(book.getBookName());
		bmpPresent.setAuthorName(book.getAuthorName());
		bmpPresent.setBookPrice(book.getBookPrice());
		
		bookRepository.save(bmpPresent);
		return converter.convertToBookDTO(bmpPresent);
	}

	@Override
	public List<BookDTO> getAllBook() {
		List<Book> book=bookRepository.findAll();
		
		List<BookDTO> eDTO = new ArrayList<>();
		for(Book e: book)
		{
			eDTO.add(converter.convertToBookDTO(e));
		}
		return eDTO;
	}

	@Override
	public String deleteBookById(int id) {
		
		String message=null;
		Optional<Book> bmp =bookRepository.findById(id);
		if(bmp.isPresent())
		{
			bookRepository.deleteById(id);
			message="record delect successfully";
		}
		return message;
	}
	
	
}
