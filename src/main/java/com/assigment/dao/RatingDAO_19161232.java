package com.assigment.dao;

import com.assigment.model.Rating_19161232;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO_19161232 {
    private Connection connection;

    public RatingDAO_19161232(Connection connection) {
        this.connection = connection;
    }

    public void addRating(Rating_19161232 rating) {
        try {
            String sql = "INSERT INTO rating (userid, bookid, rating, review_text) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, rating.getUserId());
            statement.setInt(2, rating.getBookId());
            statement.setInt(3, rating.getRating());
            statement.setString(4, rating.getReviewText());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public List<Rating_19161232> getRatingsForBook(int bookId) {
        List<Rating_19161232> ratings = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rating WHERE bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Rating_19161232 rating = new Rating_19161232();
                rating.setUserId(result.getInt("userid"));
                rating.setBookId(result.getInt("bookid"));
                rating.setRating(result.getInt("rating"));
                rating.setReviewText(result.getString("review_text"));
                ratings.add(rating);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return ratings;
    }

    public List<Rating_19161232> getRatingsForUser(int userId) {
        List<Rating_19161232> ratings = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rating WHERE userid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Rating_19161232 rating = new Rating_19161232();
                rating.setUserId(result.getInt("userid"));
                rating.setBookId(result.getInt("bookid"));
                rating.setRating(result.getInt("rating"));
                rating.setReviewText(result.getString("review_text"));
                ratings.add(rating);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return ratings;
    }

    public void updateRating(Rating_19161232 rating) {
        try {
            String sql = "UPDATE rating SET rating = ?, review_text = ? WHERE userid = ? AND bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, rating.getRating());
            statement.setString(2, rating.getReviewText());
            statement.setInt(3, rating.getUserId());
            statement.setInt(4, rating.getBookId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public void deleteRating(int userId, int bookId) {
        try {
            String sql = "DELETE FROM rating WHERE userid = ? AND bookid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
}

