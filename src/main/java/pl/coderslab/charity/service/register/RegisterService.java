package pl.coderslab.charity.service.register;

import pl.coderslab.charity.dto.RegisterDto;
import pl.coderslab.charity.model.NotConfirmedUser;

public interface RegisterService {

    void sentEmailIfAvailable(RegisterDto registerDto);

    boolean verification(String token);


}
