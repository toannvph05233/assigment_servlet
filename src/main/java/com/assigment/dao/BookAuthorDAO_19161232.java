package com.assigment.dao;

import com.assigment.model.BookAuthor_19161232;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookAuthorDAO_19161232 {
    private Connection connection;

    public BookAuthorDAO_19161232(Connection connection) {
        this.connection = connection;
    }

    public void addBookAuthor(BookAuthor_19161232 bookAuthor) {
        try {
            String sql = "INSERT INTO book_author (author_id, bookid) " +
                    "VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookAuthor.getAuthorId());
            statement.setInt(2, bookAuthor.getBookid());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public List<BookAuthor_19161232> getAuthorsForBook(int bookId) {
        List<BookAuthor_19161232> bookAuthors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book_author WHERE bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                BookAuthor_19161232 bookAuthor = new BookAuthor_19161232();
                bookAuthor.setAuthorId(result.getInt("author_id"));
                bookAuthor.setBookid(result.getInt("bookid"));
                bookAuthors.add(bookAuthor);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return bookAuthors;
    }

    public List<BookAuthor_19161232> getBooksForAuthor(int authorId) {
        List<BookAuthor_19161232> bookAuthors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book_author WHERE author_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, authorId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                BookAuthor_19161232 bookAuthor = new BookAuthor_19161232();
                bookAuthor.setAuthorId(result.getInt("author_id"));
                bookAuthor.setBookid(result.getInt("bookid"));
                bookAuthors.add(bookAuthor);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return bookAuthors;
    }

    public void deleteBookAuthor(int authorId, int bookId) {
        try {
            String sql = "DELETE FROM book_author WHERE author_id = ? AND bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, authorId);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
}

