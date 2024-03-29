package com.ejder.bid.mate.bidmate.utils;

import com.ejder.bid.mate.bidmate.constants.Common;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Properties;

public class Util {

    public static String generateHash() {
        Long salt = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(salt);
        String hash = MD5Encoder.encode(buffer.array());
        return hash;
    }

    //@TODO add configuration to .properties file
    public void sendMail(String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@baeldung.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            getJavaMailSender().send(message);
    }

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("my.gmail@gmail.com");
        mailSender.setPassword("password");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public static HashMap<String, String> responseBody(String message){
        HashMap<String, String> response = new HashMap<>(1);
        response.put("message", message);
        return response;
    }
}
