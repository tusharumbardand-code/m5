package com.lms.service;

import java.util.List;

import com.lms.dao.UserDAO;
import com.lms.dao.UserDAOImpl;
import com.lms.model.User;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		
		return userDAO.saveUser(user);
	}

	@Override
	public User getUser(String userId) {
		
		return userDAO.getUsers().stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
	}

	@Override
	public User updateUser(String userId) {
		// TODO Auto-generated method stub
		return userDAO.updateUser(userId);
	}

	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userDAO.deleteUser(userId);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.getUsers();
	}
	
	
	

}
