package pl.coderslab.charity.service.HomeService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.charity.model.Institution;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeServicePOJO {

    List<Institution> institutions;

    long bagsQuantity;

    long donationsQuantity;

}
