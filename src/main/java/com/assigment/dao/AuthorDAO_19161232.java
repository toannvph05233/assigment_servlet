package com.assigment.dao;

import com.assigment.model.Author_19161232;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO_19161232 {
    private Connection connection;

    public AuthorDAO_19161232(Connection connection) {
        this.connection = connection;
    }

    public void addAuthor(Author_19161232 author19161232) {
        try {
            String sql = "INSERT INTO author (author_name, date_of_birth) " +
                    "VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author19161232.getAuthorName());
            statement.setDate(2, new java.sql.Date(author19161232.getDateOfBirth().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public Author_19161232 getAuthorById(int authorId) {
        Author_19161232 author19161232 = null;
        try {
            String sql = "SELECT * FROM author WHERE author_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, authorId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                author19161232 = new Author_19161232();
                author19161232.setAuthorId(result.getInt("author_id"));
                author19161232.setAuthorName(result.getString("author_name"));
                author19161232.setDateOfBirth(result.getDate("date_of_birth"));
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return author19161232;
    }

    public List<Author_19161232> getAllAuthors() {
        List<Author_19161232> author19161232s = new ArrayList<>();
        try {
            String sql = "SELECT * FROM author";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Author_19161232 author19161232 = new Author_19161232();
                author19161232.setAuthorId(result.getInt("author_id"));
                author19161232.setAuthorName(result.getString("author_name"));
                author19161232.setDateOfBirth(result.getDate("date_of_birth"));
                author19161232s.add(author19161232);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return author19161232s;
    }

    public void updateAuthor(Author_19161232 author19161232) {
        try {
            String sql = "UPDATE author SET author_name = ?, date_of_birth = ? WHERE author_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author19161232.getAuthorName());
            statement.setDate(2, new java.sql.Date(author19161232.getDateOfBirth().getTime()));
            statement.setInt(3, author19161232.getAuthorId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int authorId) {
        try {
            String sql = "DELETE FROM author WHERE author_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, authorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
}

