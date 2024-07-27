
package dao;


import connection.DataBase;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductDao {
    Connection con = DataBase.getConnection();
    PreparedStatement ps; // Change the type to PreparedStatement
    ResultSet rs;

    // Method to get the maximum row ID from the product table
    public int getMaxProductId() {
        int row = 0;
        try {
            ps = con.prepareStatement("SELECT MAX(ProductId) FROM products");
            rs = ps.executeQuery();
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }
    public int countCategories() {
    int total = 0;
    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM subcategory");
        if (rs.next()) {
            total = rs.getInt(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return total;
}

    // Method to count the categories
  public String[] getsub() {
    String[] subcategories = new String[countCategories()]; // Initialize the array with correct size
    try {
        Statement st = con.createStatement(); // Create statement
        rs = st.executeQuery("SELECT * FROM subcategory"); // Execute query
        int i = 0;
        while (rs.next()) {
            subcategories[i] = rs.getString(2); // Populate categories array
            i++;
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex); // Log any exceptions
    }
    return subcategories;
}
  public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("SELECT * FROM products WHERE ProductId = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            return rs.next(); // If there is at least one row, the ID exists
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
  
  public void insert(int id, String pname, String brand, double price, int qty, String description, String imagePath, String cname) throws FileNotFoundException {
    try {
        String sql = "INSERT INTO products (ProductId, ProductName, brand, price, quantity, description, image_path, subcategory_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql); 
        ps.setInt(1, id);
        ps.setString(2, pname);
        ps.setString(3, brand);
        ps.setDouble(4, price);
        ps.setInt(5, qty);
        ps.setString(6, description);
        InputStream img = new FileInputStream(new File(imagePath));
        ps.setBlob(7, img); // Set the imagePath as Blob
        ps.setString(8, cname);
        
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Product added successfully");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}


 public boolean isProSubExist(String pro, String sub) {
        try {
            ps = con.prepareStatement("SELECT * FROM products WHERE ProductName = ? AND subcategory_name = ?");
            ps.setString(1, pro);
            ps.setString(2, sub);
            rs = ps.executeQuery();
            return rs.next(); // If there is at least one row, the product exists with the given name and category
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
 public boolean isOfferIdExist(int offerId) {
    String query = "SELECT * FROM product_offers WHERE offer_id = ?";
    try (Connection con = DataBase.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {
        
        pst.setInt(1, offerId);
        try (ResultSet rs = pst.executeQuery()) {
            return rs.next(); // Returns true if the offer ID exists, false otherwise
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        return false; // Return false in case of an exception
    }
}

    // Insert data into the product table


public void getProductsValue(JTable table, String search) {
    String sql = "SELECT * FROM products WHERE CONCAT(ProductId, ' ', ProductName, ' ', subcategory_name) LIKE ? ORDER BY ProductId DESC";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + search + "%");
        ResultSet rs = ps.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous data
        
        Object[] row;
        while (rs.next()) {
              row = new Object[7]; // Changed to 8 columns to accommodate subcategory name
            row[0] = rs.getInt(1); // Assuming PID is in the first column
            row[1] = rs.getString(2); // Assuming PNAME is in the second column
            row[2] = rs.getString(8); // Assuming sub is in the third column
            row[3] = rs.getString(3); // Assuming brand is in the fourth column
            row[4] = rs.getInt(5); // Assuming QTY is in the fifth column
            row[5] = rs.getDouble(4); // Assuming price is in the sixth column
            row[6] = rs.getString(6); // Assuming desc is in the eighth column
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void getOffersValue(JTable table, String search) {
    String sql = "SELECT * FROM product_offers WHERE CONCAT(offer_id, ' ', product_id, ' ', offer_amount) LIKE ? ORDER BY offer_id DESC";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + search + "%");
        ResultSet rs = ps.executeQuery();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous data
        
        Object[] row;
        while (rs.next()) {
            row = new Object[3]; 
            row[0] = rs.getInt(2); // Assuming PID is in the first column
            row[1] = rs.getInt(1); // Assuming PNAME is in the second column
            row[2] = rs.getInt(3); // Assuming sub is in the third column
           
            model.addRow(row);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    //  delete product 
    public void delete(int id) throws SQLException {
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete this product?", "Delete Product", 2);
        if (x == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from products where ProductId = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Product deleted");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public void deleteOffer(int offerId) {
    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this offer?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) {
        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM product_offers WHERE offer_id = ?")) {
            
            ps.setInt(1, offerId);
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Offer deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Offer with ID " + offerId + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting offer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}

    //  updata product 
    public void update(int id,  String proName, String subcatName, int quantity, double price) throws SQLException {
String sql = "update products set ProductName = ?, subcategory_name = ?, quantity = ?, price = ? where ProductId = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, proName);
            ps.setString(2, subcatName);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.setInt(5, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Product updated successfuly");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateOffer(int offerId, double offerAmount) throws SQLException {
    String sql = "UPDATE product_offers SET offer_amount = ? WHERE offer_id = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, offerAmount);
        ps.setInt(2, offerId);
        
        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Offer updated successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update offer");
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    
public void addOffer(int productId, int offerId, double offerAmount) {
     if (isOfferIdExist(offerId)) {
        JOptionPane.showMessageDialog(null, "Offer ID already exists.", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String insertQuery = "INSERT INTO product_offers (product_id, offer_id, offer_amount) VALUES (?, ?, ?)";

    try (Connection con = DataBase.getConnection();
         PreparedStatement pst = con.prepareStatement(insertQuery)) {

        pst.setInt(1, productId);
        pst.setInt(2, offerId);
        pst.setDouble(3, offerAmount);

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            updateProductPrice(productId, offerAmount); // Update product price
            JOptionPane.showMessageDialog(null, "Offer added successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add offer.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error adding offer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}

public double getProductPrice(int productId) {
    double price = 0.0; // Default price
    
    String query = "SELECT price FROM products WHERE ProductId = ?";
    
    try (Connection con = DataBase.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setInt(1, productId);

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                price = rs.getDouble("price");
            }
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving product price: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    
    return price;
}


public void updateProductPrice(int productId, double offerAmount) {
    // Get the original price of the product before applying the offer
    double originalPrice = getProductPrice(productId);

    // Calculate the new price after applying the offer
    double newPrice = originalPrice - offerAmount;

    // Update the product price in the database
    String updateQuery = "UPDATE products SET price = ? WHERE ProductId = ?";
    
    try (Connection con = DataBase.getConnection();
         PreparedStatement pst = con.prepareStatement(updateQuery)) {

        pst.setDouble(1, newPrice);
        pst.setInt(2, productId);

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Product price updated successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update product price.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error updating product price: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}


    
}

