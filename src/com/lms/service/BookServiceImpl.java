package com.lms.service;

import java.util.List;

import com.lms.dao.BookDAO;
import com.lms.dao.BookDAOImpl;
import com.lms.model.Book;

public class BookServiceImpl implements BookService {
	BookDAO bookDAO = new BookDAOImpl();

	@Override
	public boolean saveBook(Book book) {

		return bookDAO.addBook(book);
	}

	@Override
	public Book searchBookById(int id) {

		return bookDAO.getBookById(id);
	}

	@Override
	public boolean removeBookById(int id) {

		return bookDAO.deleteBookById(id);
	}

	@Override
	public boolean updateBook(int id, Book newBook) {

		return bookDAO.updateBookById(id, newBook);
	}

	@Override
	public List<Book> getlAllBooks() {
		// TODO Auto-generated method stub
		return bookDAO.getAllBooks();
	}

}
