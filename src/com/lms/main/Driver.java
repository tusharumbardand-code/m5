package com.lms.main;

import com.lms.model.Book;
import com.lms.model.User;
import com.lms.service.BookService;
import com.lms.service.BookServiceImpl;
import com.lms.service.UserService;
import com.lms.service.UserServiceImpl;
import com.lms.util.Input;
import com.lms.view.BookView;
import com.lms.view.UserView;

public class Driver {

	private static UserView userView = new UserView();
	private static UserService userService = new UserServiceImpl();
	private static BookView bookView = new BookView();
	private static BookService bookService = new BookServiceImpl();

	public static void main(String[] args) {
		do {
			System.out.println("1.SIGN IN \n2.SIGN UP\n3.EXIT");
			int op = Input.getScanner().nextInt();
			if (op == 1) {
				authUser();
			} else if (op == 2) {
				userView.createuster();
			} else if (op == 3) {
				return;
			} else {
				System.out.println("INVLID INPUT");
			}

		} while (true);
	}

	private static void authUser() {

		System.out.println("ENTER USER ID");
		Input.getScanner().nextLine();
		String userID = Input.getScanner().nextLine();
		System.out.println("ENTER PASSWORD");
		String password = Input.getScanner().nextLine();

		User user = userService.getUser(userID);
		
		if (user == null) {
			System.out.println("USER IS NOT PRESENT");
			return;
		} else {

			if (password.equals(user.getPassword())) {
				if (user.getType().equalsIgnoreCase("MEMBER")) {

					memberView(user);
				} else {

					librarianView(user);
				}
			} else {
				System.out.println("WORNG PASSWORD");
				return;
			}
		}

	}

	private static void memberView(User user) {
		do {

			System.out.println(
					"1.ALL BOOKS \n2.BORROW BOOK \n3.RETURN BOOK \n4.SORT BOOK BASED ON RATING \n5.INFO \n6.UPDATE INFO \n7.MY BOOKS\n8.EXIT");
			int op = Input.getScanner().nextInt();
			switch (op) {
			case 1: {
				bookView.showAllBooks();
				break;
			}
			case 2: {

				Book book = bookView.getBook();
				if (book == null) {
					break;
				} else {
					bookService.removeBookById(book.getId());
					user.getBooks().add(book);
					System.out.println("DONE");
				}
				break;
			}
			case 3: {

				System.out.println("ENTER BOOK ID");
				int id = Input.getScanner().nextInt();
				Book book = user.getBooks().stream().filter(b -> b.getId() == id).findFirst().orElse(null);
				if (book == null) {
					System.out.println("BOOK IS NOT PRESENT");
					break;
				}
				user.getBooks().remove(book);
				bookService.saveBook(book);
				System.out.println("DONE");

			}
			case 4: {
				System.out.println("===================");
				bookService.getlAllBooks().stream().sorted((b1, b2) -> Double.compare(b2.getRating(), b1.getRating()))
						.forEach(b -> System.out.println(b));
				System.out.println("===================");
				break;
			}
			case 5: {
				System.out.println(user);
				break;
			}
			case 6: {
				System.out.println("ENTER USER ID");
				Input.getScanner().nextLine();
				String userId = Input.getScanner().nextLine();
				userView.upDate(userId);
				break;
			}
			case 7: {
				user.getBooks().forEach(book -> System.out.println(book));
				break;
			}
			case 8: {
				System.out.println("EXIT");
				return;
			}
			default: {
				System.out.println("INVALID INPUT");
			}

			}

		} while (true);
	}

	private static void librarianView(User user) {

		do {

			System.out.println(
					"1.ALL BOOKS \n2.ALL USERS \n3.ADD BOOK \n4.REMOVE BOOK \n5.SEARCH BOOK \n6.SEARCH USER \n7.EXIT");

			int op = Input.getScanner().nextInt();
			switch (op) {

			case 1: {
				bookView.showAllBooks();
				break;
			}
			case 2: {
				userView.showAllUsers();
				break;
			}
			case 3: {
				bookView.creatNewBook();
				break;
			}
			case 4: {
				bookView.delete();
				break;
			}
			case 5: {
				bookView.getBook();
				break;
			}
			case 6: {
				userView.search();
				break;
			}
			case 7: {
				return;
			}
			default: {
				System.out.println("INVALID INPUT");
			}

			}

		} while (true);

	}

}
