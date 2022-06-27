package pl.coderslab.charity.service.security;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.UserEntity;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        user.setRole("ROLE_USER");
        userRepository.save(user);

    }
}
