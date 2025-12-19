package com.lms.dao;

import java.util.List;

import com.lms.database.BookDatabase;
import com.lms.model.Book;

public class BookDAOImpl implements BookDAO {

	@Override
	public boolean addBook(Book book) {
		Book b = getBookById(book.getId());
		if (b != null) {
			return false;
		}

		BookDatabase.books.add(book);
		return true;

	}

	@Override
	public Book getBookById(int id) {

//		for(Book b : BookDatabase.books) {
//			if(b.getId()==id) {
//				return b;
//			}
//		}
//		return null;
		return BookDatabase.books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
	}

	@Override
	public boolean deleteBookById(int id) {
		Book bookToBeDeleted = getBookById(id);
		if (bookToBeDeleted == null) {
			return false;
		}

		BookDatabase.books.remove(bookToBeDeleted);
		return true;

	}

	@Override
	public boolean updateBookById(int id, Book newBook) {
		Book oldBook = getBookById(id);
		if (oldBook == null) {
			return false;
		}
		BookDatabase.books.remove(oldBook);
		BookDatabase.books.add(newBook);
		return true;

	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return BookDatabase.books.stream().toList();
	}

}
