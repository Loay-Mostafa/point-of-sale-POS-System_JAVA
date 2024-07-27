/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import com.formdev.flatlaf.IntelliJTheme;
import com.raven.main.Main;
import com.raven.swing.MyTextField;
import connection.DataBase;
import dao.ProductDao;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Manageoffers extends javax.swing.JFrame {

    ProductDao product = new ProductDao();
    Color textPrimaryColor = new Color(102, 120, 138);
    Color PrimaryColor = new Color(42, 58, 73);
    int xx, xy;
    Color notEdit = new Color(204, 20, 204);
    int rowIndex;
    DefaultTableModel model;
    String[] subcategory;
    private int ofId;

    private int offamount;

    public Manageoffers() {
        initComponents();
        init();
        product.getOffersValue(jTable1, "");
        setResizable(true);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new com.raven.swing.MyTextField();
        jTextField9 = new com.raven.swing.MyTextField();
        jTextField10 = new com.raven.swing.MyTextField();
        button1 = new com.raven.swing.Button();
        button2 = new com.raven.swing.Button();
        button3 = new com.raven.swing.Button();
        button4 = new com.raven.swing.Button();
        winButton1 = new com.raven.swing.win_button.WinButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(184, 218, 201));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(7, 164, 121));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 164, 121));
        jLabel5.setText("Search");

        jLabel2.setBackground(new java.awt.Color(7, 164, 121));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 164, 121));
        jLabel2.setText("Product ID");

        jTable1.setBackground(new java.awt.Color(230, 245, 241));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product ID", "Offer ID", "Offer Mount"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setBackground(new java.awt.Color(7, 164, 121));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(7, 164, 121));
        jLabel7.setText("Offer ID");

        jLabel9.setBackground(new java.awt.Color(7, 164, 121));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(7, 164, 121));
        jLabel9.setText("Offer Amount");

        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10MouseClicked(evt);
            }
        });

        button1.setBackground(new java.awt.Color(7, 164, 121));
        button1.setForeground(new java.awt.Color(250, 250, 250));
        button1.setText("Add Offer");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(7, 164, 121));
        button2.setForeground(new java.awt.Color(250, 250, 250));
        button2.setText("Update");
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });

        button3.setBackground(new java.awt.Color(7, 164, 121));
        button3.setForeground(new java.awt.Color(250, 250, 250));
        button3.setText("Delete");
        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button3MouseClicked(evt);
            }
        });

        button4.setBackground(new java.awt.Color(7, 164, 121));
        button4.setForeground(new java.awt.Color(250, 250, 250));
        button4.setText("Clear");
        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button4MouseClicked(evt);
            }
        });

        winButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                winButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(winButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(winButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void init() {
//           jTextField2.setBackground(notEdit);
        try {
            ProductDao productDao = new ProductDao(); // Create an instance of ProductDao
            int maxProductId = productDao.getMaxProductId(); // Get the maximum product ID
            jTextField8.setText(String.valueOf(maxProductId)); // Set the text of jTextField2
        } catch (Exception ex) {
            // Handle any exceptions that might occur
            ex.printStackTrace();
        }
        offertable();

    }

    private void clear() {
        jTextField1.setText(""); // Clear jTextField1
        jTextField8.setText(""); // Clear jTextField2
        jTextField9.setText("0"); // Set for Quantity 
        jTextField10.setText("0.0"); // Set jTextField5 with default value
        jTable1.clearSelection(); // Clear selection in jTable1
    }

    private void offertable() {
        product.getOffersValue(jTable1, ""); // Assuming the second argument is for search term, here set to empty string

        // Set table properties
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        jTable1.setBackground(Color.WHITE);
        jTable1.setSelectionBackground(Color.LIGHT_GRAY);
    }

    // In your ProductDao class
// In your ManageProducts class or wherever you need to display the product IDs
// In your ManageProducts class or wherever you need to display the product IDs
    private boolean isEmpty() {

        if (jTextField9.getText().equals("C). 0")) {
            JOptionPane.showMessageDialog(this, "Offer ID is required", "Warning", 2);
            return false;
        }
        if (jTextField10.getText().equals("C). 0")) {
            JOptionPane.showMessageDialog(this, "Offer ID is required", "Warning", 2);
            return false;
        }
        if (Integer.parseInt(jTextField10.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Please increase the OFFER AMOUNT", "Warning", 2);
            return false;
        }
        return true;
    }


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        model = (DefaultTableModel) jTable1.getModel();
        rowIndex = jTable1.getSelectedRow();
        jTextField8.setText(model.getValueAt(rowIndex, 0).toString());

        jTextField9.setText(model.getValueAt(rowIndex, 1).toString());
        jTextField10.setText(model.getValueAt(rowIndex, 2).toString());

        // Retrieve and update image path for the selected product
        }//GEN-LAST:event_jTable1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        if (isEmpty()) {
            int productId = Integer.parseInt(jTextField8.getText());
            int offerId = Integer.parseInt(jTextField9.getText());
            double offerAmount = Double.parseDouble(jTextField10.getText());

            // Validate offer data
            if (offerId <= 0) {
                JOptionPane.showMessageDialog(this, "Invalid offer ID.", "Warning", 2);
                return;
            }

            // Add the offer to the product
            product.addOffer(productId, offerId, offerAmount);

            // Update UI
            jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Offer ID", "Offer Amount"}));
            product.getOffersValue(jTable1, ""); // Refresh table data
            clear();


        }    }//GEN-LAST:event_button1MouseClicked

    private void button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseClicked
        try {
            int offerId = Integer.parseInt(jTextField9.getText());

            // Check if the offer ID exists
            if (product.isOfferIdExist(offerId)) {
                // Call the deleteOffer method to remove the offer
                product.deleteOffer(offerId);
                // Refresh the table after deleting the offer
                jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Offer ID", "Offer Amount"}));
                product.getOffersValue(jTable1, "");
            } else {
                JOptionPane.showMessageDialog(this, "Offer with ID " + offerId + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid offer ID format. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);


        }    }//GEN-LAST:event_button3MouseClicked

    private void button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseClicked
        clear();
    }//GEN-LAST:event_button4MouseClicked

    private void winButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winButton1MouseClicked
        setVisible(false);
    }//GEN-LAST:event_winButton1MouseClicked

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        if (isEmpty()) {
            int offerId = Integer.parseInt(jTextField9.getText());
            double offerAmount = Double.parseDouble(jTextField10.getText());

            // Check if the offer ID exists
            if (product.isOfferIdExist(offerId)) {
                // Update the offer
                try {
                    product.updateOffer(offerId, offerAmount);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Refresh the table after updating the offer
                jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Offer ID", "Offer Amount"}));
                product.getOffersValue(jTable1, "");
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Offer with ID " + offerId + " does not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_button2MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Offer ID", "Offer Amount"}));
            product.getOffersValue(jTable1,jTextField1.getText());    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10MouseClicked

    public static void main(String args[]) {
        IntelliJTheme.setup(Main.class.getResourceAsStream("/RoboticketLight.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin.Manageoffers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private com.raven.swing.Button button2;
    private com.raven.swing.Button button3;
    private com.raven.swing.Button button4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private com.raven.swing.MyTextField jTextField10;
    private com.raven.swing.MyTextField jTextField8;
    private com.raven.swing.MyTextField jTextField9;
    private com.raven.swing.win_button.WinButton winButton1;
    // End of variables declaration//GEN-END:variables
}
