package dasturlash.uz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "attaches")
@Getter
@Setter
public class AttachEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "origin_name", nullable = false)
    private String originName;

    @Column(name = "size", nullable = false)
    private Long size; // Fayl hajmi (byte)

    @Column(name = "type", nullable = false)
    private String type; // mp4, jpg, png, pdf ...

    @Column(name = "path", nullable = false)
    private String path; // Fayl saqlangan yo'l

    @Column(name = "duration")
    private Long duration; // Video yoki audio davomiyligi (sekund)
}
