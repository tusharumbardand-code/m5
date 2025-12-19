package com.lms.model;

import java.util.Objects;


public class Book {
	// Book title, Author, ID, Rating

	private String title;
	private String author;
	private int id;
	private double rating;

	public Book() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, rating, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id
				&& Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", id=" + id + ", rating=" + rating + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
