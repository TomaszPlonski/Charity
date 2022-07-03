package pl.coderslab.charity.service.register;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${token.minutesOfLifespan}")
    private Long tokenLifeSpan;

    private final NotConfirmedUserRepository notConfirmedUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;
    private final UserRepository userRepository;

    private void registerNewUser(RegisterDto registerDto){
        sentVerificationEmail(saveNewNotConfirmedUser(registerDto));
    }

    private NotConfirmedUser saveNewNotConfirmedUser(RegisterDto register){
        return notConfirmedUserRepository.save(NotConfirmedUser.builder()
                        .email(register.getEmail())
                        .password(passwordEncoder.encode(register.getPassword()))
                        .role("ROLE_USER")
                        .token(generateToken())
                        .build());
    }

    protected String generateToken(){
        return UUID.randomUUID().toString();
    }

    protected void sentVerificationEmail(NotConfirmedUser notConfirmedUser){
        emailSenderService.sendEmail(notConfirmedUser.getEmail(),
                "Charity app - verify your email",
                "To end registration on charity app please click on this link: "
                        + "http://localhost:8080/ver/" + notConfirmedUser.getToken());
    }

    @Transactional
    @Override
    public boolean verification(String token){
        NotConfirmedUser notConfirmedUser = notConfirmedUserRepository.findByToken(token)
                .orElseThrow(()-> new IllegalArgumentException("No such token"));

        if(isTokenAlive(notConfirmedUser.getCreatedOn())){
            saveNewUser(notConfirmedUser);
            deleteVerifyNotConfirmedUser(notConfirmedUser);
            return true;
        } else {
            throw new IllegalArgumentException("Token expired");
        }

    }

    private boolean isTokenAlive(LocalDateTime createdOn){
        return LocalDateTime.now().isBefore(createdOn.plusMinutes((tokenLifeSpan)));
    }

    private void saveNewUser(NotConfirmedUser notConfirmedUser){
        userRepository.save(UserEntity.builder()
                        .email(notConfirmedUser.getEmail())
                        .role(notConfirmedUser.getRole())
                        .password(notConfirmedUser.getPassword())
                        .enabled(1)
                        .build());
    }

    private void deleteVerifyNotConfirmedUser(NotConfirmedUser notConfirmedUser){
        notConfirmedUserRepository.delete(notConfirmedUser);
    }

    private boolean isEmailAvailable(String email){
         if (userRepository.findByEmail(email) == null){
             NotConfirmedUser notConfirmedUser = notConfirmedUserRepository.findByEmail(email);
             if (notConfirmedUser != null){
                 return !isTokenAlive(notConfirmedUser.getCreatedOn());
             }
             return true;
         }
         return false;
    }

    @Override
    public void sentEmailIfAvailable(RegisterDto registerDto){
        if(isEmailAvailable(registerDto.getEmail())){
            registerNewUser(registerDto);
        }
    }

}
