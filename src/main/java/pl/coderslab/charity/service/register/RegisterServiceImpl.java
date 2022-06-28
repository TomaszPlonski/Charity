package pl.coderslab.charity.service.register;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.NotConfirmedUser;
import pl.coderslab.charity.repository.NotConfirmedUserRepository;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl {

    private final NotConfirmedUserRepository notConfirmedUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void saveNewNotConfirmedUser(RegisterDto register){
        notConfirmedUserRepository.save(NotConfirmedUser.builder()
                        .email(register.getEmail())
                        .password(passwordEncoder.encode(register.getPassword()))
                        .role("ROLE_USER")
                        .token("1234567890")
                        .build());
    }
}
