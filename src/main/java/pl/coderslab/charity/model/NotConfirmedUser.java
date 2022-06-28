package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "not_confirmed_users")
@Getter
@Setter
@ToString(exclude = "password") @EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor @Builder
public class NotConfirmedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String email;

    private String password;

    private String role;

    private LocalDateTime createdOn;

    private String token;

    @PrePersist
    public void createdOn(){
        this.createdOn = LocalDateTime.now();
    }

}
