package com.lms.dao;

import java.util.List;

import com.lms.database.UserDatabase;
import com.lms.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean saveUser(User user) {
		User isPresent = getUserById(user.getUserId());
		
		if (isPresent != null) {

			return false;
		}
		UserDatabase.users.add(user);
		
	
		return true;
	}

	@Override
	public User getUserById(String id) {
		return UserDatabase.users.stream().filter(user -> user.getUserId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public boolean deleteUser(String id) {

		User userToBeDeleted = getUserById(id);
		if (userToBeDeleted == null) {
			return false;
		}

		UserDatabase.users.remove(userToBeDeleted);
		return true;

	}

	@Override
	public User updateUser(String id) {
		return UserDatabase.users.stream()
				.filter(user -> user.getUserId().equals(id))
				.findFirst().orElse(null);
	}

	@Override
	public List<User> getUsers() {
		return UserDatabase.users.stream().toList();
	}

}
