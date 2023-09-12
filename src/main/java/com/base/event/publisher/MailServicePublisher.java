package com.base.event.publisher;

import com.base.event.CommonEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Publisher to publish an event
 */
@Component
@Slf4j
public class MailServicePublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * this method publish an event to send a simple email as async
     */
    public void publishSendingSimpleEmail(final Map<String, Object> params){
        log.info("method publishEmailSendingSimpleEmail call");
        CommonEvent commonEvent = new CommonEvent(this, params);
        applicationEventPublisher.publishEvent(commonEvent);
    }

    /**
     * this method publish an event to send an attachment email as async
     */
    public void publishSendingEmailWithAttachment(final Map<String, Object> params){
        log.info("method publishEmailSendingSimpleEmail call");
        CommonEvent commonEvent = new CommonEvent(this, params);
        applicationEventPublisher.publishEvent(commonEvent);
    }
}
