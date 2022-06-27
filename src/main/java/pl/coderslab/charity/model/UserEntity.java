package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = "password") @EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor @Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String email;
    private String password;
    private String role;
    private int enabled;
}
