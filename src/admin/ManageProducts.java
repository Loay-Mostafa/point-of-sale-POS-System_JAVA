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
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class ManageProducts extends javax.swing.JFrame {

    ProductDao product = new ProductDao();
    Color textPrimaryColor = new Color(102, 120, 138);
    Color PrimaryColor = new Color(42, 58, 73);
    int xx, xy;
    Color notEdit = new Color(204, 20, 204);
    int rowIndex;
    DefaultTableModel model;
    String[] subcategory;
    Connection con = null;
    PreparedStatement ps = null; // Change the type to PreparedStatement
    ResultSet rs = null;
    private int pId;
    private String pname;
    private String brand;
    private int qty;
    private int price;

    String imagePath = null;

    public ManageProducts() {
        initComponents();
        init();
        product.getProductsValue(jTable1, "");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new com.raven.swing.MyTextField();
        jTextField7 = new com.raven.swing.MyTextField();
        jTextField9 = new com.raven.swing.MyTextField();
        jTextField10 = new com.raven.swing.MyTextField();
        jTextField11 = new com.raven.swing.MyTextField();
        button1 = new com.raven.swing.Button();
        button2 = new com.raven.swing.Button();
        button3 = new com.raven.swing.Button();
        button4 = new com.raven.swing.Button();
        button5 = new com.raven.swing.Button();
        header1 = new com.raven.component.Header();

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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Category", "Brand", "Quantety", "Price", "Describition"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setBackground(new java.awt.Color(7, 164, 121));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(7, 164, 121));
        jLabel3.setText("Product Name");

        jLabel4.setBackground(new java.awt.Color(7, 164, 121));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(7, 164, 121));
        jLabel4.setText("subcategory");

        jLabel7.setBackground(new java.awt.Color(7, 164, 121));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(7, 164, 121));
        jLabel7.setText("Quantaty");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel9.setBackground(new java.awt.Color(7, 164, 121));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(7, 164, 121));
        jLabel9.setText("Price");

        jLabel10.setBackground(new java.awt.Color(7, 164, 121));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(7, 164, 121));
        jLabel10.setText("Brand");

        jLabel11.setBackground(new java.awt.Color(7, 164, 121));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(7, 164, 121));
        jLabel11.setText("Describtion");

        jTextArea1.setBackground(new java.awt.Color(230, 245, 241));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel12.setBackground(new java.awt.Color(7, 164, 121));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(7, 164, 121));
        jLabel12.setText("Image");

        button1.setBackground(new java.awt.Color(7, 164, 121));
        button1.setForeground(new java.awt.Color(250, 250, 250));
        button1.setText("Save");
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

        button5.setBackground(new java.awt.Color(7, 164, 121));
        button5.setForeground(new java.awt.Color(250, 250, 250));
        button5.setText("Browse");
        button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button5MouseClicked(evt);
            }
        });

        header1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                header1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(0, 847, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel12)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
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
        subcategory = new String[product.countCategories()];
        setsub();
        ProductTable();

    }

    private void setsub() {
        String[] subcategory; // Get categories from the database
        subcategory = product.getsub();
        for (String s : subcategory) {
            jComboBox1.addItem(s); // Add each category to the JComboBox
        }
    }

    private void clear() {
        jTextField1.setText(""); // Clear jTextField1
        jTextField8.setText(""); // Clear jTextField2
        jTextField7.setText(""); // Clear jTextField3
        jComboBox1.setSelectedIndex(0); // Set jComboBox1 to the first item
        jTextField9.setText("0"); // Set for Quantity 
        jTextField10.setText("0.0"); // Set jTextField5 with default value
        jTextField11.setText("");
        jTextArea1.setText("");
        jTable1.clearSelection(); // Clear selection in jTable1jLabel13
        jLabel13.setIcon(null);// Clear jLabel13

    }

    private void ProductTable() {
        product.getProductsValue(jTable1, ""); // Assuming the second argument is for search term, here set to empty string

        // Set table properties
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        jTable1.setBackground(Color.WHITE);
        jTable1.setSelectionBackground(Color.LIGHT_GRAY);
    }

    private boolean isEmpty() {
        if (jTextField7.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product name is required", "Warning", 2);
            return false;
        }
        if (jTextField10.getText().equals("C). 0")) {
            JOptionPane.showMessageDialog(this, "Product price is required", "Warning", 2);
            return false;
        }
        if (Integer.parseInt(jTextField9.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Please increase the product quantity", "Warning", 2);
            return false;
        }
        return true;
    }

    // Declare imagePath outside any method
    public ImageIcon ResizePhoto(String imagePath, byte[] pic) {
        ImageIcon MyImage = null;
        if (imagePath != null) {
            MyImage = new ImageIcon(imagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        Image img = MyImage.getImage();
        // Calculate scaling factor
        double widthScale = (double) jLabel13.getWidth() / img.getWidth(null);
        double heightScale = (double) jLabel13.getHeight() / img.getHeight(null);
        // Use the smaller scale to maintain aspect ratio
        double scale = Math.min(widthScale, heightScale);

        // Resize image
        int newWidth = (int) (img.getWidth(null) * scale);
        int newHeight = (int) (img.getHeight(null) * scale);
        Image newImg = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        return new ImageIcon(newImg);
    }

    private boolean check() {
        String newProduct = jTextField7.getText();
        String oldProduct = model.getValueAt(rowIndex, 1).toString();
        String newCategory = jComboBox1.getSelectedItem().toString();
        String oldCategory = model.getValueAt(rowIndex, 2).toString();
        if (newProduct.equals(oldProduct) && newCategory.equals(oldCategory)) {
            return false;
        } else {
            boolean x = product.isProSubExist(newProduct, newCategory);
            if (x) {
                JOptionPane.showMessageDialog(this, "Product name and Category already exiist", "Warning", 2);
                return x;
            }
        }
        return false;
    }

    private void GetPhoto() {
        int Key = Integer.parseInt(jTextField8.getText()); // Assuming jTextField8 contains the product ID

        String query = "SELECT image_Path FROM products WHERE ProductId = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer_shop", "root", "1234"); PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, Key);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Assuming ResizePhoto() method takes byte array as input
                    jLabel13.setIcon(ResizePhoto(null, rs.getBytes("image_Path")));
                } else {
                    // Clear the icon if no image is available
                    jLabel13.setIcon(null);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
            // Handle specific exceptions here
            JOptionPane.showMessageDialog(this, "Error retrieving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        model = (DefaultTableModel) jTable1.getModel();
        rowIndex = jTable1.getSelectedRow();
        jTextField8.setText(model.getValueAt(rowIndex, 0).toString());
        jTextField7.setText(model.getValueAt(rowIndex, 1).toString());

        String category = model.getValueAt(rowIndex, 2).toString();
        for (int i = 0; i < jComboBox1.getItemCount(); i++) {
            if (jComboBox1.getItemAt(i).equals(category)) {
                jComboBox1.setSelectedIndex(i);
                break;
            }
        }
        jTextField9.setText(model.getValueAt(rowIndex, 4).toString());
        jTextField10.setText(model.getValueAt(rowIndex, 5).toString());
        jTextField11.setText(model.getValueAt(rowIndex, 3).toString());
        jTextArea1.setText(model.getValueAt(rowIndex, 6).toString());
        // Retrieve and update image path for the selected product
        GetPhoto();
        }//GEN-LAST:event_jTable1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        if (isEmpty()) {
            int id = Integer.parseInt(jTextField8.getText());
            String pname = jTextField7.getText();
            String sub = jComboBox1.getSelectedItem().toString();
            String qtyText = jTextField9.getText(); // Get the text from jTextField5
            String brand = jTextField11.getText();
            String desc = jTextArea1.getText();
            String imagePath = this.imagePath; // Assuming this is the class instance where imagePath is declared

            // Validate if a subcategory is selected
            if (sub.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a subcategory.", "Warning", 2);
                return; // Exit the method
            }

            // Validate if quantity is a numeric value
            if (!isNumeric(qtyText)) {
                JOptionPane.showMessageDialog(this, "Invalid quantity format. Numeric value is required.", "Warning", 2);
                return; // Exit the method
            }

            int qty = Integer.parseInt(qtyText); // Parse the quantity text to an integer

            if (isNumeric(jTextField10.getText())) {
                double price = Double.parseDouble(jTextField10.getText());

                // Check if the product ID already exists
                if (!product.isIdExist(id)) {
                    // Check if the product and category combination already exists
                    if (!product.isProSubExist(pname, sub)) {
                        try {
                            product.insert(id, pname, brand, price, qty, desc, imagePath, sub);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Product Name", "Category", "Brand", "Quantity", "Price", "Description"}));
                        product.getProductsValue(jTable1, ""); // Assuming the second argument is for search term, here set to empty string
                        clear();
                    } else {
                        JOptionPane.showMessageDialog(this, "Product and subcategory already exist.", "Warning", 2);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Product ID already exists.", "Warning", 2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid price format. Numeric value is required.", "Warning", 2);
            }

        }    }//GEN-LAST:event_button1MouseClicked


    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        if (isEmpty()) {
            int id = Integer.parseInt(jTextField8.getText());
            String ProName = jTextField7.getText();
            String cat = jComboBox1.getSelectedItem().toString();
            int quantaty = Integer.parseInt(jTextField9.getText());
            if (isNumeric(jTextField10.getText()));
            {
                double price = Double.parseDouble(jTextField10.getText());
                if (product.isIdExist(id)) {
                    if (!check()) {
                        try {
                            product.update(id, ProName, cat, quantaty, price);
                        } catch (SQLException ex) {
                            Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Product Name", "Category", "Brand", "Quantity", "Price", "Description"}));
                        product.getProductsValue(jTable1, "");
                        clear();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Product ID doesn't exist.", "Warning", 2);
                }
            }
        }    }//GEN-LAST:event_button2MouseClicked

    private void button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button3MouseClicked
        int id = Integer.parseInt(jTextField8.getText());
        if (product.isIdExist(id)) {
            try {
                product.delete(id);
            } catch (SQLException ex) {
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Product Name", "Category", "Quantity", "Price", "Brand", "Description"}));
            product.getProductsValue(jTable1, "");
        } else {
            JOptionPane.showMessageDialog(this, "Product ID does not exist.", "Warning", 2);
        }    }//GEN-LAST:event_button3MouseClicked

    private void button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button4MouseClicked
        clear();
    }//GEN-LAST:event_button4MouseClicked

    private void button5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button5MouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // Set file filter (optional)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.addChoosableFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLabel13.setIcon(ResizePhoto(path, null));
            imagePath = path;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "No file selected.");
        }
    }//GEN-LAST:event_button5MouseClicked

    private void header1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MouseClicked
        setVisible(false);
    }//GEN-LAST:event_header1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

        jTable1.setModel(new DefaultTableModel(null, new Object[]{"Product ID", "Product Name", "Category", "Quantity", "Price", "Brand", "Description"}));
        product.getProductsValue(jTable1, jTextField1.getText());

    }//GEN-LAST:event_jTextField1KeyReleased

    private boolean isNumeric(String s) {
        try {
            double d = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Numeric value is required for the input", "Warning", 2);
            return false;
        }
    }

    public static void main(String args[]) {
        IntelliJTheme.setup(Main.class.getResourceAsStream("/RoboticketLight.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin.ManageProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button button1;
    private com.raven.swing.Button button2;
    private com.raven.swing.Button button3;
    private com.raven.swing.Button button4;
    private com.raven.swing.Button button5;
    private com.raven.component.Header header1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private com.raven.swing.MyTextField jTextField10;
    private com.raven.swing.MyTextField jTextField11;
    private com.raven.swing.MyTextField jTextField7;
    private com.raven.swing.MyTextField jTextField8;
    private com.raven.swing.MyTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}