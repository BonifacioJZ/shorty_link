package com.bonifacio.shorty_link.entities;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "urls")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @Lob
    @NotBlank
    @NotEmpty
    @Column()
    protected String link;

    @NotEmpty
    @NotBlank
    @Column
    protected String slug;

    @CreationTimestamp
    @Column(name = "create_at")
    protected Instant createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    protected Instant updateAt;
}
