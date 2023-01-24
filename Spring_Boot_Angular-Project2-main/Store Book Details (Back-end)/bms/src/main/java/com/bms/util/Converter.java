package com.bms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bms.dto.BookDTO;
import com.bms.entity.Book;


@Component
public class Converter {

	// convert from EmployeeDTO to Entity(employee)
			public Book convertToBookEntity(BookDTO bookDTO)
			{
				Book book = new Book();
				if(bookDTO!=null)
				{
					BeanUtils.copyProperties(bookDTO, book);
				}
				return book;
			}
			
			//convert from book entity to BookDTO
			public BookDTO convertToBookDTO(Book book)
			{
				BookDTO bookDTO = new BookDTO();
				if(book!=null)
				{
					BeanUtils.copyProperties(book, bookDTO);
				}
				return bookDTO;
			}
}
