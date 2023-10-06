package kz.fotya.messagesenderservice.web.model;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class EmailListDto extends PageImpl<EmailDto> {
    public EmailListDto(List<EmailDto> content) {
        super(content);
    }
}
