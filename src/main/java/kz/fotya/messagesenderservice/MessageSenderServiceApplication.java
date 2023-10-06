package kz.fotya.messagesenderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class MessageSenderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageSenderServiceApplication.class, args);
    }

}
