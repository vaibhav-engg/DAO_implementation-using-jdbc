package com.entity;

//import src.com.entity.String;

public class Book {
	private int book_id;
	private String book_name;
	private String isbn_no;
	private double price;

	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getIsbn_no() {
		return isbn_no;
	}
	public void setIsbn_no(String isbn_no) {
		this.isbn_no = isbn_no;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
