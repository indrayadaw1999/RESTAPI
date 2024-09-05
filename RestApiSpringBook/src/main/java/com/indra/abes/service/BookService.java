package com.indra.abes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.indra.abes.dao.BookRepository;
import com.indra.abes.entities.Book;

@Component
public class BookService {
	
	//jpa service
	@Autowired
	private BookRepository bookRepository;
	
	//get all the books
	
	public List<Book> getAllBooks(){
		
		List<Book>list =(List<Book>)this.bookRepository.findAll();
		return list;
	}

//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(101,"java complete reference ","indra kumar"));
//		list.add(new Book(102,"JavaScript Object Notation ","Daraksha"));
//		list.add(new Book(103,"HTML Tutorial ","Mohit"));
//		list.add(new Book(104,"Python Django ","anshika"));
//		list.add(new Book(105,"CSS complete  ","vikash"));
//		list.add(new Book(106,"MERN Stack","pankaj"));
//	}
	
	//get all books
	
//	public List<Book> getAllBooks(){
//		List<Book> list = (List<Book>)this.bookRepository.findAll();
//		return list;
//	}
//	
	//get one book
	
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = (Book) this.bookRepository.findById(id);
			 // book=list.stream().filter(e->e.getId()==id).findFirst().get();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	
	
	return book;
	}
	
	//add book 

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		Book result = (Book) bookRepository.save(book);
		//list.add(book);
		return book;
	}
	
	//delete the book

	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		
//	       list=list.stream().filter(book->{
//			if(book.getId()!=bookId) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}).collect(Collectors.toList())x
		
		
		
		
		  //or we can use
		
		//list = list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
		
		bookRepository.deleteById(bookId);
		
	}

	

	public void updateBook(Book book, int bookId) {
		// TODO Auto-generated method stub
		
//		list = list.stream().map(b->{ 
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		
		bookRepository.save(book);
		
		
	}
	
	
	
}
