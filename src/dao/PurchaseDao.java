package dao;

import connection.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseDao {

    Connection con = DataBase.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    public int getMaxRow() {
        int row = 0;
        try {
            ps = con.prepareStatement("SELECT MAX(id) FROM purchase");
            rs = ps.executeQuery();
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public String[] getUserValue(String email) throws SQLException {
        String[] value = new String[4]; // Number of values to retrieve from the table
        String sql = "SELECT UserID, UserName FROM user WHERE Email = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                value[0] = rs.getString(1);
                value[1] = rs.getString(2);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

   public void insert(int id, String uname, int pid, String pname,
        int qty, double price, double total, String pDate, String rDate) {
    try {
        String sql = "INSERT INTO purchase (id, userName, productID, productName, quantity, price, total, p_date, r_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, uname);
        ps.setInt(3, pid);
        ps.setString(4, pname);
        ps.setInt(5, qty);
        ps.setDouble(6, price);
        ps.setDouble(7, total);
        ps.setString(8, pDate);
        ps.setString(9, rDate);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}




    public int getQty(int pid) {
        int qty = 0;
        try {
            String query = "SELECT quantity FROM products WHERE ProductId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            if (rs.next()) {
                qty = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qty;
    }

    public void qtyUpdate(int pid, int qty) {
        String sql = "UPDATE products SET quantity = ? WHERE ProductId = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setInt(2, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
