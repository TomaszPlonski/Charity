package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer quantity;

    @ManyToMany
    @JoinTable(
            name = "donations_categories",
            joinColumns = @JoinColumn(name="donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categories;

    @ManyToOne @JoinColumn(name="institution_id")
    Institution institution;

    String street;

    String city;

    String zipCode;

    LocalDate pickUpDate;

    LocalTime pickUpTime;

    String pickUpComment;
}
