package com.lms.view;

import com.lms.model.User;
import com.lms.service.UserService;
import com.lms.service.UserServiceImpl;
import com.lms.util.Input;

public class UserView {

	private UserService userService = new UserServiceImpl();

	public void createuster() {
		System.out.println("ENTER USER ID");
		Input.getScanner().nextLine();
		String userId = Input.getScanner().nextLine();
		System.out.println("ENTER PASSWORD");
		String password = Input.getScanner().nextLine();
		System.out.println("ENTER EMAIL");
		String email = Input.getScanner().nextLine();
		System.out.println("ENTER USER NAME");
		String userName = Input.getScanner().nextLine();
		System.out.println("ENTER TYPE");
		String type = Input.getScanner().nextLine();
		User newUser = new User(type);
		newUser.setEmail(email);
		newUser.setName(userName);
		newUser.setPassword(password);
		newUser.setUserId(userId);

		boolean isSaved = userService.createUser(newUser);
		if (isSaved) {
			System.out.println("USER SAVED");
		} else {
			System.out.println("USER WITH GIVEN USER ID IS PRESENT");
		}

	}

	public void search() {
		System.out.println("ENTER USER ID");
		String userId = Input.getScanner().nextLine();
		User user = userService.getUser(userId);
		if (user == null) {
			System.out.println("USER IS NOT PRESENT");
			return;
		} else {
			System.out.println(user);
		}
	}

	public void delete() {
		System.out.println("ENTER USER ID");
		String userId = Input.getScanner().nextLine();
		boolean isDeleted = userService.deleteUser(userId);

		if (isDeleted) {
			System.out.println("USER IS DELETED");
			return;
		} else {
			System.out.println("USER IS NOT PRESENT");
		}

	}

	public void upDate(String userId) {
		
		User userToBeUpdated = userService.getUser(userId);

		if (userToBeUpdated == null) {
			System.out.println("USER IS NOT PRESENT");
			return;
		}

		System.out.println("1.NAME \n2.EMAIL \n3.PASSWORD");
		int op = Input.getScanner().nextInt();
		switch (op) {

		case 1: {
			System.out.println("ENTER NAME");
			Input.getScanner().nextLine();
			String name = Input.getScanner().nextLine();
			userToBeUpdated.setName(name);
			break;
		}

		case 2: {
			System.out.println("ENTER EMAIL");
			Input.getScanner().nextLine();
			String email = Input.getScanner().nextLine();
			userToBeUpdated.setEmail(email);
			break;
		}
		case 3: {
			System.out.println("ENTER PASSWORD");
			Input.getScanner().nextLine();
			String password = Input.getScanner().nextLine();
			userToBeUpdated.setPassword(password);
			break;
		}

		default: {
			System.out.println("INVALID INPUT");
		}

		}

	}

	public void showAllUsers() {
		System.out.println("==================================================================");
		userService.getAllUsers().stream().filter(user -> user.getType().equalsIgnoreCase("member"))
				.forEach(user -> System.out.println(user));
		System.out.println("==================================================================");

	}

}
