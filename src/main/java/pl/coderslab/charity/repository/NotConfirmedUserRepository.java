package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.NotConfirmedUser;

public interface NotConfirmedUserRepository extends JpaRepository<NotConfirmedUser,Long> {
}