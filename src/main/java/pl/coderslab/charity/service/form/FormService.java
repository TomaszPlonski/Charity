package pl.coderslab.charity.service.form;

import pl.coderslab.charity.dto.FormDto;

public interface FormService {

    FormDto createFormDto();
    void donationSuccess(FormDto formDto);

}
