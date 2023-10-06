package kz.fotya.messagesenderservice.services;
import kz.fotya.messagesenderservice.domain.EmailSent;
import kz.fotya.messagesenderservice.domain.EmailSentRepository;
import kz.fotya.messagesenderservice.domain.EmailSentStatus;
import kz.fotya.messagesenderservice.web.model.EmailDto;
import kz.fotya.messagesenderservice.web.model.EmailListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private final EmailSentRepository repository;

    @Value("${spring.mail.username}")
    private String emailSenderAddress;

    @Value("${mail.receiver.address}")
    private String emailReceiverAddress;

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendConfirmationEmail(String msg) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(emailReceiverAddress);
            messageHelper.setSubject("Kafka Customer Received Message");
            messageHelper.setText("Message received: " + msg);

            javaMailSender.send(mimeMessage);
            repository.save( EmailSent
                    .builder()
                    .email(msg)
                    .status_code(EmailSentStatus.SENT.toString())
                    .build());
            System.out.println("message sent. Total sent messages: " + repository.count());

        } catch (Exception e){
            System.out.println("First catch error " + e);
            EmailSent emailSaved = EmailSent.builder().email(msg).build();
            emailSaved.setStatus_code(e.getMessage().substring(0, Math.min(50, e.getMessage().length())));
            this.repository.save( emailSaved );
        }

    }

    @Override
    public EmailListDto uploadSentEmailsList() {
        List<EmailSent> emailSents = repository.findAll();
        List<EmailDto> dtoList = emailSents.stream().map(email -> EmailDto.builder()
                                        .email(email.getEmail())
                                        .statusCode(email.getStatus_code())
                                        .sentTime(email.getCreatedDate())
                                        .build())
                            .collect(Collectors.toList());

        return new EmailListDto(dtoList);
    }

}
