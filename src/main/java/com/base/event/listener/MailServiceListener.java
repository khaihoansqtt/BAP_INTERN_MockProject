package com.base.event.listener;

import com.base.email.EmailService;
import com.base.event.CommonEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * This listener will receive the event which is published by MailServicePublisher
 */
@Component
@Slf4j
public class MailServiceListener implements ApplicationListener<CommonEvent> {

    @Autowired
    private EmailService emailService;

    @Override
    public void onApplicationEvent(CommonEvent event) {
        Map<String, Object> params = (HashMap)event.getContents().get(0);
        log.info("Received MailServicePublisher, mail type: {}", params.get("mailType"));
        emailService.sendEmailWithSimpleMessage(String.valueOf(params.get("to")),
                String.valueOf(params.get("subject")), String.valueOf(params.get("text")));
    }
}
