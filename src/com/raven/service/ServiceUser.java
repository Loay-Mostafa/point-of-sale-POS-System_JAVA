/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service;

import com.raven.connection.DatabaseConnection;
import com.raven.model.ModelLogin;
import com.raven.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    public ModelUser login(ModelLogin login) throws SQLException {
    ModelUser data = null;
    String query = "SELECT UserID, UserName, Email FROM `users` WHERE BINARY(Email)=? AND BINARY(`Password`)=? AND `Status`='Verified' LIMIT 1";
    
    try (PreparedStatement p = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        // Set parameters for email and password
        p.setString(1, login.getEmail());
        p.setString(2, login.getPassword());

        try (ResultSet r = p.executeQuery()) {
            // Check if the result set contains any rows
            if (r.first()) {
                // Retrieve user data from the result set
                int userID = r.getInt("UserID");
                String userName = r.getString("UserName");
                String email = r.getString("Email");
                
                // Initialize ModelUser object
                data = new ModelUser(userID, userName, email, "");
            }
        }
    }

    return data; // Return the authenticated user data or null if authentication fails
}



    public boolean isValidLogin(String email, String password) throws SQLException {
    // Query to check if the provided email and password match any user's credentials
    String query = "SELECT COUNT(*) FROM `users` WHERE BINARY(Email)=? AND BINARY(`Password`)=? AND `Status`='Verified'";
    
    try (PreparedStatement p = con.prepareStatement(query)) {
        p.setString(1, email);
        p.setString(2, password);
        
        try (ResultSet r = p.executeQuery()) {
            if (r.next()) {
                int count = r.getInt(1);
                return count > 0; // Return true if there is at least one matching record
            }
        }
    }
    
    return false; // Return false if no matching record found or in case of an exception
}


  public void insertUser(ModelUser user) throws SQLException {
    String code;
    int userID;
    try (PreparedStatement p = con.prepareStatement("INSERT INTO `users` (UserName, Email, `Password`, VerifyCode) VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
        code = generateVerifyCode();
        p.setString(1, user.getUserName());
        p.setString(2, user.getEmail());
        p.setString(3, user.getPassword());
        p.setString(4, code);
        p.executeUpdate(); // Use executeUpdate instead of execute for INSERT statements
        try (ResultSet r = p.getGeneratedKeys()) {
            if (r.next()) { // Use next() to move the cursor to the first row
                userID = r.getInt(1);
            } else {
                throw new SQLException("No generated keys returned");
            }
        }
    }

    // Insert into the 'user' table
    try (PreparedStatement pUser = con.prepareStatement("INSERT INTO `user` (UserName, Email, `Password`) VALUES (?,?,?)")) {
        pUser.setString(1, user.getUserName());
        pUser.setString(2, user.getEmail());
        pUser.setString(3, user.getPassword());
        pUser.executeUpdate();
    }

    user.setUserID(userID);
    user.setVerifyCode(code);
}



    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

   private boolean checkDuplicateCode(String code) throws SQLException {
    boolean duplicate = false;
    try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `users` WHERE VerifyCode=? LIMIT 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        p.setString(1, code);
        try (ResultSet r = p.executeQuery()) {
            if (r.first()) {
                duplicate = true;
            }
        }
    }
    return duplicate;
}

public boolean checkDuplicateUser(String user) throws SQLException {
    boolean duplicate = false;
    try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `users` WHERE UserName=? AND `Status`='Verified' LIMIT 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        p.setString(1, user);
        try (ResultSet r = p.executeQuery()) {
            if (r.first()) {
                duplicate = true;
            }
        }
    }
    return duplicate;
}

public boolean checkDuplicateEmail(String email) throws SQLException {
    boolean duplicate = false;
    try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `users` WHERE Email=? AND `Status`='Verified' LIMIT 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        p.setString(1, email);
        try (ResultSet r = p.executeQuery()) {
            if (r.first()) {
                duplicate = true;
            }
        }
    }
    return duplicate;
}

public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
    boolean verify = false;
    try (PreparedStatement p = con.prepareStatement("SELECT UserID FROM `users` WHERE UserID=? AND VerifyCode=? LIMIT 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        p.setInt(1, userID);
        p.setString(2, code);
        try (ResultSet r = p.executeQuery()) {
            if (r.first()) {
                verify = true;
            }
        }
    }
    return verify;
}


    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = con.prepareStatement("update `users` set VerifyCode='', `Status`='Verified' where UserID=? limit 1");
        p.setInt(1, userID);
        p.execute();
        p.close();
    }

    
}