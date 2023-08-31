package com.example.springbootemail.controller;

import com.example.springbootemail.entity.Email;
import com.example.springbootemail.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody Email email) {
        return emailService.sendEmail(email);
    }
}
