package com.example.springbootemail.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Email {
    private String to;
    private String cc;
    private String subject;
    private String body;
//    private MultipartFile file;
    private LocalDateTime deadLine;
}
