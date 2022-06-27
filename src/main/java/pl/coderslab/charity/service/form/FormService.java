package pl.coderslab.charity.service.form;

import pl.coderslab.charity.dto.FormDto;

public interface FormService {

    FormDto createFormDto();

    void saveForm(FormDto formDto);
}
