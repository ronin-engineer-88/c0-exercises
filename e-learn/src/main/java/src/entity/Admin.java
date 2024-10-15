package src.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity {

    @Column(name = "status")
    private String status;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}