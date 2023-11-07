package com.assigment.dao;

import com.assigment.model.Book_19161232;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO_19161232 {
    private Connection connection;

    public BookDAO_19161232(Connection connection) {
        this.connection = connection;
    }

    public void addBook(Book_19161232 book) {
        try {
            String sql = "INSERT INTO books (isbn, title, publisher, price, description, publish_date, cover_image, quantity) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getPublisher());
            statement.setBigDecimal(4, book.getPrice());
            statement.setString(5, book.getDescription());
            statement.setDate(6, new java.sql.Date(book.getPublishDate().getTime()));
            statement.setString(7, book.getCoverImage());
            statement.setInt(8, book.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public Book_19161232 getBookById(int bookId) {
        Book_19161232 book = null;
        try {
            String sql = "SELECT * FROM books WHERE bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                book = new Book_19161232();
                book.setBookid(result.getInt("bookid"));
                book.setIsbn(result.getInt("isbn"));
                book.setTitle(result.getString("title"));
                book.setPublisher(result.getString("publisher"));
                book.setPrice(result.getBigDecimal("price"));
                book.setDescription(result.getString("description"));
                book.setPublishDate(result.getDate("publish_date"));
                book.setCoverImage(result.getString("cover_image"));
                book.setQuantity(result.getInt("quantity"));
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return book;
    }

    public List<Book_19161232> getAllBooks() {
        List<Book_19161232> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM books";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Book_19161232 book = new Book_19161232();
                book.setBookid(result.getInt("bookid"));
                book.setIsbn(result.getInt("isbn"));
                book.setTitle(result.getString("title"));
                book.setPublisher(result.getString("publisher"));
                book.setPrice(result.getBigDecimal("price"));
                book.setDescription(result.getString("description"));
                book.setPublishDate(result.getDate("publish_date"));
                book.setCoverImage(result.getString("cover_image"));
                book.setQuantity(result.getInt("quantity"));
                books.add(book);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return books;
    }

    public void updateBook(Book_19161232 book) {
        try {
            String sql = "UPDATE books SET isbn = ?, title = ?, publisher = ?, price = ?, description = ?, " +
                    "publish_date = ?, cover_image = ?, quantity = ? WHERE bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getPublisher());
            statement.setBigDecimal(4, book.getPrice());
            statement.setString(5, book.getDescription());
            statement.setDate(6, new java.sql.Date(book.getPublishDate().getTime()));
            statement.setString(7, book.getCoverImage());
            statement.setInt(8, book.getQuantity());
            statement.setInt(9, book.getBookid());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        try {
            String sql = "DELETE FROM books WHERE bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
}
