package pl.coderslab.charity.dto;

import lombok.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormDto {

    Long id;

    Integer quantity;

    List<Category> categories;

    Institution institution;

    String street;

    String city;

    String zipCode;

    LocalDate pickUpDate;

    LocalTime pickUpTime;

    String pickUpComment;

    List<Category> availableCategories;

    List<Institution> availableInstitutions;

}
