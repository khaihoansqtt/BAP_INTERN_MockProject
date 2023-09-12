package com.base.controller;

import com.base.constant.MailType;
import com.base.event.publisher.MailServicePublisher;
import com.base.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sandbox")
public class SandboxController {
    @Autowired
    private MailServicePublisher mailServicePublisher;

    @GetMapping("/sendmail/simple")
    @ResponseBody
    public Object sendSimpleEmail() {
        Map<String, Object> params = new HashMap() {{
            put("mailType", MailType.SIMPLE_MAIL.name());
            put("to", "test_mail_123@bap.jp");
            put("subject", "Hello Subject");
            put("text", "Email content.");
        }};
        mailServicePublisher.publishSendingSimpleEmail(params);
        return new SuccessResponse<>("Email has been sent, pls check the inbox").toJson();
    }
}
