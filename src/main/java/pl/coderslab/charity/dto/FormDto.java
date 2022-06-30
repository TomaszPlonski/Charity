package pl.coderslab.charity.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.validators.formGroups.Form1Validation;
import pl.coderslab.charity.service.validators.formGroups.Form2Validation;
import pl.coderslab.charity.service.validators.formGroups.Form3Validation;
import pl.coderslab.charity.service.validators.formGroups.Form4Validation;

import javax.validation.constraints.*;
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

    @Min(value =1, message="Musi być przynajmniej jeden worek", groups = Form2Validation.class)
    @Digits(integer=10, fraction=0, message = "Podaj liczbę worków")
    Integer quantity;

    @NotEmpty(message = "Wybierz przynajmniej jedną kategorię" , groups = Form1Validation.class)
    List<Category> categories;

    @NotNull(message = "Wybierz fundację" , groups = Form3Validation.class)
    Institution institution;

    @Size(min = 3, max = 100, groups = Form4Validation.class)
    String street;

    @Size(min = 3, max = 100, groups = Form4Validation.class)
    String city;

    @Size(min = 5, max = 6, groups = Form4Validation.class)
    String zipCode;

    @NotNull(message = "Wybierz dzień odbioru" , groups = Form4Validation.class)
    @Future(message = "Wybierz dzień z przyszłości" , groups = Form4Validation.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate pickUpDate;


    @NotNull(message = "Wybierz godzinę", groups = Form4Validation.class)
    LocalTime pickUpTime;

    String pickUpComment;

    List<Category> availableCategories;

    List<Institution> availableInstitutions;

}
