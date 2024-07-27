package com.raven.service;

import com.raven.model.ModelMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceMail {

    public ModelMessage sendMain(String toEmail, String code) {
        ModelMessage ms = new ModelMessage(false, "");
        String from = "computer.shop808@gmail.com";
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        String username = "computer.shop808@gmail.com";
        String password = "wlbe tlgf eaau mfyc"; // Your email password here

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Verify Code");
            message.setText("Your verification code is: " + code);
            
            Transport.send(message);
            ms.setSuccess(true);
            ms.setMessage("Email sent successfully.");
        } catch (MessagingException e) {
            String errorMsg = e.getMessage();
            if (errorMsg.contains("Invalid Addresses")) {
                ms.setMessage("Invalid email address: " + toEmail);
            } else {
                ms.setMessage("Failed to send email: " + errorMsg);
            }
        }
        return ms;
    }
}
