package com.lms.view;

import com.lms.model.Book;
import com.lms.service.BookService;
import com.lms.service.BookServiceImpl;
import com.lms.util.Input;

public class BookView {

	private BookService bookService = new BookServiceImpl();

	public void bookMenu() {
   
	}
	
	
	public void creatNewBook() {
		// Book title, Author, ID, Rating
		System.out.println("ENTER BOOK ID");
		int id = Input.getScanner().nextInt();
		System.out.println("ENTER BOOK TITLE");
		String title = Input.getScanner().nextLine();
		System.out.println("ENTER AUTHOR NAME");
		String author = Input.getScanner().nextLine();
		System.out.println("ENTER RATING");
		double rating = Input.getScanner().nextDouble();

		Book newBook = new Book();
		newBook.setId(id);
		newBook.setAuthor(author);
		newBook.setTitle(title);
		newBook.setRating(rating);

		boolean isSaved = bookService.saveBook(newBook);
		if (isSaved) {
			System.out.println("BOOK IS ADDED");
		} else {
			System.out.println("BOOK IS PRESENT WITH GITVEN ID " + id);
		}

	}

	public void delete() {
		System.out.println("ENTER BOOK ID");
		int id = Input.getScanner().nextInt();
		boolean isDeleted = bookService.removeBookById(id);
		if (isDeleted) {
			System.out.println("BOOK IS DELETED");
		} else {
			System.out.println("BOOK IS NOT PRESETN WITH GIVEN ID " + id);
		}
	}

	public Book getBook() {
		System.out.println("ENTER BOOK ID");
		int id = Input.getScanner().nextInt();
		Book book = bookService.searchBookById(id);
		if (book == null) {
			System.out.println("BOOK IS NOT PRESENT WITH GIVEN ID " + id);
			return null;
		}
		System.out.println(book);
		return book;
	}

	public void updateBook() {
		System.out.println("ENTER BOOK ID");
		int id = Input.getScanner().nextInt();
		Book oldBook = bookService.searchBookById(id);
		if (oldBook == null) {
			System.out.println("BOOK IS NOT PRESENT WITH GIVEN Id");
			return;
		}
		System.out.println("1.BOOK NAME \n2.AUTHOR NAME \n3.RATING");
		
		int op = Input.getScanner().nextInt();
		switch (op) {
		case 1: {
			System.out.println("ENTER NAME");
			Input.getScanner().nextLine();
			String name = Input.getScanner().nextLine();
			oldBook.setTitle(name);
			break;
		}
		case 2: {
			System.out.println("ENTER AUTHOR NAME");
			String name = Input.getScanner().nextLine();
			oldBook.setAuthor(name);
			break;
		}
		case 3: {
			System.out.println("ENTER RATING ");
			double rating = Input.getScanner().nextDouble();
			oldBook.setRating(rating);
			break;
		}
		default: {
			System.out.println("INVALID INPUT");
		}
		}
		
		bookService.updateBook(id, oldBook);
		
		System.out.println("BOOK INFO UPDATED");

	}

	public void showAllBooks() {
		bookService.getlAllBooks().forEach(book -> System.out.println(book));
	}

}
