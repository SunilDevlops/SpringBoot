package com.smtp.email.controller;

import java.time.format.DateTimeFormatter;

import com.smtp.email.entity.EmailDetails;
import com.smtp.email.service.EmailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EmailController {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailServiceImpl emailService;

    // Sending a simple Email
    // JavaMailSender interface of JavaMail API is used here to send simple text email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status = emailService.sendSimpleMail(details);

        return status;
    }

    // Sending email with attachment
    // To send a more sophisticated email with an attachment, MimeMessage can be used
    // MimeMessageHelper works as a helper class for MimeMessage to add the attachment and other details required to send the mail
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }
}
