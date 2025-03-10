package com.example.logingoogle;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Lib   {

    // Sinh OTP ngẫu nhiên (6 chữ số)
    public static String generateOTP() {
        int otp = 100000 + new Random().nextInt(900000);
        return String.valueOf(otp);
    }
    // Gửi OTP qua email
    public static void sendOTPEmail(Context context, String recipientEmail, String otp) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                String senderEmail = "thangncse172630@fpt.edu.vn";
                String senderPassword = "yfax syby mwrr ewhv"; // Mật khẩu ứng dụng

                // Cấu hình SMTP
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");

                // Xác thực Gmail
                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

                // Tạo email
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(senderEmail));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
                message.setSubject("Your OTP Code");
                message.setText("Mã OTP của bạn là: " + otp);

                // Gửi email
                Transport.send(message);

                // Hiển thị thông báo trên UI Thread bằng Handler
                new Handler(Looper.getMainLooper()).post(() ->
                        Toast.makeText(context, "OTP đã được gửi!", Toast.LENGTH_LONG).show());

            } catch (MessagingException e) {
                e.printStackTrace();
                new Handler(Looper.getMainLooper()).post(() ->
                        Toast.makeText(context, "Gửi OTP thất bại!", Toast.LENGTH_LONG).show());
            }
        });
    }


}
