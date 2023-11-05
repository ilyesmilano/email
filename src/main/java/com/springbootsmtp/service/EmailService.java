package com.springbootsmtp.service;

import com.springbootsmtp.model.EmailEntity;

public interface EmailService {
    String sendSimpleMail(EmailEntity emailEntity);
}
