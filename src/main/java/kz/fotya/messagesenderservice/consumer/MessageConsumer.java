package kz.fotya.messagesenderservice.consumer;

import kz.fotya.messagesenderservice.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${kafka.topic}")
    public void listenMessagesFromProducer(@Payload String message){
        System.out.println("Get msg from consumer!" + message);
        emailService.sendConfirmationEmail(message);

    }
}
