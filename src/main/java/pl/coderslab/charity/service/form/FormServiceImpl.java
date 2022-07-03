package pl.coderslab.charity.service.form;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.FormDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.email.EmailSenderService;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final EmailSenderService emailSenderService;

    @Override
    public FormDto createFormDto(){
        return FormDto.builder()
                .availableCategories(categoryRepository.findAll())
                .availableInstitutions(institutionRepository.findAll())
                .build();
    }

    private void saveForm(FormDto formDto){
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

    private void sentDonateConfirmationEmail(FormDto formDto, String email){
        String body = String.format("The courier will arrive on: %s at: %s\n" +
                "to address: \n" +
                "city: %s\n" +
                "street: %s\n" +
                "zip-code: %s\n" +
                "Pick up %d bags of stuff for: %s",
                formDto.getPickUpDate(),formDto.getPickUpTime(),
                formDto.getCity(),
                formDto.getStreet(),
                formDto.getZipCode(),
                formDto.getQuantity(),
                formDto.getInstitution().getName());

        emailSenderService.sendEmail(email,
                "Thank you for donating",
                body);
    }


    private String getLoggedUserEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    @Transactional
    @Override
    public void donationSuccess(FormDto formDto){
        saveForm(formDto);
        sentDonateConfirmationEmail(formDto,getLoggedUserEmail());

    }


}
