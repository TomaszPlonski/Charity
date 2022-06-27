package pl.coderslab.charity.service.security;

import pl.coderslab.charity.model.UserEntity;

public interface UserService {

    UserEntity findByUserEmail(String email);

    void saveUser(UserEntity user);
}
