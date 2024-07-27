package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBase {
    private static final String USERNAME = "root"; // Set your MySQL username here
    private static final String PASSWORD = "1234"; // Set your MySQL password here
    private static final String URL = "jdbc:mysql://localhost:3306/computer_shop"; // Set your database URL here

    public static Connection getConnection() {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error connecting to the database: " + ex.getMessage(), "Warning", 2);
        }
        return con;
    }
    
}
