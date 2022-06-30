package pl.coderslab.charity.service.register;

import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.NotConfirmedUser;

public interface RegisterService {

    void registerNewUser(RegisterDto registerDto);

    NotConfirmedUser saveNewNotConfirmedUser(RegisterDto register);

    void sentVerificationEmail(NotConfirmedUser notConfirmedUser);

    boolean verification(String token);
}
