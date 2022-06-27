package pl.coderslab.charity.service.form;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.FormDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    @Override
    public FormDto createFormDto(){
        return FormDto.builder()
                .availableCategories(categoryRepository.findAll())
                .availableInstitutions(institutionRepository.findAll())
                .build();
    }

    @Transactional
    @Override
    public void saveForm(FormDto formDto){
        donationRepository.save(Donation.builder()
                        .quantity(formDto.getQuantity())
                        .categories(formDto.getCategories())
                        .institution(formDto.getInstitution())
                        .street(formDto.getStreet())
                        .city(formDto.getCity())
                        .zipCode(formDto.getZipCode())
                        .pickUpDate(formDto.getPickUpDate())
                        .pickUpTime(formDto.getPickUpTime())
                        .pickUpComment(formDto.getPickUpComment())
                        .build());

    }


}
