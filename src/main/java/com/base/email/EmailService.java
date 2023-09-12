package com.base.email;

public interface EmailService {
    /**
     * send email with simple message
     * @param to
     * @param subject
     * @param text
     */
    void sendEmailWithSimpleMessage(String to, String subject, String text);

    /**
     * send email with attachment file
     * @param to
     * @param subject
     * @param text
     * @param pathToAttachment
     */
    void sendEmailWithAttachmentFile(String to, String subject, String text, String pathToAttachment);
}
