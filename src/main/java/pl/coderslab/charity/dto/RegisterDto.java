package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.charity.service.validators.FieldsValueMatch;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "password2",
                message = "Passwords do not match!"
        )})
public class RegisterDto {

    @NotBlank @Length(min = 3)
    private String email;

    @NotBlank @Length(min = 3)
    private String password;

    private String password2;

}
