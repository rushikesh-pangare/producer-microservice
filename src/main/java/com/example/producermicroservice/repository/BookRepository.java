package com.example.producermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.producermicroservice.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book getByBookName(String bookname);

}
