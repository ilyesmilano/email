package com.springbootsmtp.dto;

import com.springbootsmtp.model.EmailEntity;
import com.springbootsmtp.service.EmailService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EmailDto implements EmailService {

    private final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

    @Value("${spring.mail.username}")
    private String sender;

    private final JavaMailSender javaMailSender;

    public EmailDto(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String sendSimpleMail(EmailEntity emailEntity) {

        try {
            LOGGER.info("Preparing email ...");
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(emailEntity.getRecipient());
            mailMessage.setText(emailEntity.getMsgBody());
            mailMessage.setSubject(emailEntity.getSubject());

            LOGGER.info("Sending email ...");
            javaMailSender.send(mailMessage);
            LOGGER.info("Email sent successfully!");
            return "Mail sent Successfully.";
        } catch (Exception e) {
            LOGGER.severe("Sending email failed with error: " + e.getMessage());
            e.printStackTrace();
            return "Error occurred sending email. " + e.getMessage();
        }
    }

}
