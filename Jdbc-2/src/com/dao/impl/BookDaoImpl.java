package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.BookDao;
import com.dbutil.Dbconnection;
import com.entity.Book;

public class BookDaoImpl implements BookDao {
	final static String SQL_INSERT = "Insert into Book(book_id,book_name,isbn_no,price) values(?,?,?,?)";
	final static String SQL_UPDATE = "update Book SET book_name = ?,isbn_no =?,price = ? where book_id = ?";
	final static String SQL_DELETE = "delete from Book where book_id = ? ";

	Dbconnection conc = new Dbconnection();

	@Override
	public void add(Book book) throws ClassNotFoundException,SQLException {
		Connection connection = conc.getConnection("jdbc:postgresql://localhost:5432/lmsdb","postgres","12345");
		PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
		pstmt.setInt(1,book.getBook_id());
		pstmt.setString(2,book.getBook_name());
		pstmt.setString(3,book.getIsbn_no());
		pstmt.setDouble(4,book.getPrice());
		pstmt.execute();
		pstmt.close();
		connection.close();
		
	}

	@Override
	public void update(Book book) throws ClassNotFoundException,SQLException {
		Connection connection = conc.getConnection("jdbc:postgresql://localhost:5432/lmsdb","postgres","12345");
		PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
		pstmt.setInt(1, book.getBook_id());
		pstmt.setString(2, book.getBook_name());
		pstmt.setString(3,book.getIsbn_no());
		pstmt.setDouble(4,book.getPrice());
		pstmt.execute();
		pstmt.close();
		connection.close();
		
		
	}

	@Override
	public void delete(int book_id) throws ClassNotFoundException,SQLException{
		Connection connection = conc.getConnection("jdbc:postgresql://localhost:5432/lmsdb","postgres","12345");
		PreparedStatement pstmt = connection.prepareStatement(SQL_DELETE);
		pstmt.setInt(1, book_id);
		pstmt.execute();
		pstmt.close();
		connection.close();
	}

	@Override
	public Book getBook(int book_no) throws SQLException {
		Connection connection = conc.getConnection("jdbc:postgresql://localhost:5432/lmsdb","postgres","12345");
		String selectString = "select * from Book where book_id = ?";
		Book b = new Book();
		PreparedStatement pstmt = connection.prepareStatement(selectString);
		pstmt.setInt(1,book_no);
		ResultSet rs = pstmt.executeQuery(selectString);
		while(rs.next()) {
			b.setBook_id(rs.getInt("book_id"));
			b.setBook_name(rs.getString("book_name"));
			b.setIsbn_no(rs.getString("isbn_no"));
			b.setPrice(rs.getDouble("price"));
		}
		
		return b;
	}
	@Override
	public ArrayList<Book> getBookList() throws SQLException {
		ArrayList<Book> book = new ArrayList<Book>();
		Connection connection = conc.getConnection("jdbc:postgresql://localhost:5432/lmsdb","postgres","12345");
		PreparedStatement pstmt = connection.prepareStatement("select * from Book");
		ResultSet res = pstmt.executeQuery();
		while(res.next()) {
			Book b = new Book();
			b.setBook_id(res.getInt("book_id"));
			b.setBook_name(res.getString("book_name"));
			b.setIsbn_no(res.getString("isbn_no"));
			b.setPrice(res.getDouble("price"));
			book.add(b);
			
		}
		pstmt.close();
		connection.close();
		
		
		return book;
	}


}
