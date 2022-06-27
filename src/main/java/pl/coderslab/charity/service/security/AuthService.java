package pl.coderslab.charity.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.model.UserEntity;

import java.util.HashSet;
import java.util.Set;

public class AuthService implements UserDetailsService {

    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userService.findByUserEmail(email);

        if(user==null){
            throw new UsernameNotFoundException("No user with email " + email);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new User(user.getEmail(),user.getPassword(),grantedAuthorities);

    }

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

}
