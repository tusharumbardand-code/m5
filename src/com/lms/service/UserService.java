package com.lms.service;

import java.util.List;

import com.lms.model.User;

public interface UserService {
	
	public boolean createUser(User user);
	public User getUser(String userId);
	public User updateUser(String userId);
	public boolean deleteUser(String userId);
	public List<User> getAllUsers();
	
	}


