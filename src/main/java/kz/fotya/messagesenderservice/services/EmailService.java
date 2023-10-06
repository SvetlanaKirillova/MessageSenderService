package kz.fotya.messagesenderservice.services;

import kz.fotya.messagesenderservice.web.model.EmailListDto;

public interface EmailService {
    void sendConfirmationEmail(String msg);

    EmailListDto uploadSentEmailsList();
}
