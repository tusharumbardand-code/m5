package com.lms.model;

import java.util.ArrayList;
import java.util.Objects;

public class User {

	private String userId;
	private String password;
	private String name;
	private String email;
	ArrayList<Book> books = new ArrayList<>();
	private String type;

	public User(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(books, email, name, password, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(books, other.books) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(userId, other.userId);
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", books=" + books + ", type=" + type
				+ "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

}
