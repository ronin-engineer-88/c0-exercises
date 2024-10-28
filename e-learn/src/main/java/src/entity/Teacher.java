package src.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> courses;
}
