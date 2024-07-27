/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.*;
import java.awt.*;

public class UserDetailsDialog extends JDialog {
    private JTextField addressField;
    private JTextField phoneField;
    private boolean confirmed;

    public UserDetailsDialog(Frame parent) {
        super(parent, "Enter Details", true);
        setLayout(new GridLayout(3, 2));

        // Address field
        add(new JLabel("Address:"));
        addressField = new JTextField(20);
        add(addressField);

        // Phone field
        add(new JLabel("Phone:"));
        phoneField = new JTextField(20);
        add(phoneField);

        // Buttons
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            confirmed = true;
            setVisible(false);
        });
        add(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            confirmed = false;
            setVisible(false);
        });
        add(cancelButton);

        pack();
        setLocationRelativeTo(parent);
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getPhone() {
        return phoneField.getText();
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}

