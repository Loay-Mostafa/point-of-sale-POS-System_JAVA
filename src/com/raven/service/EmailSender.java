

package com.raven.service;

import com.raven.model.ModelMessage;
import com.raven.service.ServiceMail;
import java.util.Scanner;

public class EmailSender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter recipient email: ");
        String recipientEmail = scanner.nextLine();

        System.out.print("Enter verification code: ");
        String verificationCode = scanner.nextLine();

        ServiceMail serviceMail = new ServiceMail();
        ModelMessage result = serviceMail.sendMain(recipientEmail, verificationCode);

        if (result.isSuccess()) {
            System.out.println("Email was sent successfully: " + result.getMessage());
        } else {
            System.out.println("Email sending failed: " + result.getMessage());
        }

        scanner.close();
    }
}
