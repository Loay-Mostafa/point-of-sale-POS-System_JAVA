package com.loay.connection;

import com.raven.model.ModelLogin;
import com.raven.model.ModelUser;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;


public class loginData{

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/computer_shop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public loginData() {
        // Constructor can be left empty
    }

    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void insertUserData(String userName, String email, String password) throws SQLException {
        connect();
        String sql = "INSERT INTO user (UserName, Email, Password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userName);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
        } finally {
            disconnect();
        }
    }

    public boolean checkDuplicateUserName(String userName) throws SQLException {
        connect();
        String sql = "SELECT COUNT(*) FROM user WHERE UserName = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
            return false;
        } finally {
            disconnect();
        }
    }

    public boolean checkDuplicateEmail(String email) throws SQLException {
        connect();
        String sql = "SELECT COUNT(*) FROM user WHERE Email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
            return false;
        } finally {
            disconnect();
        }
    }
   public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    } // You can add other methods for updating, deleting, selecting data, etc.
   
   
   
   
   public boolean isValidLogin(String email, String password) throws SQLException {
        connect();
        
        String sql = "SELECT COUNT(*) FROM user WHERE Email = ? AND password = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
            
            return false;
        } finally {
            disconnect();
        }
    }

    public ModelUser login(ModelLogin data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   

}

