package pl.coderslab.charity.dto;

import lombok.*;

@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    Long id;

    String name;
}
