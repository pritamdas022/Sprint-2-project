package com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
