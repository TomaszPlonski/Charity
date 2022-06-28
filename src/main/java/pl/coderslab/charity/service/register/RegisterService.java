package pl.coderslab.charity.service.register;

import pl.coderslab.charity.dto.RegisterDto;

public interface RegisterService {

    void saveNewNotConfirmedUser(RegisterDto register);
}
