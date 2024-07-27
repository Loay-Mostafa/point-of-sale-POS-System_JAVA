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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class CategoryDao {
    Connection con = DataBase.getConnection();
    PreparedStatement ps; // Change the type to PreparedStatement
    ResultSet rs;


    // Method to get the maximum row ID from the category table
    public int getMaxRow() {
        int row = 0;
        try {
            ps = con.prepareStatement("SELECT MAX(category_id) FROM category");
            rs = ps.executeQuery(); 
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public boolean isCatNameExist(String cname) {
        try {
            ps = con.prepareStatement("SELECT * FROM category WHERE category_name = ?");
            ps.setString(1, cname);
            rs = ps.executeQuery();
            return rs.next(); // If there is at least one row, the product exists with the given name and category
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void insert(int id, String cname, String description) {
        try {
            String sql = "INSERT INTO category (category_id, category_name, description) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, cname);
            ps.setString(3, description);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Category added successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getCategoryValue(JTable table, String search) {
        String sql = "SELECT * FROM category WHERE CONCAT(category_id, category_name) LIKE ? ORDER BY category_id DESC";
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
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(int id, String cname, String description) throws SQLException {
        String sql = "update category set category_name = ?, description = ? where category_id =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cname);
            ps.setString(2, description);
            ps.setInt(3, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Category updated successfuly");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("SELECT * FROM category WHERE category_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){ // If there is at least one row, the ID exists
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
        public void delete(int id) throws SQLException {
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete this category?", "Delete Category", JOptionPane.OK_CANCEL_OPTION, 0);
        if (x == JOptionPane.OK_OPTION) {
            try{
                ps = con.prepareStatement("delete from category where category_id = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Category deleted");
                }
            }catch(SQLException ex){
                Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
