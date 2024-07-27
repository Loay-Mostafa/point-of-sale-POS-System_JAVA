/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class SubcategoryDao {
 Connection con = DataBase.getConnection();
    PreparedStatement ps; // Change the type to PreparedStatement
    ResultSet rs;


    // Method to get the maximum row ID from the category table
    public int getMaxRow() {
        int row = 0;
        try {
            ps = con.prepareStatement("SELECT MAX(subcategory_id) FROM subcategories");
            rs = ps.executeQuery();
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public int countCategories() {
        int total = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM category");
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public String[] getCat() {
        String[] categories = new String[countCategories()]; // Initialize the array with correct size
        try {
            Statement st = con.createStatement(); // Create statement
            rs = st.executeQuery("SELECT * FROM category"); // Execute query
            int i = 0;
            while (rs.next()) {
                categories[i] = rs.getString(2); // Populate categories array
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex); // Log any exceptions
        }
        return categories;
    }

    public boolean isCatNameExist(String cname) {
        try {
            ps = con.prepareStatement("SELECT * FROM subcategory WHERE subcategory_name = ?");
            ps.setString(1, cname);
            rs = ps.executeQuery();
            return rs.next(); // If there is at least one row, the product exists with the given name and category
        } catch (SQLException ex) {
            Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

public void insert(int id, String cname, String category_name) {
    try {
        // Check if the category exists
        String checkSql = "SELECT category_name FROM category WHERE category_name = ?";
        PreparedStatement checkPs = con.prepareStatement(checkSql);
        checkPs.setString(1, category_name);
        ResultSet rs = checkPs.executeQuery();
        
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Category does not exist.");
            return;
        }

        // Insert into subcategory
        String sql = "INSERT INTO subcategory (subcategory_id, subcategory_name, category_name) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, cname);
        ps.setString(3, category_name);

        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Subcategory added successfully");
        }
    } catch (SQLException ex) {
        Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    public void getSubCategoryValue(JTable table, String search) {
        String sql = "SELECT * FROM subcategory WHERE CONCAT(subcategory_id, subcategory_name, category_name) LIKE ? ORDER BY subcategory_id DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear previous data

            Object[] row;
            while (rs.next()) {
                row = new Object[3]; // Changed to 8 columns to accommodate subcategory name
                row[0] = rs.getInt(1); // Assuming cID is in the first column
                row[1] = rs.getString(2); // Assuming cNAME is in the second column
                row[2] = rs.getString(3); // Assuming des is in the third column
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(int id, String scname, String cname) throws SQLException {
        String sql = "update subcategory set subcategory_name = ?, category_name = ? where subcategory_id =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, scname);
            ps.setString(2, cname);
            ps.setInt(3, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Subcategory updated successfuly");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("SELECT * FROM subcategory WHERE subcategory_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) { // If there is at least one row, the ID exists
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    public void delete(int id) throws SQLException {
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete this Subcategory?", "Delete Category", JOptionPane.OK_CANCEL_OPTION, 0);
        if (x == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from subcategory where subcategory_id = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Subcategory deleted");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SubcategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
