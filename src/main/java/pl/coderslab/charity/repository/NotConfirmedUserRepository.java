package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.NotConfirmedUser;

import java.util.Optional;

public interface NotConfirmedUserRepository extends JpaRepository<NotConfirmedUser,Long> {

    Optional<NotConfirmedUser> findByToken(String token);

    NotConfirmedUser findByEmail(String email);
}
