package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

}
