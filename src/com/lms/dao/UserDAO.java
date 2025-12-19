package com.lms.dao;

import java.util.List;

import com.lms.model.User;

public interface UserDAO {
	
	public boolean saveUser(User user);
	public User getUserById(String id);
	public boolean deleteUser(String id);
	public User updateUser(String id);
	public List<User> getUsers();

}
