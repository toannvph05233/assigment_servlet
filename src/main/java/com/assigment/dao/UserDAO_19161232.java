package com.assigment.dao;

import com.assigment.model.User_19161232;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO_19161232 {
    private Connection connection;

    public UserDAO_19161232(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User_19161232 user) {
        try {
            String sql = "INSERT INTO users (email, fullname, phone, passwd, singup_date, last_login, is_admin) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getFullname());
            statement.setInt(3, user.getPhone());
            statement.setString(4, user.getPasswd());
            statement.setTimestamp(5, new java.sql.Timestamp(user.getSignupDate().getTime()));
            statement.setTimestamp(6, new java.sql.Timestamp(user.getLastLogin().getTime()));
            statement.setBoolean(7, user.isAdmin());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public User_19161232 getUserById(int userId) {
        User_19161232 user = null;
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user = new User_19161232();
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setFullname(result.getString("fullname"));
                user.setPhone(result.getInt("phone"));
                user.setPasswd(result.getString("passwd"));
                user.setSignupDate(result.getTimestamp("signup_date"));
                user.setLastLogin(result.getTimestamp("last_login"));
                user.setAdmin(result.getBoolean("is_admin"));
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return user;
    }

    public User_19161232 getUserByEmail(String email) {
        User_19161232 user = null;
        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user = new User_19161232();
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setFullname(result.getString("fullname"));
                user.setPhone(result.getInt("phone"));
                user.setPasswd(result.getString("passwd"));
                user.setSignupDate(result.getTimestamp("signup_date"));
                user.setLastLogin(result.getTimestamp("last_login"));
                user.setAdmin(result.getBoolean("is_admin"));
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return user;
    }

    public User_19161232 checklogin(String email, String password) {
        User_19161232 user = null;
        try {
            String sql = "SELECT * FROM users WHERE email = ? and passwd = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user = new User_19161232();
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setFullname(result.getString("fullname"));
                user.setPhone(result.getInt("phone"));
                user.setPasswd(result.getString("passwd"));
                user.setSignupDate(result.getTimestamp("signup_date"));
                user.setLastLogin(result.getTimestamp("last_login"));
                user.setAdmin(result.getBoolean("is_admin"));
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return user;
    }

    public List<User_19161232> getAllUsers() {
        List<User_19161232> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User_19161232 user = new User_19161232();
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setFullname(result.getString("fullname"));
                user.setPhone(result.getInt("phone"));
                user.setPasswd(result.getString("passwd"));
                user.setSignupDate(result.getTimestamp("signup_date"));
                user.setLastLogin(result.getTimestamp("last_login"));
                user.setAdmin(result.getBoolean("is_admin"));
                users.add(user);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(User_19161232 user) {
        try {
            String sql = "UPDATE users SET email = ?, fullname = ?, phone = ?, passwd = ?, " +
                    "signup_date = ?, last_login = ?, is_admin = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getFullname());
            statement.setInt(3, user.getPhone());
            statement.setString(4, user.getPasswd());
            statement.setTimestamp(5, new java.sql.Timestamp(user.getSignupDate().getTime()));
            statement.setTimestamp(6, new java.sql.Timestamp(user.getLastLogin().getTime()));
            statement.setBoolean(7, user.isAdmin());
            statement.setInt(8, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }
}

