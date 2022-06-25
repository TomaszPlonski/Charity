package pl.coderslab.charity.service.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.HomeDto;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService{

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    @Override
    public HomeDto getInfoForHomePage(){
        return HomeDto.builder()
                .donationsQuantity(donationRepository.count())
                .bagsQuantity(donationRepository.selectTotalsQuantity())
                .institutions(institutionRepository.findAll())
                .build();
    }

}
