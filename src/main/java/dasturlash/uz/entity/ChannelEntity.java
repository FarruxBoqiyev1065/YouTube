package dasturlash.uz.entity;

import dasturlash.uz.enums.ChannelStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "channels")
@Getter
@Setter
public class ChannelEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 150)
    private String name;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private AttachEntity photo;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ChannelStatus status;

    @Column(name = "banner", nullable = false)
    private String banner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false, unique = true)
    private ProfileEntity profile;
}
