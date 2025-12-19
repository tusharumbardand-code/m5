package com.lms.database;

import java.util.ArrayList;

import com.lms.model.Book;

public class BookDatabase {

	public static ArrayList<Book> books = new ArrayList<>();

	static {

		Book b1 = new Book();
		b1.setTitle("C++");
		b1.setId(105);
		b1.setAuthor("SAM");
		b1.setRating(4.6);
		books.add(b1);

		Book b2 = new Book();
		b2.setTitle("JAVA");
		b2.setId(108);
		b2.setAuthor("RAJU");
		b2.setRating(4.5);
		books.add(b2);

		Book b3 = new Book();
		b3.setTitle("PYTHON");
		b3.setId(101);
		b3.setAuthor("SHAM");
		b3.setRating(4.3);
		books.add(b3);

	}

}
