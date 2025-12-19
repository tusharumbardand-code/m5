package com.lms.service;

import java.util.List;

import com.lms.model.Book;

public interface BookService {

	public boolean saveBook(Book book);

	public Book searchBookById(int id);

	public boolean removeBookById(int id);

	public boolean updateBook(int id, Book newBook);
	
	
	public List<Book> getlAllBooks();

}
