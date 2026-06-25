package dasturlash.uz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;
}
