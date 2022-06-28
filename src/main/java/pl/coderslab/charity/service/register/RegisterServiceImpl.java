package pl.coderslab.charity.service.register;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.NotConfirmedUser;
import pl.coderslab.charity.repository.NotConfirmedUserRepository;
import pl.coderslab.charity.service.email.EmailSenderService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService{

    private final NotConfirmedUserRepository notConfirmedUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;

    @Override
    public void registerNewUser(RegisterDto registerDto){
        sentVerificationEmail(saveNewNotConfirmedUser(registerDto));
    }


    @Override
    public NotConfirmedUser saveNewNotConfirmedUser(RegisterDto register){
        return notConfirmedUserRepository.save(NotConfirmedUser.builder()
                        .email(register.getEmail())
                        .password(passwordEncoder.encode(register.getPassword()))
                        .role("ROLE_USER")
                        .token(generateToken())
                        .build());
    }

    public String generateToken(){
        return UUID.randomUUID().toString();
    }

    @Override
    public void sentVerificationEmail(NotConfirmedUser notConfirmedUser){
        emailSenderService.sendEmail(notConfirmedUser.getEmail(),
                "Charity app - verify your email",
                "To end registration on charity app please click on this link: "
                        + "http://localhost:8080/ver/" + notConfirmedUser.getToken());
    }
}
