package kz.fotya.messagesenderservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SENDEDED_EMAIL")
public class EmailSent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    private String message_text;

    @Column(length = 50, columnDefinition = "varchar(50)")
    private String status_code;

    public void setStatus_code(String error_message) {
        this.status_code = EmailSentStatus.ERROR + ":" + error_message;
    }


}
