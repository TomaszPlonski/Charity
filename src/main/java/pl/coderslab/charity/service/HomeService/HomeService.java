package pl.coderslab.charity.service.HomeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public HomeServicePOJO getInfoForHomePage(){
        return HomeServicePOJO.builder()
                .donationsQuantity(donationRepository.count())
                .bagsQuantity(donationRepository.selectTotalsQuantity())
                .institutions(institutionRepository.findAll())
                .build();
    }

}
