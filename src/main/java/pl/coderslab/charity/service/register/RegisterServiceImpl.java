package pl.coderslab.charity.service.register;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.NotConfirmedUser;
import pl.coderslab.charity.model.UserEntity;
import pl.coderslab.charity.repository.NotConfirmedUserRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.email.EmailSenderService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService{

    private final NotConfirmedUserRepository notConfirmedUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;
    private final UserRepository userRepository;

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

    @Transactional
    @Override
    public boolean verification(String token, Long lifeSpanInMinutes){
        NotConfirmedUser notConfirmedUser = notConfirmedUserRepository.findByToken(token)
                .orElseThrow(()-> new IllegalArgumentException("No such token"));

        if(isTokenAlive(notConfirmedUser.getCreatedOn(),lifeSpanInMinutes)){
            saveNewUser(notConfirmedUser);
            deleteVerifyNotConfirmedUser(notConfirmedUser);
            return true;
        } else {
            throw new IllegalArgumentException("Token expired");
        }

    }

    public boolean isTokenAlive(LocalDateTime createdOn, Long lifeSpanInMinutes){
        return LocalDateTime.now().isBefore(createdOn.plusMinutes(lifeSpanInMinutes));
    }

    public void saveNewUser(NotConfirmedUser notConfirmedUser){
        userRepository.save(UserEntity.builder()
                        .email(notConfirmedUser.getEmail())
                        .role(notConfirmedUser.getRole())
                        .password(notConfirmedUser.getPassword())
                        .enabled(1)
                        .build());
    }

    public void deleteVerifyNotConfirmedUser(NotConfirmedUser notConfirmedUser){
        notConfirmedUserRepository.delete(notConfirmedUser);
    }

}
