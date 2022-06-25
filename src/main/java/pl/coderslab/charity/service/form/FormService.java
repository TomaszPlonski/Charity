package pl.coderslab.charity.service.form;

import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.FormDto;

import java.util.List;

public interface FormService {

    List<CategoryDto> getAllCategories();

    FormDto createFormDto();
}
