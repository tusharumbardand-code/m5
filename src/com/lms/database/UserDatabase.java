package com.lms.database;

import java.util.ArrayList;

import com.lms.model.User;

public class UserDatabase {

	public static ArrayList<User> users = new ArrayList<>();
	static {
		User u1 = new User("Librarian");
		u1.setName("Sam");
		u1.setUserId("sam@123");
		u1.setPassword("456");
		u1.setEmail("sam1@gami.com");
		users.add(u1);

		User u2 = new User("Member");
		u2.setName("Raju");
		u2.setUserId("raju@123");
		u2.setPassword("123");
		u2.setEmail("raju1@gami.com");
		users.add(u2);
		
		User u3 = new User("Member");
		u3.setName("Sham");
		u3.setUserId("sham@123");
		u3.setPassword("321");
		u3.setEmail("sham1@gami.com");
		users.add(u3);

	}

}
