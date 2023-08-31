package com.example.springbootemail.serviceImpl;

import com.example.springbootemail.entity.Email;
import com.example.springbootemail.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailServiceImpl() {
    }

    @Override
    public String sendEmail(Email email) {
        try{
            if (LocalDateTime.now().isAfter(email.getDeadLine())) {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
                mimeMessageHelper.setFrom(fromEmail);
                mimeMessageHelper.setTo(email.getTo());
                mimeMessageHelper.setCc(email.getCc());
                mimeMessageHelper.setSubject(email.getSubject());
                mimeMessageHelper.setText(email.getBody());
//                mimeMessageHelper.addAttachment(Objects.requireNonNull(email.getFile().getOriginalFilename()), new ByteArrayResource(email.getFile().getBytes()));

                javaMailSender.send(mimeMessage);

                return "Email sent successfully...";
            }
            return "Deadline is not reached yet...";

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
