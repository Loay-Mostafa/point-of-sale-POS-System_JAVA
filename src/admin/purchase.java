/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import com.raven.model.ModelLogin;
import dao.ProductDao;
import dao.PurchaseDao;
import dao.UserDetailsDialog;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;



import java.text.SimpleDateFormat;


import java.util.Date;


import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class purchase extends javax.swing.JFrame {
//    Date date = new Date();

    DefaultTableModel model;
    PurchaseDao purchaseDao = new PurchaseDao();
    ProductDao productDao = new ProductDao();
    Color textPrimaryColor = new Color(102, 120, 138);
    Color PrimaryColor = new Color(42, 58, 73);
    int xx, xy;
    Color notEdit = new Color(204, 20, 204);
    int rowIndex;
    String[] subcategory;
    private double price = 0.0;
    private double qty = 0;
    private double total = 0.0;
    private int pId;
    Connection con = null;
    PreparedStatement ps = null; // Change the type to PreparedStatement
    ResultSet rs = null;
    SimpleDateFormat df;
    Date date = new Date();


    public purchase()throws SQLException {
        initComponents();
        init();
        this.df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new com.raven.swing.MyTextField();
        jTextField3 = new com.raven.swing.MyTextField();
        button1 = new com.raven.swing.Button();
        button2 = new com.raven.swing.Button();
        button3 = new com.raven.swing.Button();
        button4 = new com.raven.swing.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new com.raven.swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        header1 = new com.raven.component.Header();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(184, 218, 201));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase ID", "Product ID", "Product Name ", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Category", "Brand", "Quantity", "Price", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        button1.setBackground(new java.awt.Color(7, 164, 121));
        button1.setForeground(new java.awt.Color(250, 250, 250));
        button1.setText("Add");
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
        button2.setText("Purchase");
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(7, 164, 121));
        button3.setForeground(new java.awt.Color(250, 250, 250));
        button3.setText("Clear");
        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button3MouseClicked(evt);
            }
        });
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(7, 164, 121));
        button4.setForeground(new java.awt.Color(250, 250, 250));
        button4.setText("Pint");
        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button4MouseClicked(evt);
            }
        });
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(7, 164, 121));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 164, 121));
        jLabel2.setText("Product ID");

        jLabel3.setBackground(new java.awt.Color(7, 164, 121));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(7, 164, 121));
        jLabel3.setText("Product Name");

        jLabel7.setBackground(new java.awt.Color(7, 164, 121));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(7, 164, 121));
        jLabel7.setText("Quantaty");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(7, 164, 121));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 164, 121));
        jLabel5.setText("Search");

        jLabel6.setBackground(new java.awt.Color(7, 164, 121));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(7, 164, 121));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total : 0.0");

        header1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                header1MouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel8.setBackground(new java.awt.Color(7, 164, 121));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(7, 164, 121));
        jLabel8.setText("Description");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void init() {
//        jTextField2.setText(String.valueOf(purchaseDao.getMaxRow()));
        ProductsTable();
        PurchaseTable();
        pId = purchaseDao.getMaxRow();

    }

    private void ProductsTable() {
        productDao.getProductsValue(jTable1, ""); // Assuming the second argument is for search term, here set to empty string

        // Set table properties
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        jTable1.setBackground(Color.WHITE);
        jTable1.setSelectionBackground(Color.LIGHT_GRAY);
    }

    private void PurchaseTable() {
//        product.getProductsValue(jTable1, ""); // Assuming the second argument is for search term, here set to empty string

        // Set table properties
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        jTable2.setRowHeight(30);
        jTable2.setShowGrid(true);
        jTable2.setGridColor(Color.BLACK);
        jTable2.setBackground(Color.WHITE);
        jTable2.setSelectionBackground(Color.LIGHT_GRAY);
    }

    private void clear() {
//        jTextField2.setText(String.valueOf(purchaseDao.getMaxRow()));
        jTextField1.setText(""); // Clear jTextField1
        jTextField3.setText(""); // Clear jTextField2
        jTextField2.setText("");
        jTextField4.setText("0"); // Clear jTextField3
        jTextField1.setText(""); // Set jComboBox1 to the first item
        jTable2.clearSelection();
        jTable1.clearSelection();
        jLabel1.setIcon(null);
        jTextArea1.setText("");
        // Clear selection in jTable1
        price = 0.0;
        qty = 0;
    }
    public ImageIcon ResizePhoto(String imagePath, byte[] pic) {
        ImageIcon MyImage = null;
        if (imagePath != null) {
            MyImage = new ImageIcon(imagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        Image img = MyImage.getImage();
        // Calculate scaling factor
        double widthScale = (double) jLabel1.getWidth() / img.getWidth(null);
        double heightScale = (double) jLabel1.getHeight() / img.getHeight(null);
        // Use the smaller scale to maintain aspect ratio
        double scale = Math.min(widthScale, heightScale);

        // Resize image
        int newWidth = (int) (img.getWidth(null) * scale);
        int newHeight = (int) (img.getHeight(null) * scale);
        Image newImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        return new ImageIcon(newImg);
    }

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked


    }//GEN-LAST:event_button1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
      if (jTextField3.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Please select a product", "Warning", 2);
} else if (jTextField4.getText().isEmpty()){
    JOptionPane.showMessageDialog(this, "Product Quantity are required", "Warning", 2);
}
      else {
    model = (DefaultTableModel) jTable1.getModel();
    int proId = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
    if (!isProductExist(proId)) {
        if (qty > 0) { // Check if there's available stock
            int newQty = Integer.parseInt(jTextField4.getText());
            if (newQty != 0) {
                // Check if there's enough stock
                if (newQty <= qty) {
                    // Get product name, price, and calculate total price
                    String productName = jTextField3.getText();
                    String totalPrice = String.format("%.2f", price * (double) newQty);

                    // Create an Object array with product data
                    Object[] data = {pId, proId, productName, newQty, price, totalPrice};

                    // Add the product to the jTable2 (shopping cart)
                    model = (DefaultTableModel) jTable2.getModel();
                    model.addRow(data);

                    // Update the total label
                    total += price * (double) newQty;
                    jLabel6.setText(String.format("Total: %.2f", total));
                    pId++;
                    clear();
                } else {
                    JOptionPane.showMessageDialog(this, "Not enough stock", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please increase the product quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Stock is empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Product already purchased", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}

    }//GEN-LAST:event_button1ActionPerformed
private boolean isProductExist(int proId) {
     model = (DefaultTableModel) jTable2.getModel();
    if (model.getRowCount() > 0) { // Check if there are rows in the table
        for (int i = 0; i < model.getRowCount(); i++) {
            int newProId = Integer.parseInt(model.getValueAt(i, 1).toString()); // Assuming product ID is stored in the second column
            if (newProId == proId) {
                return true; // Product already exists in the shopping cart
            }
        }
    }
    return false; // Product does not exist in the shopping cart
}

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_button2MouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
    model = (DefaultTableModel) jTable2.getModel();
    if (model.getRowCount() > 0) {
        String uname = JOptionPane.showInputDialog(this, "Please enter your username:", "Enter Username", JOptionPane.QUESTION_MESSAGE);
        
        if (uname != null && !uname.isEmpty()) { // Check if username is provided
            String purchaseDate = df.format(date); // Get current date for purchase date
            String receiptDate = purchaseDate; // Assuming receipt date is the same as purchase date

            for (int i = 0; i < model.getRowCount(); i++) {
                int id = Integer.parseInt(model.getValueAt(i, 0).toString());
                int pid = Integer.parseInt(model.getValueAt(i, 1).toString());
                String pName = model.getValueAt(i, 2).toString();
                int q = Integer.parseInt(model.getValueAt(i, 3).toString());
                double pri = Double.parseDouble(model.getValueAt(i, 4).toString());
                double tot = Double.parseDouble(model.getValueAt(i, 5).toString());

                // Insert into database
                purchaseDao.insert(id, uname, pid, pName, q, pri, tot, purchaseDate, receiptDate);
            }

            JOptionPane.showMessageDialog(this, "Purchase successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid username.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "You haven't purchased anything", "Warning", JOptionPane.WARNING_MESSAGE);
    }




    }//GEN-LAST:event_button2ActionPerformed

    private void button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseClicked
clear();
    }//GEN-LAST:event_button3MouseClicked

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_button4MouseClicked

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
    try {
    // Get the recipient's email from user input
    String recipientEmail = JOptionPane.showInputDialog(this, "Please enter recipient's Email:", "Enter Recipient Email", JOptionPane.QUESTION_MESSAGE);

    if (recipientEmail != null && !recipientEmail.isEmpty()) { // Check if a valid email is provided
        // Format the current date as receipt date
        String receiptDate = df.format(date);

        // Create the header including the recipient's email and receipt date
        MessageFormat header = new MessageFormat("Receipt for: " + recipientEmail + " - Date: " + receiptDate);

        // Create a footer with a placeholder for page number
        MessageFormat footer = new MessageFormat("Page {0}");

        // Print the content of jTable2 (shopping cart) with the header and footer
        jTable2.print(JTable.PrintMode.FIT_WIDTH, header, footer);
    } else {
        JOptionPane.showMessageDialog(this, "Please enter a valid recipient email.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
} catch (PrinterException ex) {
    Logger.getLogger(purchase.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(this, "Error printing receipt: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}



    }//GEN-LAST:event_button4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed
private void GetPhoto() {
    int Key = Integer.parseInt(jTextField2.getText()); // Assuming jTextField8 contains the product ID

    String query = "SELECT image_Path FROM products WHERE ProductId = ?";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_shop", "root", "1234");
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setInt(1, Key);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                // Assuming ResizePhoto() method takes byte array as input
                jLabel1.setIcon(ResizePhoto(null, rs.getBytes("image_Path")));
            } else {
                // Clear the icon if no image is available
                jLabel1.setIcon(null);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
        // Handle specific exceptions here
        JOptionPane.showMessageDialog(this, "Error retrieving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }}
    
    
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        model = (DefaultTableModel) jTable1.getModel();
        rowIndex = jTable1.getSelectedRow();
        jTextField2.setText(model.getValueAt(rowIndex, 0).toString());
        jTextField3.setText(model.getValueAt(rowIndex, 1).toString());
        String s1 = model.getValueAt(rowIndex, 4).toString();
        String s2 = model.getValueAt(rowIndex, 5).toString();
        qty = Integer.parseInt(s1);
        price = Double.parseDouble(s2);
        jTextArea1.setText(model.getValueAt(rowIndex, 6).toString());
GetPhoto();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
     }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Product Name", "Category", "Brand", "Quantity", "Price"}));
        productDao.getProductsValue(jTable1, jTextField1.getText());    }//GEN-LAST:event_jTextField1KeyReleased

    private void header1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MouseClicked
        setVisible(false);
    }//GEN-LAST:event_header1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new purchase().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(purchase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private com.raven.swing.Button button2;
    private com.raven.swing.Button button3;
    private com.raven.swing.Button button4;
    private com.raven.component.Header header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private com.raven.swing.MyTextField jTextField2;
    private com.raven.swing.MyTextField jTextField3;
    private com.raven.swing.MyTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
