package com.base.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

import static java.util.Objects.requireNonNull;

@Component
@Log4j2
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
    private final JavaMailSender emailSender;

    @Value("${spring.boilerplate.mailservice.enable: false}")
    private boolean isEmailServiceEnabled;

    @Override
    public void sendEmailWithSimpleMessage(String to, String subject, String text) {
        if(isEmailServiceEnabled){
            log.info("sendEmailWithSimpleMessage called.");
            log.debug("sendEmailWithSimpleMessage called. Recipient: {}. Subject: {}, Content: {}, File: {}",
                    to, subject, text);

            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(to);
                message.setSubject(subject);
                message.setText(text);

                emailSender.send(message);
                log.info("sendEmailWithSimpleMessage done.");
            } catch(MailException e){
                log.error(e.getMessage());
            }
        } else {
            log.info("sendEmailWithSimpleMessage failed.");
            log.debug("sendEmailWithSimpleMessage failed. isEmailServiceEnable: {}", isEmailServiceEnabled);
        }
    }

    @Override
    public void sendEmailWithAttachmentFile(String to, String subject, String text, String pathToAttachment) {
        if(isEmailServiceEnabled){
            log.info("sendMessageWithAttachment called.");
            log.debug("sendMessageWithAttachment called. Recipient: {}. Subject: {}, Content: {}, File: {}",
                    to, subject, text, pathToAttachment);
            try {
                MimeMessage message = emailSender.createMimeMessage();

                // pass 'true' to the constructor to create a multipart message
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setTo(to);
                helper.setSubject(subject);
                helper.setText(text);

                FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
                helper.addAttachment(requireNonNull(file.getFilename()), file);

                emailSender.send(message);
                log.info("sendMessageWithAttachment done.");
            } catch (MessagingException e) {
                log.error(e.getMessage());
            }
        } else {
            log.info("sendEmailWithAttachmentFile failed.");
            log.debug("sendEmailWithAttachmentFile failed. isEmailServiceEnable: {}", isEmailServiceEnabled);
        }
    }
}
