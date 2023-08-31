package com.example.springbootemail.service;

import com.example.springbootemail.entity.Email;

public interface EmailService {
    String sendEmail(Email email);
}
