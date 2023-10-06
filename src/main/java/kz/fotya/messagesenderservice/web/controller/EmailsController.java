package kz.fotya.messagesenderservice.web.controller;

import kz.fotya.messagesenderservice.services.EmailService;
import kz.fotya.messagesenderservice.web.model.EmailListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailsController {

    private final EmailService service;

    public EmailsController(EmailService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<EmailListDto> handleGetAllMessages(){

        return ResponseEntity.ok(service.uploadSentEmailsList());

    }

}
