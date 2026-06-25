package dasturlash.uz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "email_history")
public class EmailHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "to_email")
    private String toEmail;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
}
