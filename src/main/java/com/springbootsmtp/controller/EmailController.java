package com.springbootsmtp.controller;

import com.springbootsmtp.model.EmailEntity;
import com.springbootsmtp.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class EmailController {

    private final Logger LOGGER = Logger.getLogger(EmailController.class.getName());

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(path = "/sendMail")
    public String sendMail(@RequestBody EmailEntity email) {
        LOGGER.info("Initiating emailService ...");
        String status = emailService.sendSimpleMail(email);
        LOGGER.info("Sending email finished with result: " + status);
        return status;
    }
}
