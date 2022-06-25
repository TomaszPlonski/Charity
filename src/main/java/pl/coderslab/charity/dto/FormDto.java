package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
