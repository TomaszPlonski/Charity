package pl.coderslab.charity.model;


import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;
}
