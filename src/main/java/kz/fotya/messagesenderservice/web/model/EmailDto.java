package kz.fotya.messagesenderservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDto {

    private String email;
    private String statusCode;
    private Timestamp sentTime;
}
