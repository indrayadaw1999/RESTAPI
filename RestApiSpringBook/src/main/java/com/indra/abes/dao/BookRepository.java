package com.indra.abes.dao;

import org.springframework.data.repository.CrudRepository;

import com.indra.abes.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
	
	public BookRepository findById(int id);

}
