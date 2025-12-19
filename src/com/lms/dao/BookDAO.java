package com.lms.dao;

import java.util.List;

import com.lms.model.Book;

public interface BookDAO {

	public boolean addBook(Book book);

	public Book getBookById(int id);

	public boolean deleteBookById(int id);

	public boolean updateBookById(int id, Book book);

	public List<Book> getAllBooks();

}
