package pl.coderslab.charity.service.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.FormDto;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    @Override
    public List<CategoryDto> getAllCategories(){
        List<CategoryDto> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(c->
                categories.add(CategoryDto.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .build()));

        return categories;
    }


    @Override
    public FormDto createFormDto(){
        return FormDto.builder()
                .availableCategories(categoryRepository.findAll())
                .availableInstitutions(institutionRepository.findAll())
                .build();
    }
}
